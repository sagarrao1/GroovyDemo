package com.groovy.unittest

class InsufficiantFundsException extends Exception {

	public InsufficiantFundsException(String message) {
		super(message);
		println message
	}
	
}
