/*
 * @(#)file      JDMInformItem.java
 * @(#)author    Sun Microsystems, Inc.
 * @(#)version   1.5
 * @(#)date      04/09/15
 *
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/* Generated By:JJTree: Do not edit this line. JDMInformItem.java */

package com.sun.jmx.snmp.IPAcl;

class JDMInformItem extends SimpleNode {
    protected JDMInformCommunity comm = null;
    JDMInformItem(int id) {
        super(id);
    }

    JDMInformItem(Parser p, int id) {
        super(p, id);
    }

    public static Node jjtCreate(int id) {
        return new JDMInformItem(id);
    }

    public static Node jjtCreate(Parser p, int id) {
        return new JDMInformItem(p, id);
    }
  
    public JDMInformCommunity getCommunity(){
        return comm;
    }
}
