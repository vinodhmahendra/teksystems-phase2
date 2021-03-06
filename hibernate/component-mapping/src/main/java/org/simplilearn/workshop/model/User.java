package org.simplilearn.workshop.model;

public class User {
	
	private int id;
	private String name;
	
	private ProteinData proteinData = new ProteinData();
	
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}
	
	public ProteinData getProteinData() {
		return proteinData;
	}
	
	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
