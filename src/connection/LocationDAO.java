package connection;

import java.util.ArrayList;
import java.util.List;

import com.orientechnologies.orient.core.record.OVertex;

import entity.Location;

public interface LocationDAO {
	public void createSchema();

	public OVertex createLocation(String identifier, String name, String describe);


	public void deleteLocation(String id);

	public Location getLocation(String id);

	public List<Location> listLocation();
	
	public void addListLocation(ArrayList<Location> l);
}
