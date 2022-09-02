package com.cms.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalException extends Exception {

	private static final Logger l = LoggerFactory.getLogger(GlobalException.class);

	public GlobalException(String message) {
		super(message);

		l.error(message + " occured at " + new java.util.Date());
	}
}
