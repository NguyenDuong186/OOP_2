package connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

import entity.Country;

public class CountryDAOImp implements CountryDAO {

	@Override
	public void createSchema() {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		OClass country = db.getClass("Country");
		if (country == null) {
			country = db.createVertexClass("Country");
		}
		if (country.getProperty("name") == null) {
			country.createProperty("name", OType.STRING);
			country.createIndex("country_name_index", OClass.INDEX_TYPE.NOTUNIQUE, "name");
		}
		if (country.getProperty("identifier") == null) {
			country.createProperty("identifier", OType.STRING);
			country.createIndex("country_id_index", OClass.INDEX_TYPE.UNIQUE, "id");
		}
		if (country.getProperty("describe") == null) {
			country.createProperty("describe", OType.STRING);
			country.createIndex("country_describe_index", OClass.INDEX_TYPE.UNIQUE, "describe");
		}
		if (country.getProperty("capital") == null) {
			country.createProperty("capital", OType.STRING);
			country.createIndex("country_capital_index", OClass.INDEX_TYPE.UNIQUE, "capital");
		}
		if (country.getProperty("officialLanguage") == null) {
			country.createProperty("officialLanguage", OType.STRING);
			country.createIndex("country_officialLanguage_index", OClass.INDEX_TYPE.UNIQUE, "officialLanguage");
		}
		if (country.getProperty("acreage") == null) {
			country.createProperty("acreage", OType.STRING);
			country.createIndex("country_acreage_index", OClass.INDEX_TYPE.UNIQUE, "acreage");
		}
		db.close();

	}

	@Override
	public OVertex createCountry(String identifier, String name, String describe) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		OVertex result = db.newVertex("Country");
		result.setProperty("identifier", identifier);
		result.setProperty("name", name);
		result.setProperty("describe", describe);
		result.save();
		db.close();
		return result;
	}

	@Override
	public OVertex createCountryAll(String identifier, String name, String describe, String capital,
			String officialLanguages, String acreage) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		OVertex result = db.newVertex("Country");
		result.setProperty("identifier", identifier);
		result.setProperty("name", name);
		result.setProperty("describe", describe);
		result.setProperty("capital", capital);
		result.setProperty("officialLanguage", officialLanguages);
		result.setProperty("acreage", acreage);
		result.save();
		db.close();
		return result;
	}

	@Override
	public void deleteCountry(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String query = "DELETE VERTEX Country WHERE identifier = ?" ;
		OResultSet rs = db.query(query, id);
		rs.close();
	}

	@Override
	public Country getCountry(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String query = "SELECT * FROM Country WHERE identifier = '"+id+"'" ;
		OResultSet rs = db.query(query);
		Country country = null;
		while (rs.hasNext()) {
			OResult item = rs.next();
			String iden = item.getProperty("identifier");
			String name = item.getProperty("name");
			String des = item.getProperty("describe");
			String capital = item.getProperty("capital");
			String officialLanguages = item.getProperty("officialLanguage");
			String acreage = item.getProperty("acreage");

			country = new Country(iden, name, des, capital, officialLanguages, acreage);
		}
		rs.close();
		db.close();
		return country;
	}

	@Override
	public List<Country> listCountry() {
		ODatabaseSession db = null;
		try {
			db = (ODatabaseSession) orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Country ";
		List<Country> list = new ArrayList<Country>();
		OResultSet rs = db.query(query);
		while (rs.hasNext()) {
			OResult item = rs.next();
			String iden = item.getProperty("identifier");
			String name = item.getProperty("name");
			String des = item.getProperty("describe");
			String capital = item.getProperty("capital");
			String officialLanguages = item.getProperty("officialLanguage");
			String acreage = item.getProperty("acreage");
			list.add(new Country(iden, name, des, capital, officialLanguages, acreage));
		}
		rs.close();
		db.close();
		return list;
	}

	@Override
	public void addListCountry(ArrayList<Country> l) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		for(int i=0;i<l.size();i++) {
			OVertex result = db.newVertex("Person");
			result.setProperty("identifier", l.get(i).getIdentifier());
			result.setProperty("name", l.get(i).getName());
			result.setProperty("describe", l.get(i).getDescribe());
			result.setProperty("capital", l.get(i).getCapital());
			result.setProperty("link", l.get(i).getLink());
			result.setProperty("acreage", l.get(i).getAcreage());
			result.setProperty("officialLanguage", l.get(i).getOfficialLanguages());
			
			result.save();
		}
		db.close();
		
	}

}
