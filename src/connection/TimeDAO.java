package connection;

import java.util.ArrayList;
import java.util.List;

import com.orientechnologies.orient.core.record.OVertex;

import entity.Event;
import entity.Time;

public interface TimeDAO {
	public void createSchema();

	public OVertex createTime(String identifier, String name, String describe);

	public void deleteTime(String id);

	public Time getTime(String id);

	public List<Time> listTime();

	public void addListTime(ArrayList<Time> l);
}
