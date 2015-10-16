package com.interview.secessentials;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class LazyObjectMapper extends ObjectMapper {
	
	private static final long serialVersionUID = 1L;
	
	public LazyObjectMapper() {
		registerModule(new Hibernate4Module());
	}
}
