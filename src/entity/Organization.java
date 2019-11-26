package entity;

public class Organization extends Entity{
	public Organization(String identifier, String name, String describe, String headquarters) {
		super(identifier, name, describe);
		this.headquarters = headquarters;
	}

	public Organization(String identifier, String name, String describe) {
		super(identifier, name, describe);
		// TODO Auto-generated constructor stub
	}

	private String headquarters;

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}
	

}
