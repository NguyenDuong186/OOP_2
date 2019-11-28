package generate_data;

import java.util.ArrayList;

import entity.Organization;

public class GenerateOrganizationData {
	public static ArrayList<Organization> data(int n) {
		ArrayList<Organization> listOrganization = new ArrayList<>();

		ArrayList<String> arr_name = GenerateData.listData("data//Organization_nhan.txt");
		int n_name = arr_name.size();

		ArrayList<String> arr_id = GenerateData.listData("data//Organization_dinhDanh.txt");
		int n_id = arr_id.size();

		ArrayList<String> arr_describe = GenerateData.listData("data//Organization_moTa.txt");
		int n_describe = arr_describe.size();

		ArrayList<String> arr_link = GenerateData.listData("data//Organization_link.txt");
		int n_link = arr_link.size();
		
		ArrayList<String> arr_headquaters = GenerateData.listData("data//Organization_truSo.txt");
		int n_headquaters= arr_headquaters.size();
		

		for (int i = 1; i < n; i++) {
			Organization Organization = new Organization();
			Organization.setName(GenerateData.dataRandom(arr_name, n_name));
			Organization.setIdentifier(GenerateData.dataRandom(arr_id, n_id) + '_' + i);
			Organization.setDescribe(GenerateData.dataRandom(arr_describe, n_describe));
			Organization.setLink(GenerateData.dataRandom(arr_link, n_link));
			Organization.setHeadquarters(GenerateData.dataRandom(arr_headquaters, n_headquaters));
			listOrganization.add(Organization);
		}
		return listOrganization;

	}
}
