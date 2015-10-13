package com.interview.secessentials;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {

		response.setContentType("application/json");

		String error = "{\"error\":\"" + exception.getMessage() + "\"}";

		response.setContentLength(error.length());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		PrintWriter pw = response.getWriter();
		pw.write(error);
		pw.flush();
		pw.close();
	}
}
