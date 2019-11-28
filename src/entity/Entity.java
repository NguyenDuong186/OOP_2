package entity;

public class Entity {
	private String identifier;
	private String name;
	private String describe;
	private String link;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public Entity(String identifier, String name, String describe) {
		this.identifier = identifier;
		this.name = name;
		this.describe = describe;
	}
	public Entity() {
		// TODO Auto-generated constructor stub
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
}
