package connection;

import java.util.ArrayList;
import java.util.List;

import com.orientechnologies.orient.core.record.OVertex;

import entity.Country;
import entity.Person;

public interface CountryDAO {
	public void createSchema();

	public OVertex createCountry(String identifier, String name, String describe);

	public OVertex createCountryAll(String identifier, String name, String describe, String capital,
			String officialLanguages, String acreage);

	public void deleteCountry(String id);

	public Country getCountry(String id);

	public List<Country> listCountry();
	
	public void addListCountry(ArrayList<Country> l);
}
