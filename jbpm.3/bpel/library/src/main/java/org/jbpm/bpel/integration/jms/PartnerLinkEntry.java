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
package org.jbpm.bpel.integration.jms;

import javax.jms.Destination;

import org.jbpm.bpel.app.AppPartnerRole.Initiate;
import org.jbpm.bpel.integration.exe.EndpointReference;

/**
 * @author Alejandro Gu�zar
 * @version $Revision: 1.2 $ $Date: 2006/08/21 01:05:59 $
 */
public class PartnerLinkEntry {

  private String portName;

  private Destination destination;
  private EndpointReference myReference;

  private Initiate partnerInitiate;
  private EndpointReference partnerReference;

  public String getPortName() {
    return portName;
  }

  public void setPortName(String portName) {
    this.portName = portName;
  }

  public Destination getDestination() {
    return destination;
  }

  public void setDestination(Destination destination) {
    this.destination = destination;
  }

  public EndpointReference getMyReference() {
    return myReference;
  }

  public void setMyReference(EndpointReference myReference) {
    this.myReference = myReference;
  }

  public Initiate getPartnerInitiate() {
    return partnerInitiate;
  }

  public void setPartnerInitiate(Initiate initiate) {
    this.partnerInitiate = initiate;
  }

  public EndpointReference getPartnerReference() {
    return partnerReference;
  }

  public void setPartnerReference(EndpointReference partnerReference) {
    this.partnerReference = partnerReference;
  }
}
