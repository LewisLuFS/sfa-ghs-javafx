package com.sfa.common.exception;

public class SfaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String messageKey;

	private String[] messageArgs;

	public SfaException() {
		super();
	}

	public SfaException(String message) {
		super(message);
	}

	public SfaException(Throwable throwable) {
		super(throwable);
	}

	public SfaException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public SfaException(String messageKey, String message) {
		super(message);
		this.messageKey = messageKey;
	}

	public SfaException(String messageKey, String messageArgs, String message) {
		super(message);
		this.messageKey = messageKey;
		this.messageArgs = new String[] { messageArgs };
	}

	public SfaException(String messageKey, String[] messageArgs, String message) {
		super(message);
		this.messageKey = messageKey;
		this.messageArgs = messageArgs;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public String[] getMessageArgs() {
		return messageArgs;
	}
}
