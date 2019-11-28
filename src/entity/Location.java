package entity;

public class Location extends Entity{

	public Location(String identifier, String name, String describe) {
		super(identifier, name, describe);
		// TODO Auto-generated constructor stub
	}

	public Location() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Location [name:"+this.getName()+",identifier:"+this.getIdentifier()+",describe:"+this.getDescribe()+"]";
	}


}
