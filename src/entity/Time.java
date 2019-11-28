package entity;

public class Time extends Entity{

	@Override
	public String toString() {
		return "Time [name:"+this.getName()+",identifier:"+this.getIdentifier()+",describe:"+this.getDescribe()+"]";
	}

	public Time(String identifier, String name, String describe) {
		super(identifier, name, describe);
		// TODO Auto-generated constructor stub
	}

	public Time() {
		// TODO Auto-generated constructor stub
	}

}