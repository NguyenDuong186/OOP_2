package connection;

import java.util.ArrayList;
import java.util.List;

import com.orientechnologies.orient.core.record.OVertex;

import entity.Organization;

public interface OrganizationDAO {
	public void createSchema();

	public OVertex createOrg(String identifier, String name, String describe);

	public OVertex createOrgAll(String identifier, String name, String describe, String headquarters);

	public void deleteOrg(String id);

	public Organization getOrg(String id);

	public List<Organization> listOrg();

	public void addListOrganization(ArrayList<Organization> l);
}
