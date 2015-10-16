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
import com.interview.entity.User;

public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		User user = (User) authentication.getPrincipal();
		ObjectWriter ow = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		String authObject = ow.writeValueAsString(user);
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentLength(authObject.length());

		PrintWriter pw = response.getWriter();

		pw.write(authObject);
		pw.flush();
		pw.close();
	}
}
