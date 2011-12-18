package org.grozeille;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class Result {
	private int value;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
