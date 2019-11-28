package connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OElement;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

import fact.Fact;

public class EdgeDAOImp implements EdgeDAO{

	@Override
	public void createSchema() {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(db.getClass("Cancel")==null) {
			db.createEdgeClass("Cancel");
		}
		if(db.getClass("Negotiate")==null) {
			db.createEdgeClass("Negotiate");
		}
		if(db.getClass("PlaceIn")==null) {
			db.createEdgeClass("Cancel");
		}
		if(db.getClass("Cancel")==null) {
			db.createEdgeClass("PlaceIn");
		}
		if(db.getClass("Protest")==null) {
			db.createEdgeClass("Protest");
		}
		if(db.getClass("Speech")==null) {
			db.createEdgeClass("Speech");
		}
		if(db.getClass("StrainWith")==null) {
			db.createEdgeClass("StrainWith");
		}
		if(db.getClass("Support")==null) {
			db.createEdgeClass("Support");
		}
		if(db.getClass("Visit")==null) {
			db.createEdgeClass("Visit");
		}
		if(db.getClass("Participate")==null) {
			db.createEdgeClass("Participate");
		}
		if(db.getClass("SignAgreement")==null) {
			db.createEdgeClass("SignAgreement");
		}
		
		db.close();
	}
	
	@Override
	public void addEdge(OVertex v1, OVertex v2,String correlative) {
		this.createNewEdge(correlative);
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		OEdge edge1 = v1.addEdge(v2, correlative);
	    edge1.save();
	    db.close();
	}
	

	@Override
	public OVertex getVertexFrom(OEdge edge) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		OVertex from = edge.getFrom();
		return from;
	}

	@Override
	public OVertex getVertexTo(OEdge edge) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		OVertex to = edge.getTo();
		return to;
	}

	@Override
	public OEdge getEdge(String nameEdge) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String query = "SELECT * FROM ? ";
		OResultSet resultSet = db.query(query,nameEdge);
		OEdge from = null;
		        if (resultSet.hasNext())
		        {
		            OResult result = resultSet.next();
		            OElement element = result.toElement();
		            Optional<OEdge> optional = element.asEdge();
		            if(optional.isPresent()) 
		                from = optional.get();
		        }
		        
		resultSet.close();
		db.close();
		return from;
	}

	@Override
	public void addListEdge(ArrayList<Fact> l) {
		for(int j=0;j<l.size();j++) {
			String s = l.get(j).getCorrelative();
			this.createNewEdge(s);
		}
		for(int i=0;i<l.size();i++) {
			OVertex v1 = orientdbConnection.getVertex(l.get(i).getObj());
			OVertex v2 = orientdbConnection.getVertex(l.get(i).getSubj());
			String correlative = l.get(i).getCorrelative();
			ODatabaseSession db = null;
			try {
				db = orientdbConnection.getConnection();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			OEdge edge1 = v1.addEdge(v2, correlative);
		    edge1.save();
		    db.close();
		}
		
	   
		
	}
	@Override
	public void createNewEdge(String s) {
		ODatabaseSession db = null;
		try {
			db = orientdbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(db.getClass(s)==null) {
			db.createEdgeClass(s);
		}
		
		db.close();
	}
	
	

}
