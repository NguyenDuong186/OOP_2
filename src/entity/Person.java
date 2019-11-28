package entity;

public class Person extends Entity{
	private	String dob;//dateOfBirth
	private String profession;
	private String nationality;
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Person(String identifier, String name, String describe, String dob, String profession, String nationality) {
		super(identifier, name, describe);
		this.dob = dob;
		this.profession = profession;
		this.nationality = nationality;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Person(String identifier, String name, String describe) {
		super(identifier, name, describe);
		// TODO Auto-generated constructor stub
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Person [name:"+this.getName()+",identifier:"+this.getIdentifier()+",describe:"+this.getDescribe()+"dob:" + dob + ", profession:" + profession + ", nationality:" + nationality + "]";
	}
	
	
}
