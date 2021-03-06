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
package org.jbpm.webapp.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogFilter implements Filter {

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    
    log.debug("request "+request.getRequestURL());
    
    Enumeration enumeration = request.getParameterNames();
    while (enumeration.hasMoreElements()) {
      String paramName = (String) enumeration.nextElement();
      log.debug("request parameter ["+paramName+"]="+request.getParameter(paramName));
    }

    HttpSession session = request.getSession();
    enumeration = session.getAttributeNames();
    while (enumeration.hasMoreElements()) {
      String attributeName = (String) enumeration.nextElement();
      log.debug("session parameter ["+attributeName+"]="+session.getAttribute(attributeName));
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

  public void init(FilterConfig filterConfig) throws ServletException {
  }

  public void destroy() {
  }
  
  private static final Log log = LogFactory.getLog(LogFilter.class);
}
