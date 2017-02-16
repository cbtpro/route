package com.route.www.common;

public enum Role {

		INITIATOR("initiator"),  //发起者
		PARTICIPANT("participant");  //参与者
	private final String value;
	//构造器默认也只能是private, 从而保证构造函数只能在内部使用
	Role(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
