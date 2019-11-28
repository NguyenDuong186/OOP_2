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

import entity.Event;
import entity.Location;

public class LocationDAOImp implements LocationDAO{

	@Override
	public void createSchema() {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OClass location = db.getClass("Location");
		if (location == null) {
			location = db.createVertexClass("Location");
		}
		if (location.getProperty("name") == null) {
			location.createProperty("name", OType.STRING);
			location.createIndex("location_name_index", OClass.INDEX_TYPE.NOTUNIQUE, "name");
		}
		if (location.getProperty("identifier") == null) {
			location.createProperty("identifier", OType.STRING);
			location.createIndex("location_id_index", OClass.INDEX_TYPE.UNIQUE, "id");
		}
		if (location.getProperty("describe") == null) {
			location.createProperty("describe", OType.STRING);
			location.createIndex("location_describe_index", OClass.INDEX_TYPE.UNIQUE, "describe");
		}
		
		db.close();
		
	}

	@Override
	public OVertex createLocation(String identifier, String name, String describe) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OVertex result = db.newVertex("Location");
		result.setProperty("identifier", identifier);
		result.setProperty("name", name);
		result.setProperty("describe", describe);
		result.save();
		db.close();
		return result;
	}

	@Override
	public void deleteLocation(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "DELETE VERTEX Location WHERE identifier = " + "?";
		OResultSet rs = db.query(query, id);
		rs.close();
		db.close();
		
	}

	@Override
	public Location getLocation(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Location WHERE identifier = '" +id+ "'";
		OResultSet rs = db.query(query);
		Location location = null;
		while (rs.hasNext()) {
			OResult item = rs.next();
			String iden = item.getProperty("identifier");
			String name = item.getProperty("name");
			String des = item.getProperty("describe");
			

			location  = new Location(iden, name, des);
		}
		rs.close();
		db.close();
		return location;
	}

	@Override
	public List<Location> listLocation() {
		ODatabaseSession db = null;
		try {
			db = (ODatabaseSession) orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Location ";
		List<Location> list = new ArrayList<Location>();
		OResultSet rs = db.query(query);
		while (rs.hasNext()) {
			OResult item = rs.next();
			String iden = item.getProperty("identifier");
			String name = item.getProperty("name");
			String des = item.getProperty("describe");
			
			list.add(new Location(iden, name, des));
		}
		rs.close();
		db.close();
		return list;
	}

	@Override
	public void addListLocation(ArrayList<Location> l) {
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
		db.close();
	}

}
