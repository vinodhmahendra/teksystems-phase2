package org.simplilearn.workshop.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private int goal;
	private int total;
	
	private List<UserHistory> history = new ArrayList<UserHistory>();
	
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

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<UserHistory> getHistory() {
		return history;
	}

	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}
	
	public void addHistory(UserHistory item) {
		item.setUser(this);
		history.add(item);
	}
	

}
