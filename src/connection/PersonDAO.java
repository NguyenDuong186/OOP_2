package connection;

import java.util.ArrayList;
import java.util.List;

import com.orientechnologies.orient.core.record.OVertex;

import entity.Person;

public interface PersonDAO {
	public void createSchema();
	public OVertex addPerson(String identifier , String name , String describe);
	public OVertex addPersonAll(String identifier, String name, String describe, String dob, String profession, String nationality);
	public void deletePerson(String id);
	public Person getPerson(String id);
	public List<Person> listPerson();
	public OVertex getVertexPerson(String id);
	public void addListPerson(ArrayList<Person> l);
}
