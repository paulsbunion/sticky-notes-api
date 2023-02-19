package com.defrain.stickynotesapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JSON {
	public static String asJsonString(final Object obj) {
		try {
			
			 return new ObjectMapper()
			            .setAnnotationIntrospector(new JacksonAnnotationIntrospector())
			            .registerModule(new JavaTimeModule())
			            .setDateFormat(new StdDateFormat())
			            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
