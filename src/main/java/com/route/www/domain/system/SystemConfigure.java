package com.route.www.domain.system;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Document
public class SystemConfigure implements Serializable {

	private static final long serialVersionUID = -2280331107433603589L;

	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;

	@TextIndexed
	private String configName;
	
	private String configValue;
	
	private String configDesc;
	
	private String isEnable;
	
	@Override
	public String toString() {
		return String.format("SystemConfigure[id=%s, configName=%s, value=%s]", id, configName, configValue);
	}
}
