package org.grozeille;

import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.Tag;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.fasterxml.jackson.databind.jsonSchema.factories.SchemaFactory;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

@ApiModel(value = "The result of an operation")
@XmlRootElement()
public class Result {

    @Tag(1)
    @ApiModelProperty(value = "result of the operation")
    private int value;

    @Tag(2)
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
