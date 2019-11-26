package connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.orientechnologies.orient.core.db.ODatabase;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

import entity.Person;

public class PersonDAOImp implements PersonDAO {

	// create class Person if not exist
	public void createSchema() {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OClass person = db.getClass("Person");
		if (person == null) {
			person = db.createVertexClass("Person");
		}
		if (person.getProperty("name") == null) {
			person.createProperty("name", OType.STRING);
			person.createIndex("Person_name_index", OClass.INDEX_TYPE.NOTUNIQUE, "name");
		}
		if (person.getProperty("identifier") == null) {
			person.createProperty("identifier", OType.STRING);
			person.createIndex("Person_id_index", OClass.INDEX_TYPE.UNIQUE, "id");
		}
		if (person.getProperty("describe") == null) {
			person.createProperty("describe", OType.STRING);
			person.createIndex("Person_describe_index", OClass.INDEX_TYPE.UNIQUE, "describe");
		}
		if (person.getProperty("dob") == null) {
			person.createProperty("dob", OType.STRING);
			person.createIndex("Person_dob_index", OClass.INDEX_TYPE.UNIQUE, "dob");
		}
		if (person.getProperty("profession") == null) {
			person.createProperty("profession", OType.STRING);
			person.createIndex("Person_profession_index", OClass.INDEX_TYPE.UNIQUE, "profession");
		}
		if (person.getProperty("nationality") == null) {
			person.createProperty("nationality", OType.STRING);
			person.createIndex("Person_nationality_index", OClass.INDEX_TYPE.UNIQUE, "nationality");
		}
		db.close();

	}

	// add new record person
	public OVertex addPerson(String identifier, String name, String describe) {
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
		result.save();
		db.close();
		return result;
	}

	// delete record
	public void deletePerson(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "DELETE VERTEX Person WHERE identificer = " + "?";
		OResultSet rs = db.query(query, id);

		rs.close();
		db.close();
	}

	// take a record
	public Person getPerson(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Person WHERE identifier = '" + id+"'";
		OResultSet rs = db.query(query);
		//OResult item = rs.next();
		Person p = null;
		while (rs.hasNext()) {
			OResult item = rs.next();
			String iden = item.getProperty("identifier");
			String name = item.getProperty("name");
			String des = item.getProperty("describe");
			String dob = item.getProperty("dob").toString();
			String profession = item.getProperty("profession");
			String nationality = item.getProperty("nationality");
			p = new Person(iden, name, des, dob, profession, nationality);
		}
		rs.close();
		db.close();
		return p;
	}

	// take all person record
	public List<Person> listPerson() {
		ODatabaseSession db = null;
		try {
			db = (ODatabaseSession) orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Person ";
		List<Person> list = new ArrayList<Person>();
		OResultSet rs = db.query(query);
		while (rs.hasNext()) {
			OResult item = rs.next();
			String iden = item.getProperty("identifier");
			String name = item.getProperty("nam");
			String des = item.getProperty("describe");
			String dob = item.getProperty("dob").toString();
			String profession = item.getProperty("profession");
			String nationality = item.getProperty("nationality");
			list.add(new Person(iden, name, des, dob, profession, nationality));
		}
		rs.close();
		db.close();
		return list;

	}

	@Override
	public OVertex addPersonAll(String identifier, String name, String describe, String dob, String profession,String nationality)
			{
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
				result.setProperty("dob", dob);
				result.setProperty("profession", profession);
				result.setProperty("nationality", nationality);
				return result;
			}
	

	

}
