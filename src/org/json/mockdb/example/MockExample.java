package org.json.mockdb.example;

import java.util.List;

import org.json.mockdb.MockItem;

public class MockExample implements MockItem{
	private String uuid;
	private int someInt;
	private Boolean someBoolean;
	private List<Integer> someList;
	
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public int getSomeInt() {
		return someInt;
	}
	
	public void setSomeInt(int someInt) {
		this.someInt = someInt;
	}
	
	public Boolean getSomeBoolean() {
		return someBoolean;
	}
	
	public void setSomeBoolean(Boolean someBoolean) {
		this.someBoolean = someBoolean;
	}
	
	public List<Integer> getSomeList() {
		return someList;
	}
	
	public void setSomeList(List<Integer> someList) {
		this.someList = someList;
	}

	@Override
	public String getFileName() {
		return "MockExample";
	}

	@Override
	public void setId(String id) {
		this.setUuid(id);
	}

	@Override
	public String getId() {
		return this.getUuid();
	}
	
}
