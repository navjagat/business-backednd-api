package com.interview.secessentials;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Filter that sends CSRF-token as cookie to the
 * request to client. 
 * 
 * @author navneet.prabhakar
 * @since phase 1
 * @version 1.0
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CsrfTokenFilter extends OncePerRequestFilter {
	
	private static final String ORIGIN = "Origin";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		if(csrf!=null){
			String token = csrf.getToken();
			Cookie cookie = new Cookie("XSRF-TOKEN", token);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		/*filterChain.doFilter(request, response);*/
		  if (request.getHeader(ORIGIN) == null || request.getHeader(ORIGIN).equals("null")) {
	            response.addHeader("Access-Control-Allow-Origin", "*");
	            response.setHeader("Access-Control-Allow-Credentials", "true");
	            response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
	            response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
	            response.setHeader("Access-Control-Max-Age", "3600");
	        }
	        if (request.getMethod().equals("OPTIONS")) {
	            try {
	                response.getWriter().print("OK");
	                response.getWriter().flush();
	            } catch (IOException e) {
	            e.printStackTrace();
	            }
	        } else{
	            filterChain.doFilter(request, response);
	        }
	}

}
