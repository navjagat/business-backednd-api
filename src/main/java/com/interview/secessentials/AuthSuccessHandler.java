package com.interview.secessentials;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	private String redirectUrl;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		//User user = (User) authentication.getPrincipal();
		ObjectWriter ow = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		String authObject = ow.writeValueAsString(authentication.getPrincipal());
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentLength(authObject.length());
		
		response.sendRedirect(redirectUrl);
		PrintWriter pw = response.getWriter();

		pw.write(authObject);
		pw.flush();
		pw.close();
	}

	/**
	 * @param redirectUrl the redirectUrl to set
	 */
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
}
