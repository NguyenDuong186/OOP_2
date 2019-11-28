package connection;

import java.util.ArrayList;

import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;

import fact.Fact;

public interface EdgeDAO {
	public void createSchema();

	public void addEdge(OVertex v1, OVertex v2, String correlative);

	public OVertex getVertexFrom(OEdge edge);// lay vertex la nguon bat dau cua edge

	public OVertex getVertexTo(OEdge edge); // lay vertex la dich cua edge

	public OEdge getEdge(String nameEdge);

	public void addListEdge(ArrayList<Fact> l);

	public void createNewEdge(String s);
}
