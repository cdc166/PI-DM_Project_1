package com.cs336.auction;

public class Item {
	private int id;
	private String name;
	private String description;
	private double startingBid;
	
	public Item(int id, String name, String description, double startingBid) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.startingBid = startingBid;
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

		public String getDescription() {
		return description;
	}

		public void setDescription(String description) {
		this.description = description;
	}

		public double getStartingBid() {
		return startingBid;
	}

		public void setStartingBid(double startingBid) {
		this.startingBid = startingBid;
	}
}
