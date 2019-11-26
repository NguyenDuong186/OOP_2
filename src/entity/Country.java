package entity;

public class Country extends Entity {
	
	@Override
	public String toString() {
		return "Country [name:"+this.getName()+",identifier:"+this.getIdentifier()+",describe:"+this.getDescribe()+"capital=" + capital + ", officialLanguages=" + officialLanguages + ", acreage=" + acreage
				+ "]";
	}
	public Country(String identifier, String name, String describe) {
		super(identifier, name, describe);
		// TODO Auto-generated constructor stub
	}
	private String capital;
	private String officialLanguages;
	private String acreage;
	public String getCapital() {
		return capital;
	}
	public Country(String identifier, String name, String describe, String capital, String officialLanguages,
			String acreage) {
		super(identifier, name, describe);
		this.capital = capital;
		this.officialLanguages = officialLanguages;
		this.acreage = acreage;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getOfficialLanguages() {
		return officialLanguages;
	}
	public void setOfficialLanguages(String officialLanguages) {
		this.officialLanguages = officialLanguages;
	}
	public String getAcreage() {
		return acreage;
	}
	public void setAcreage(String acreage) {
		this.acreage = acreage;
	}
	
	
}
