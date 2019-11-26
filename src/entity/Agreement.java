package entity;

public class Agreement extends Entity{
	public Agreement(java.lang.String identifier, java.lang.String name, java.lang.String describe) {
		super(identifier, name, describe);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Agreement [name:"+this.getName()+",identifier:"+this.getIdentifier()+",describe:"+this.getDescribe()+"]";
	}

	

}
