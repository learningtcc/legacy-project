
package com.zyf.framework.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * ��ֹ JSP ��ȡ����,����session��threadlocal��
 * @since 2005-11-30
 * @author ��һ��
 * @version 1.0
 */
public class ForceResponseNoCacheFilter extends OncePerRequestFilter {

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		response.addHeader("Cache-Control", "no-cache");
		response.addHeader("Pragma", "no-cache");
		response.addHeader("Expires", "-1");
		filterChain.doFilter(request, response);
	}

}
