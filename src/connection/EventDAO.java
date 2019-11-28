package connection;

import java.util.ArrayList;
import java.util.List;

import com.orientechnologies.orient.core.record.OVertex;

import entity.Event;

public interface EventDAO {
	public void createSchema();

	public OVertex createEvent(String identifier, String name, String describe);

	public void deleteEvent(String id);

	public Event getEvent(String id);

	public List<Event> listEvent();

	public void addListEvent(ArrayList<Event> l);
}
