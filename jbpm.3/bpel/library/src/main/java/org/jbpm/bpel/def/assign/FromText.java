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

import org.jbpm.bpel.def.Assign.From;
import org.jbpm.graph.exe.Token;

/**
 * <code>&lt;from&gt;</code> variant that allows a text literal to be given as
 * the source value to assign to a destination.
 * @author Alejandro Guizar
 * @version $Revision: 1.2 $ $Date: 2006/08/21 01:05:59 $
 */
public class FromText extends From {

  private String literal;

  private static final long serialVersionUID = 1L;

  /** {@inheritDoc} */
  public Object extract(Token token) {
    return literal;
  }

  /**
   * Gets the text literal extracted as source value.
   * @return a text value
   */
  public String getLiteral() {
    return literal;
  }

  /**
   * Sets the text literal to extract as source value.
   * @param literal a text value
   */
  public void setLiteral(String literal) {
    this.literal = literal;
  }
}
