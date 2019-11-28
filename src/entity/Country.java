package entity;

public class Country extends Entity {
	private String capital;
	private String officialLanguage;
	private String acreage;

	@Override
	public String toString() {
		return "Country [name:" + this.getName() + ",identifier:" + this.getIdentifier() + ",describe:"
				+ this.getDescribe() + "capital=" + capital + ", officialLanguages=" + officialLanguage + ", acreage="
				+ acreage + "]";
	}

	public Country(String identifier, String name, String describe) {
		super(identifier, name, describe);
		// TODO Auto-generated constructor stub
	}

	public String getCapital() {
		return capital;
	}

	public Country(String identifier, String name, String describe, String capital, String officialLanguages,
			String acreage) {
		super(identifier, name, describe);
		this.capital = capital;
		this.officialLanguage = officialLanguages;
		this.acreage = acreage;
	}

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getOfficialLanguages() {
		return officialLanguage;
	}

	public void setOfficialLanguages(String officialLanguages) {
		this.officialLanguage = officialLanguages;
	}

	public String getAcreage() {
		return acreage;
	}

	public void setAcreage(String acreage) {
		this.acreage = acreage;
	}

}
