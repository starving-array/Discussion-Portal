package com.socialapp.discussion.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjStr {
	
	private Object obj;
	private String str;
	
	public ObjStr(Object obj) {
		this.obj = obj;
	}
	
	public ObjStr(String str) {
		this.str = str;
	}

	ObjectMapper objectMapper = new ObjectMapper();
	
	public String objToString() {
		String val = null;
		try {
			val = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return val;
	}
	
	
	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public <T> T stringToObj(Class <T> valType) {
		
		try {
			obj = objectMapper.readValue(str, valType);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return (T) obj;
	}
}
