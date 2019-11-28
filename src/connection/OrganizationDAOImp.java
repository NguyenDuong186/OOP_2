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

import entity.Organization;
import entity.Person;

public class OrganizationDAOImp implements OrganizationDAO {

	@Override
	public void createSchema() {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OClass organization = db.getClass("Organization");
		if (organization == null) {
			organization = db.createVertexClass("Organization");
		}
		if (organization.getProperty("name") == null) {
			organization.createProperty("name", OType.STRING);
			organization.createIndex("organization_name_index", OClass.INDEX_TYPE.NOTUNIQUE, "name");
		}
		if (organization.getProperty("identifier") == null) {
			organization.createProperty("identifier", OType.STRING);
			organization.createIndex("organization_id_index", OClass.INDEX_TYPE.UNIQUE, "id");
		}
		if (organization.getProperty("describe") == null) {
			organization.createProperty("describe", OType.STRING);
			organization.createIndex("organization_describe_index", OClass.INDEX_TYPE.UNIQUE, "describe");
		}
		if (organization.getProperty("headquarters") == null) {
			organization.createProperty("headquarters", OType.STRING);
			organization.createIndex("organization_headquarters_index", OClass.INDEX_TYPE.UNIQUE, "headquarters");
		}
		db.close();

	}

	@Override
	public OVertex createOrg(String identifier, String name, String describe) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OVertex result = db.newVertex("Organization");
		result.setProperty("identifier", identifier);
		result.setProperty("name", name);
		result.setProperty("describe", describe);
		result.save();
		db.close();
		return result;
	}

	@Override
	public OVertex createOrgAll(String identifier, String name, String describe, String headquarters) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OVertex result = db.newVertex("Organization");
		result.setProperty("identifier", identifier);
		result.setProperty("name", name);
		result.setProperty("describe", describe);
		result.setProperty("headquarters", headquarters);
		result.save();
		db.close();
		return result;
	}

	@Override
	public void deleteOrg(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "DELETE VERTEX Organization WHERE identifier = " + "?";
		OResultSet rs = db.query(query, id);
		rs.close();
		db.close();

	}

	@Override
	public Organization getOrg(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Organization WHERE identifier = " + "?";
		OResultSet rs = db.query(query, id);
		Organization org = null;
		while (rs.hasNext()) {
			OResult item = rs.next();
			String iden = item.getProperty("identifier");
			String name = item.getProperty("name");
			String des = item.getProperty("describe");
			String headquarters = item.getProperty("headquarters");
			org = new Organization(iden, name, des,headquarters);
		}
		rs.close();
		db.close();
		return org;
	}

	@Override
	public List<Organization> listOrg() {
		ODatabaseSession db = null;
		try {
			db = (ODatabaseSession) orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Organization ";
		List<Organization> list = new ArrayList<Organization>();
		OResultSet rs = db.query(query);
		while (rs.hasNext()) {
			OResult item = rs.next();
			String iden = item.getProperty("identifier");
			String name = item.getProperty("name");
			String des = item.getProperty("describe");
			String headquarters = item.getProperty("headquarters");
			list.add(new Organization(iden, name, des,headquarters));
		}
		rs.close();
		db.close();
		return list;
	}

	@Override
	public void addListOrganization(ArrayList<Organization> l) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < l.size(); i++) {
			OVertex result = db.newVertex("Person");
			result.setProperty("identifier", l.get(i).getIdentifier());
			result.setProperty("name", l.get(i).getName());
			result.setProperty("describe", l.get(i).getDescribe());
			result.setProperty("link", l.get(i).getLink());
			result.save();
		}
	}

}
