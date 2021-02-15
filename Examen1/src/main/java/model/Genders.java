package model;

public class Genders {
	private int id;
	private String name;

	public Genders(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Genders() {
		this.id = 0;
		this.name = "";
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
