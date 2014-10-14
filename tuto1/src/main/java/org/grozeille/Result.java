package org.grozeille;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

@ApiModel(value = "The result of an operation")
@XmlRootElement()
public class Result {

    @ApiModelProperty(value = "result of the operation")
    private int value;

    @ApiModelProperty(value = "the operation")
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
