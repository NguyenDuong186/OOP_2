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
import entity.Organization;

public class CountryDAOImp implements CountryDAO {

	@Override
	public void createSchema() {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
		if (country.getProperty("officialLanguages") == null) {
			country.createProperty("officialLanguages", OType.STRING);
			country.createIndex("country_officialLanguages_index", OClass.INDEX_TYPE.UNIQUE, "officialLanguages");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OVertex result = db.newVertex("Country");
		result.setProperty("identifier", identifier);
		result.setProperty("name", name);
		result.setProperty("describe", describe);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OVertex result = db.newVertex("Person");
		result.setProperty("identifier", identifier);
		result.setProperty("name", name);
		result.setProperty("describe", describe);
		result.setProperty("capital", identifier);
		result.setProperty("officialLanguages", name);
		result.setProperty("acreage", describe);
		db.close();
		return result;
	}

	@Override
	public void deleteCountry(String id) {
//		ODatabaseSession db = null;
//		try {
//			db = orientdbConnection.getConnection();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String query = "DELETE VERTEX Country WHERE identificer = " + "?";
//		OResultSet rs = db.query(query, id);
//		rs.close();
//		db.close();

	}

	@Override
	public Country getCountry(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Country WHERE identifier = " ;
		OResultSet rs = db.query(query);
		OResult item = rs.next();
		Country country = null;
		while (item != null) {
			String iden = item.getProperty("identifier");
			String name = item.getProperty("nam");
			String des = item.getProperty("describe");
			String capital = item.getProperty("capital");
			String officialLanguages = item.getProperty("officialLanguages");
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
			String name = item.getProperty("nam");
			String des = item.getProperty("describe");
			String capital = item.getProperty("capital");
			String officialLanguages = item.getProperty("officialLanguages");
			String acreage = item.getProperty("acreage");
			list.add(new Country(iden, name, des, capital, officialLanguages, acreage));
		}
		rs.close();
		db.close();
		return list;
	}

}
