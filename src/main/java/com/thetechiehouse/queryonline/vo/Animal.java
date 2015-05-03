package com.thetechiehouse.queryonline.vo;

public class Animal {
	private int id;
	private String animalName;
	private String animalType;
	private boolean aggressive;
	private int weight;

	public Animal(int id, String animalName, String animalType,
			boolean aggressive, int weight) {
		super();
		this.id = id;
		this.animalName = animalName;
		this.animalType = animalType;
		this.aggressive = aggressive;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public boolean getAggressive() {
		return aggressive;
	}
	public void setAggressive(boolean aggressive) {
		this.aggressive = aggressive;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
