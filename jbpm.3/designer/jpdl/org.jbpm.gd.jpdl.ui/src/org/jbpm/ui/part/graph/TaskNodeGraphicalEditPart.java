/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jbpm.ui.part.graph;

import org.eclipse.draw2d.IFigure;
import org.jbpm.ui.figure.NodeFigure;
import org.jbpm.ui.model.TaskNode;

public class TaskNodeGraphicalEditPart extends NodeGraphicalEditPart {

	public TaskNodeGraphicalEditPart(TaskNode taskNode) {
		super(taskNode);
	}
	
//	protected List getModelChildren() {
//		ArrayList result = new ArrayList();
//		result.add(((TaskNode)getModel()).getTaskList());
//		return result;
//	}
	
	public IFigure getContentPane() {
		return ((NodeFigure)getFigure()).getContentPane();
	}

}
