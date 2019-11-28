package generate_data;

import java.util.ArrayList;

import entity.Location;

public class GenerateLocationData {
	public static ArrayList<Location> data(int n) {
		ArrayList<Location> listLocation = new ArrayList<>();

		ArrayList<String> arr_name = GenerateData.listData("data//Location_nhan.txt");
		int n_name = arr_name.size();

		ArrayList<String> arr_id = GenerateData.listData("data//Location_dinhDanh.txt");
		int n_id = arr_id.size();

		ArrayList<String> arr_describe = GenerateData.listData("data//Location_moTa.txt");
		int n_describe = arr_describe.size();

		ArrayList<String> arr_link = GenerateData.listData("data//Location_link.txt");
		int n_link = arr_link.size();

		for (int i = 1; i < n; i++) {
			Location Location = new Location();
			Location.setName(GenerateData.dataRandom(arr_name, n_name));
			Location.setIdentifier(GenerateData.dataRandom(arr_id, n_id) + '_' + i);
			Location.setDescribe(GenerateData.dataRandom(arr_describe, n_describe));
			Location.setLink(GenerateData.dataRandom(arr_link, n_link));
			listLocation.add(Location);
		}
		return listLocation;

	}
}
