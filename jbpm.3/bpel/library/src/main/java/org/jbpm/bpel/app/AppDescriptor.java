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
package org.jbpm.bpel.app;

import org.jbpm.bpel.integration.catalog.ServiceCatalog;

/**
 * @author Alejandro Gu�zar
 * @version $Revision: 1.2 $ $Date: 2006/08/21 01:05:59 $
 */
public class AppDescriptor extends AppScope {

  private Integer version;
  private String bindSubcontext;
  private ServiceCatalog serviceCatalog;

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getBindSubcontext() {
    return bindSubcontext;
  }

  public void setBindSubcontext(String bindableSubcontext) {
    this.bindSubcontext = bindableSubcontext;
  }

  public ServiceCatalog getServiceCatalog() {
    return serviceCatalog;
  }

  public void setServiceCatalog(ServiceCatalog serviceCatalog) {
    this.serviceCatalog = serviceCatalog;
  }

  public void accept(AppDescriptorVisitor visitor) {
    visitor.visit(this);
  }
}