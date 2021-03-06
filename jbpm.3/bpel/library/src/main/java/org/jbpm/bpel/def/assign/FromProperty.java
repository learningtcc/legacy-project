/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005, JBoss Inc., and individual contributors as indicated
 * by the @authors tag.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the JBPM BPEL PUBLIC LICENSE AGREEMENT as
 * published by JBoss Inc.; either version 1.0 of the License, or
 * (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */
package org.jbpm.bpel.def.assign;

import org.jbpm.bpel.def.Assign;
import org.jbpm.bpel.variable.def.VariableDefinition;
import org.jbpm.bpel.wsdl.Property;
import org.jbpm.graph.exe.Token;

/**
 * <code>&lt;from&gt;</code> variant that explicitly manipulates message
 * properties occurring in variables.
 * @see "WS-BPEL 2.0 &sect;9.3"
 * @author Alejandro Gu�zar
 * @version $Revision: 1.3 $ $Date: 2006/08/21 01:05:59 $
 */
public class FromProperty extends Assign.From {

  private VariableDefinition variable;
  private Property property;

  private static final long serialVersionUID = 1L;

  public Object extract(Token token) {
    return variable.getPropertyValue(property.getQName(), token);
  }

  public VariableDefinition getVariable() {
    return variable;
  }

  public void setVariable(VariableDefinition variable) {
    this.variable = variable;
  }

  public Property getProperty() {
    return property;
  }

  public void setProperty(Property property) {
    this.property = property;
  }
}
