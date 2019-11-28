package generate_data;

import java.util.ArrayList;

import connection.CountryDAOImp;
import connection.EdgeDAOImp;
import connection.EventDAOImp;
import connection.LocationDAOImp;
import connection.OrganizationDAOImp;
import connection.TimeDAOImp;
import connection.PersonDAOImp;
import entity.Country;
import entity.Event;
import entity.Location;
import entity.Organization;
import entity.Person;
import entity.Time;
import fact.Fact;
import fact.generateFact;

public class PushData {
	public static void pushData2DB(int n, int m) {
		ArrayList<Event> event = new ArrayList<Event>();
		event = GenerateEventData.data(n);
		for (int i = 0; i < n - 1; i++) {
			System.out.println(event.get(i) + "\n");
		}
		ArrayList<Location> location = new ArrayList<Location>();
		location = GenerateLocationData.data(n);
		for (int i = 0; i < n - 1; i++) {
			System.out.println(location.get(i) + "\n");
		}
		ArrayList<Country> country = new ArrayList<Country>();
		country = GenerateCountryData.data(n);
		for (int i = 0; i < n - 1; i++) {
			System.out.println(country.get(i) + "\n");
		}
		ArrayList<Organization> organization = new ArrayList<Organization>();
		organization = GenerateOrganizationData.data(n);
		for (int i = 0; i < n - 1; i++) {
			System.out.println(organization.get(i) + "\n");
		}
		ArrayList<Person> person = new ArrayList<Person>();
		person = GeneratePersonData.data(n);
		for (int i = 0; i < n - 1; i++) {
			System.out.println(person.get(i).toString() + "\n");
		}
		ArrayList<Time> time = new ArrayList<Time>();
		time = GenerateTimeData.data(n);
		for (int i = 0; i < n - 1; i++) {
			System.out.println(time.get(i) + "\n");
		}

		ArrayList<Fact> FactDienRaTai = new ArrayList<Fact>();
		FactDienRaTai = generateFact.dienRaTai(event, location, m);

		ArrayList<Fact> FactDienRaLuc = new ArrayList<Fact>();
		FactDienRaLuc = generateFact.dienRaLuc(event, time, m);

		ArrayList<Fact> FactToChuc = new ArrayList<Fact>();
		FactToChuc = generateFact.toChuc(organization, event, m);

		ArrayList<Fact> FactDenTham = new ArrayList<Fact>();
		FactDenTham = generateFact.denTham(person, location, m);

		ArrayList<Fact> FactGapMat = new ArrayList<Fact>();
		FactGapMat = generateFact.gapMat(person, person, m);

		ArrayList<Fact> FactThanhLap = new ArrayList<Fact>();
		FactThanhLap = generateFact.thanhLap(person, organization, m);

		ArrayList<Fact> FactLaNguoiToChuc = new ArrayList<Fact>();
		FactLaNguoiToChuc = generateFact.laNguoiToChuc(person, event, m);

		ArrayList<Fact> FactDienRaTaiNuoc = new ArrayList<Fact>();
		FactDienRaTaiNuoc = generateFact.dienRaTaiNuoc(event, country, m);

		ArrayList<Fact> FactThuocNuoc = new ArrayList<Fact>();
		FactThuocNuoc = generateFact.thuocNuoc(location, country, m);

		ArrayList<Fact> quanThanhLapVaoThoiGian = new ArrayList<Fact>();
		quanThanhLapVaoThoiGian = generateFact.thanhLapVaoThoiGian(organization, time, m);

		ArrayList<Fact> FactQuanLy = new ArrayList<Fact>();
		FactQuanLy = generateFact.quanLi(person, organization, m);

		ArrayList<Fact> FactPhatBieuTai = new ArrayList<Fact>();
		FactPhatBieuTai = generateFact.phatBieuTai(person, event, m);

		EventDAOImp edi = new EventDAOImp();
		edi.addListEvent(event);

		LocationDAOImp ldi = new LocationDAOImp();
		ldi.addListLocation(location);

		OrganizationDAOImp odi = new OrganizationDAOImp();
		odi.addListOrganization(organization);

		TimeDAOImp tdi = new TimeDAOImp();
		tdi.addListTime(time);

		PersonDAOImp pdi = new PersonDAOImp();
		pdi.addListPerson(person);

		CountryDAOImp cdi = new CountryDAOImp();
		cdi.addListCountry(country);

		EdgeDAOImp e = new EdgeDAOImp();
		e.addListEdge(FactDienRaTai);
		e.addListEdge(FactDienRaLuc);
		e.addListEdge(FactToChuc);
		e.addListEdge(FactDenTham);
		e.addListEdge(FactGapMat);
		e.addListEdge(FactThanhLap);
		e.addListEdge(FactLaNguoiToChuc);
		e.addListEdge(FactDienRaTaiNuoc);
		e.addListEdge(FactThuocNuoc);
		e.addListEdge(quanThanhLapVaoThoiGian);
		e.addListEdge(FactQuanLy);
		e.addListEdge(FactPhatBieuTai);
	}

}
