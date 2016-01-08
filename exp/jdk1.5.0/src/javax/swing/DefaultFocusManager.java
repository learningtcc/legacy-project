/*
 * @(#)DefaultFocusManager.java	1.29 03/12/19
 *
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package javax.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.Comparator;


/**
 * This class has been obsoleted by the 1.4 focus APIs. While client code may
 * still use this class, developers are strongly encouraged to use
 * <code>java.awt.KeyboardFocusManager</code> and
 * <code>java.awt.DefaultKeyboardFocusManager</code> instead.
 * <p>
 * Please see
 * <a href="http://java.sun.com/docs/books/tutorial/uiswing/misc/focus.html">
 * How to Use the Focus Subsystem</a>,
 * a section in <em>The Java Tutorial</em>, and the
 * <a href="../../java/awt/doc-files/FocusSpec.html">Focus Specification</a>
 * for more information.
 *
 * @version 1.29, 12/19/03
 * @author Arnaud Weber
 * @author David Mendenhall
 */
public class DefaultFocusManager extends FocusManager {

    final FocusTraversalPolicy gluePolicy =
	new LegacyGlueFocusTraversalPolicy(this);
    private final FocusTraversalPolicy layoutPolicy =
	new LegacyLayoutFocusTraversalPolicy(this);
    private final LayoutComparator comparator =
	new LayoutComparator();

    public DefaultFocusManager() {
	setDefaultFocusTraversalPolicy(gluePolicy);
    }

    public Component getComponentAfter(Container aContainer,
				       Component aComponent)
    {
	Container root = (aContainer.isFocusCycleRoot())
	    ? aContainer
	    : aContainer.getFocusCycleRootAncestor();

	// Support for mixed 1.4/pre-1.4 focus APIs. If a particular root's
	// traversal policy is non-legacy, then honor it.
	if (root != null) {
	    FocusTraversalPolicy policy = root.getFocusTraversalPolicy();
	    if (policy != gluePolicy) {
		return policy.getComponentAfter(root, aComponent);
	    }

	    comparator.setComponentOrientation(root.getComponentOrientation());
	    return layoutPolicy.getComponentAfter(root, aComponent);
	}

	return null;
    }

    public Component getComponentBefore(Container aContainer,
					Component aComponent)
    {
	Container root = (aContainer.isFocusCycleRoot())
	    ? aContainer
	    : aContainer.getFocusCycleRootAncestor();

	// Support for mixed 1.4/pre-1.4 focus APIs. If a particular root's
	// traversal policy is non-legacy, then honor it.
	if (root != null) {
	    FocusTraversalPolicy policy = root.getFocusTraversalPolicy();
	    if (policy != gluePolicy) {
		return policy.getComponentBefore(root, aComponent);
	    }

	    comparator.setComponentOrientation(root.getComponentOrientation());
	    return layoutPolicy.getComponentBefore(root, aComponent);
	}

	return null;
    }

    public Component getFirstComponent(Container aContainer) {
	Container root = (aContainer.isFocusCycleRoot())
	    ? aContainer
	    : aContainer.getFocusCycleRootAncestor();

	// Support for mixed 1.4/pre-1.4 focus APIs. If a particular root's
	// traversal policy is non-legacy, then honor it.
	if (root != null) {
	    FocusTraversalPolicy policy = root.getFocusTraversalPolicy();
	    if (policy != gluePolicy) {
		return policy.getFirstComponent(root);
	    }

	    comparator.setComponentOrientation(root.getComponentOrientation());
	    return layoutPolicy.getFirstComponent(root);
	}

	return null;
    }

    public Component getLastComponent(Container aContainer) {
	Container root = (aContainer.isFocusCycleRoot())
	    ? aContainer
	    : aContainer.getFocusCycleRootAncestor();

	// Support for mixed 1.4/pre-1.4 focus APIs. If a particular root's
	// traversal policy is non-legacy, then honor it.
	if (root != null) {
	    FocusTraversalPolicy policy = root.getFocusTraversalPolicy();
	    if (policy != gluePolicy) {
		return policy.getLastComponent(root);
	    }

	    comparator.setComponentOrientation(root.getComponentOrientation());
	    return layoutPolicy.getLastComponent(root);
	}

	return null;
    }

    public boolean compareTabOrder(Component a, Component b) {
	return (comparator.compare(a, b) < 0);
    }
}

final class LegacyLayoutFocusTraversalPolicy
    extends LayoutFocusTraversalPolicy
{
    LegacyLayoutFocusTraversalPolicy(DefaultFocusManager defaultFocusManager) {
	super(new CompareTabOrderComparator(defaultFocusManager));
    }
}

final class CompareTabOrderComparator implements Comparator {
    private final DefaultFocusManager defaultFocusManager;

    CompareTabOrderComparator(DefaultFocusManager defaultFocusManager) {
	this.defaultFocusManager = defaultFocusManager;
    }

    public int compare(Object o1, Object o2) {
        if (o1 == o2) {
            return 0;
        }
	return (defaultFocusManager.compareTabOrder((Component)o1,
						    (Component)o2)) ? -1 : 1;
    }
}
