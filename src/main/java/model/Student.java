package model;

public class Student {
	private int id;
	private String name;
	private String roll;
	private String section;
	
	public Student(int id, String name, String roll, String section) {
		super();
		this.id = id;
		this.name = name;
		this.roll = roll;
		this.section = section;
	}
	
	public Student(String name, String roll, String section) {
		super();
		this.name = name;
		this.roll = roll;
		this.section = section;
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
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
}
