package connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.orientechnologies.orient.core.Orient;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.record.ODirection;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OElement;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

import entity.Location;
import entity.Person;
import fact.Fact;
import generate_data.GenerateData;
import generate_data.GeneratePersonData;

public class orientdbConnection {

	public static ODatabaseSession getConnection() throws ClassNotFoundException, SQLException {
		ODatabaseSession db;
		OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
		db = orient.open("OOP", "root", "leminhduc");
		System.out.println("Connect success!");
		return db;
	}

	public static OVertex getVertex(String id) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String query = "SELECT * FROM V WHERE identifier='"+id+"'";
		OResultSet resultSet = db.query(query);
		OVertex from = null;
		        if (resultSet.hasNext())
		        {
		            OResult result = resultSet.next();
		            OElement element = result.toElement();
		            Optional<OVertex> optional = element.asVertex();
		            if(optional.isPresent()) 
		                from = optional.get();
		        }
		        
		resultSet.close();
		db.close();
		return from;
	}
	public void excuteQuery(String query) throws Exception{
		ODatabaseSession db = getConnection();
		OResultSet rs = db.query(query);
		rs.close();
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
		ArrayList<Person> l = new ArrayList<>();
//		for (int i=0 ;i<5;i++) {
//			Person p = new Person("person_"+i,"person_nam_"+i, "student");
//			l.add(p);
//		}
		PersonDAOImp pdi = new PersonDAOImp();
		l=GeneratePersonData.data(10);
		pdi.addListPerson(l);
//		
//		ArrayList<String> l2 = new ArrayList<>();
//		l2 = GenerateData.listData("data//Country_nhan.txt");
//		String str = GenerateData.dataRandom(l2, 10);
//		System.out.print(l2.size());
//		System.out.print(str);
		ArrayList<Fact> l3 = new ArrayList<>();
		for(int i=0;i<5;i++) {
			Fact f = new Fact("den_tham_"+i,"person_"+i,"person_"+i);
			l3.add(f);
		}
		EdgeDAOImp edi = new EdgeDAOImp();
		edi.addListEdge(l3);
//		OVertex v1 =pdi.addPerson("id1","nguoi_1","sfdd");
//		OVertex v2 =pdi.addPerson("id2","nguoi_2","sfdd");
//		OVertex v3 =pdi.addPerson("007","Le Minh Duc","Student at HUST");
//		if(v3!=null) {
//			System.out.print("true");
//		}
//		String correlative ="chi_dao";
//		edi.addEdge(v1, v3, correlative);
		System.out.print("End");
	}
}
