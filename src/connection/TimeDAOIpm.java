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
import entity.Time;

public class TimeDAOIpm implements TimeDAO{

	@Override
	public void createSchema() {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OClass time = db.getClass("Time");
		if (time == null) {
			time = db.createVertexClass("Time");
		}
		if (time.getProperty("name") == null) {
			time.createProperty("name", OType.STRING);
			time.createIndex("time_name_index", OClass.INDEX_TYPE.NOTUNIQUE, "name");
		}
		if (time.getProperty("identifier") == null) {
			time.createProperty("identifier", OType.STRING);
			time.createIndex("time_id_index", OClass.INDEX_TYPE.UNIQUE, "id");
		}
		if (time.getProperty("describe") == null) {
			time.createProperty("describe", OType.STRING);
			time.createIndex("time_describe_index", OClass.INDEX_TYPE.UNIQUE, "describe");
		}
		
		db.close();
	}

	@Override
	public OVertex createTime(String identifier, String name, String describe) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OVertex result = db.newVertex("Time");
		result.setProperty("identifier", identifier);
		result.setProperty("name", name);
		result.setProperty("describe", describe);
		db.close();
		return result;
	}

	@Override
	public void deleteTime(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "DELETE VERTEX Time WHERE identificer = " + "?";
		OResultSet rs = db.query(query, id);
		rs.close();
		db.close();
	}

	@Override
	public Time getTime(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Time WHERE identifier = " + "?";
		OResultSet rs = db.query(query, id);
		OResult item = rs.next();
		Time time = null;
		while (item != null) {
			String iden = item.getProperty("identifier");
			String name = item.getProperty("nam");
			String des = item.getProperty("describe");
			

			time = new Time(iden, name, des);
		}
		rs.close();
		db.close();
		return time;
	}

	@Override
	public List<Time> listTime() {
		ODatabaseSession db = null;
		try {
			db = (ODatabaseSession) orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Time ";
		List<Time> list = new ArrayList<Time>();
		OResultSet rs = db.query(query);
		while (rs.hasNext()) {
			OResult item = rs.next();
			String iden = item.getProperty("identifier");
			String name = item.getProperty("nam");
			String des = item.getProperty("describe");
			list.add(new Time(iden, name, des));
		}
		rs.close();
		db.close();
		return list;
	}
}
