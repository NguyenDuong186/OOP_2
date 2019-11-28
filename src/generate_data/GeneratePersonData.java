package generate_data;

import java.util.ArrayList;

import entity.Person;

public class GeneratePersonData {
	public static ArrayList<Person> data(int n) {
		ArrayList<Person> listPerson = new ArrayList<>();

		ArrayList<String> arr_name = GenerateData.listData("data//Person_nhan.txt");
		int n_name = arr_name.size();

		ArrayList<String> arr_id = GenerateData.listData("data//Person_dinhDanh.txt");
		int n_id = arr_id.size();

		ArrayList<String> arr_describe = GenerateData.listData("data//Person_moTa.txt");
		int n_describe = arr_describe.size();

		ArrayList<String> arr_link = GenerateData.listData("data//Person_link.txt");
		int n_link = arr_link.size();

//		ArrayList<String> arr_dob = generateData.listData("data\\Person_dob.txt");
//		int n_dob = arr_dob.size();
//		
//		ArrayList<String> arr_profession = generateData.listData("data\\Person_profession.txt");
//		int n_profession = arr_profession.size();
//		
//		ArrayList<String> arr_nationality = generateData.listData("data\\Person_nationality.txt");
//		int n_nationality = arr_nationality.size();
		

		for (int i = 1; i < n; i++) {
			Person Person = new Person();
			Person.setName(GenerateData.dataRandom(arr_name, n_name));
			Person.setIdentifier(GenerateData.dataRandom(arr_id, n_id) + '_' + i);
			Person.setDescribe(GenerateData.dataRandom(arr_describe, n_describe));
			Person.setLink(GenerateData.dataRandom(arr_link, n_link));
//			Person.setDob(generateData.dataRandom(arr_dob, n_dob));
//			Person.setProfession(generateData.dataRandom(arr_profession, n_profession));
//			Person.setNationality(generateData.dataRandom(arr_nationality, n_nationality));
			listPerson.add(Person);
		}
		return listPerson;

	}
}
