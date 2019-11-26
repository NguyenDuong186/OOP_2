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
import entity.Event;

public class EventDAOImp implements EventDAO{

	@Override
	public void createSchema() {
		
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OClass event = db.getClass("Event");
		if (event == null) {
			event = db.createVertexClass("Event");
		}
		if (event.getProperty("name") == null) {
			event.createProperty("name", OType.STRING);
			event.createIndex("event_name_index", OClass.INDEX_TYPE.NOTUNIQUE, "name");
		}
		if (event.getProperty("identifier") == null) {
			event.createProperty("identifier", OType.STRING);
			event.createIndex("event_id_index", OClass.INDEX_TYPE.UNIQUE, "id");
		}
		if (event.getProperty("describe") == null) {
			event.createProperty("describe", OType.STRING);
			event.createIndex("event_describe_index", OClass.INDEX_TYPE.UNIQUE, "describe");
		}
		
		db.close();
		
	}

	@Override
	public OVertex createEvent(String identifier, String name, String describe) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OVertex result = db.newVertex("Event");
		result.setProperty("identifier", identifier);
		result.setProperty("name", name);
		result.setProperty("describe", describe);
		db.close();
		return result;
	}

	@Override
	public void deleteEvent(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "DELETE VERTEX Event WHERE identificer = " + "?";
		OResultSet rs = db.query(query, id);
		rs.close();
		db.close();
		
	}

	@Override
	public Event getEvent(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Event WHERE identifier = " + "?";
		OResultSet rs = db.query(query, id);
		OResult item = rs.next();
		Event event = null;
		while (item != null) {
			String iden = item.getProperty("identifier");
			String name = item.getProperty("nam");
			String des = item.getProperty("describe");
			

			event = new Event(iden, name, des);
		}
		rs.close();
		db.close();
		return event;
	}

	@Override
	public List<Event> listEvent() {
		ODatabaseSession db = null;
		try {
			db = (ODatabaseSession) orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Event ";
		List<Event> list = new ArrayList<Event>();
		OResultSet rs = db.query(query);
		while (rs.hasNext()) {
			OResult item = rs.next();
			String iden = item.getProperty("identifier");
			String name = item.getProperty("nam");
			String des = item.getProperty("describe");
			
			list.add(new Event(iden, name, des));
		}
		rs.close();
		db.close();
		return list;
	}

}
