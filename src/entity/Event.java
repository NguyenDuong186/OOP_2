package entity;

public class Event extends Entity{

	@Override
	public String toString() {
		return "Event [name:"+this.getName()+",identifier:"+this.getIdentifier()+",describe:"+this.getDescribe()+"]";
	}

	public Event(String identifier, String name, String describe) {
		super(identifier, name, describe);
		// TODO Auto-generated constructor stub
	}

	
	
}
