package connection;

import java.sql.SQLException;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

import entity.Person;

public class orientdbConnection {

	public static ODatabaseSession getConnection() throws ClassNotFoundException, SQLException {
		ODatabaseSession db;
		OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
		db = orient.open("OOP", "root", "leminhduc");
		System.out.println("Connect success!");
		return db;
	}

	
	public void excuteQuery(String query) throws Exception{
		ODatabaseSession db = getConnection();
		db.query(query);
	}
	
	public OResultSet selectData(String query) throws Exception{
		ODatabaseSession db = getConnection();
		OResultSet rs = db.query(query);
		return rs;
	}
	/*
	 * public static Connection getConnection() throws SQLException,
	 * ClassNotFoundException { Connection conn=null; try { Properties info = new
	 * Properties(); info.put("user", "root"); info.put("password", "leminhduc");
	 * 
	 * conn = (Connection)
	 * DriverManager.getConnection("jdbc:orient:remote:localhost/OOP", info);
	 * System.out.println("Connect success!"); } catch (SQLException e) {
	 * System.out.println("Error when you connect to database!Error is: "+e.
	 * getMessage()); } return conn; }
	 */
	public static void main(String[] args) throws Exception {
//		try {
//			ODatabaseSession db = orientdbConnection.getConnection();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		orientdbConnection conn = new orientdbConnection();
//		OResultSet rs = conn.selectData("select * from Person");
//		System.out.print(rs.toString());
		
//		String id = "000002";
		PersonDAOImp p = new PersonDAOImp();
//		Person p1=p.getPerson(id);
//		System.out.print(p1.toString());
//		System.out.print("finish");
		// p.addPerson("desir", "Desir", "magician");
		OVertex p1 = p.addPerson("desir", "Desir", "magician");
		System.out.print("add success");
	}
}
