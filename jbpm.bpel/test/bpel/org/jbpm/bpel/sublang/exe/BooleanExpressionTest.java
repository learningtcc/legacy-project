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
package org.jbpm.bpel.sublang.exe;

import javax.xml.namespace.QName;

import junit.framework.TestCase;

import org.w3c.dom.Element;

import org.jbpm.bpel.def.BpelDefinition;
import org.jbpm.bpel.def.Empty;
import org.jbpm.bpel.def.Scope;
import org.jbpm.bpel.sublang.def.Expression;
import org.jbpm.bpel.variable.def.ElementType;
import org.jbpm.bpel.variable.def.SchemaType;
import org.jbpm.bpel.variable.def.VariableDefinition;
import org.jbpm.bpel.xml.BpelConstants;
import org.jbpm.bpel.xml.util.DatatypeUtil;
import org.jbpm.bpel.xml.util.XmlUtil;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;

/**
 * @author Alejandro Guizar
 * @version $Revision: 1.1 $ $Date: 2006/08/22 04:13:11 $
 * @see "WS-BPEL 2.0 &sect;9.1.1"
 */
public class BooleanExpressionTest extends TestCase {

  private Token token;
  
  private static final String ELEM1_TEXT = 
    "<a>" +
    "  <b on=\"true\">true</b>" +
    "  <c name=\"venus\"/>" +
    "  <d amount=\"20\"/>" +
    "  <e>30</e>" +
    "</a>";
  private static final String ELEM2_TEXT =
    "<a>" +
    "  <b on=\"false\">false</b>" +
    "  <c name=\"mars\"/>" +
    "  <d amount=\"30\"/>" +
    "  <e>40</e>" +
    "</a>";
  
  public void setUp() throws Exception {
    // process and token
    BpelDefinition pd = new BpelDefinition();
    token = new ProcessInstance(pd).getRootToken();
    Scope scope = pd.getGlobalScope();
    // element variable 1
    Element elem1 = XmlUtil.parseElement(ELEM1_TEXT);
    VariableDefinition var1 = new VariableDefinition();
    var1.setName("var1");
    var1.setType(new ElementType(new QName(elem1.getNamespaceURI(), elem1.getLocalName())));
    scope.addVariable(var1);
    // element variable 2    
    Element elem2 = XmlUtil.parseElement(ELEM2_TEXT);
    VariableDefinition var2 = new VariableDefinition();
    var2.setName("var2");
    var2.setType(new ElementType(new QName(elem2.getNamespaceURI(), elem2.getLocalName())));
    scope.addVariable(var2);
    // simple variable
    VariableDefinition simple = new VariableDefinition();
    simple.setName("simple");
    simple.setType(new SchemaType(new QName(BpelConstants.NS_XML_SCHEMA, "boolean"))); 
    scope.addVariable(simple);
    // initialize variables
    scope.initScopeData(token);
    var1.setValue(token, elem1);
    var2.setValue(token, elem2);
    simple.setValue(token, Boolean.TRUE);
    // provide a way to the variable definition
    Empty activity = new Empty();
    scope.addNode(activity);
    token.setNode(activity);
  }
  
  public void testTrueExtraction() {
    assertTrue(eval("true()"));
  }

  public void testFalseExtraction() {
    assertFalse(eval("false()"));
  }
  
  public void testSimpleExtraction() {
    assertTrue(eval("$simple"));
  }
  
  public void testAttributeExtraction() {        
    assertTrue(eval("$var1/b/@on"));
    assertFalse(eval("$var2/b/@on"));
  }

  public void testContentExtraction() {
    assertTrue(eval("$var1/b"));
    assertFalse(eval("$var2/b"));
  }

  public void testStringEqual() {
    assertTrue(eval("$var1/b/@on = $var1/b"));
  }
  
  public void testStringEqualConst() {
    assertTrue(eval("$var1/b/@on = 'true'"));
  }

  public void testStringNotEqual() {
    assertTrue(eval(
        "$var1/c/@name != $var2/c/@name"));
  }
  
  public void testStringNotEqualConst() {
    assertTrue(eval(
        "$var1/c/@name != 'mars'"));
  }

  public void testNumberEqual() {
    // number() makes the comparison numeric, not textual
    assertTrue(eval(
        "number($var1/e) = $var2/d/@amount"));
  }
  
  public void testNumberEqualConst() {
    // the number literal makes the comparison numeric
    assertTrue(eval("$var1/e = 30"));
  }

  public void testNumberNotEqual() {
    assertTrue(eval(
        "number($var1/d/@amount) != $var2/d/@amount"));
  }
  
  public void testNumberNotEqualConst() {
    assertTrue(eval("$var1/d/@amount != 30"));
  }

  public void testNumberLess() {
    assertTrue(eval("$var1/e < $var2/e"));
  }
  
  public void testNumberLessConst() {
    assertTrue(eval("$var1/e < 50"));  
  }

  public void testNumberLessOrEqual() {
    assertTrue(eval("$var1/e <= $var2/d/@amount"));
    assertFalse(eval("$var1/e < $var2/d/@amount"));
  }
  
  public void testNumberLessOrEqualConst() {
    assertTrue(eval("$var1/e <= 30"));
    assertFalse(eval("$var1/e < 30"));
  }

  public void testNumberMore() {
    assertTrue(eval("$var2/d/@amount > $var1/d/@amount"));
  }
  
  public void testNumberMoreConst() {
    assertTrue(eval("$var2/d/@amount > 20"));
  }

  public void testNumberMoreOrEqual() {
    assertTrue(eval("$var2/d/@amount >= $var1/e"));
    assertFalse(eval("$var2/d/@amount > $var1/e"));
  }
  
  public void testNumberMoreOrEqualConst() {
    assertTrue(eval("$var2/d/@amount >= 30"));
    assertFalse(eval("$var2/d/@amount > 30"));
  }
  
  public void testAnd() {
    /* the odd-looking comparison with 'true' is there because it inspects the 
     * text content of a node, whereas the boolean() function, called when an 
     * implicit conversion to boolean is required, tests for the presence of a node */
    assertTrue(eval("$var1/b = 'true' and $var1/b/@on = 'true'"));
    assertFalse(eval("$var1/b = 'true' and $var2/b = 'true'"));
  }
  
  public void testOr() {
    assertTrue(eval("$var1/b = 'true' or $var2/b = 'true'"));
    assertFalse(eval("$var2/b = 'true' or $var2/b/@on = 'true'"));
  }
  
  private boolean eval(String text) {
    Expression expr = new Expression();
    expr.setText(text);
    return DatatypeUtil.toBoolean(expr.getEvaluator().evaluate(token));
  }
}