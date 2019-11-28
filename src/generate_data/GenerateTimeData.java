package generate_data;

import java.util.ArrayList;

import entity.Time;

public class GenerateTimeData {
	public static ArrayList<Time> data(int n) {
		ArrayList<Time> listTime = new ArrayList<>();

		ArrayList<String> arr_name = GenerateData.listData("data//Time_nhan.txt");
		int n_name = arr_name.size();

		ArrayList<String> arr_id = GenerateData.listData("data//Time_dinhDanh.txt");
		int n_id = arr_id.size();

		ArrayList<String> arr_describe = GenerateData.listData("data//Time_moTa.txt");
		int n_describe = arr_describe.size();

		ArrayList<String> arr_link = GenerateData.listData("data//Time_link.txt");
		int n_link = arr_link.size();

		for (int i = 1; i < n; i++) {
			Time Time = new Time();
			Time.setName(GenerateData.dataRandom(arr_name, n_name));
			Time.setIdentifier(GenerateData.dataRandom(arr_id, n_id) + '_' + i);
			Time.setDescribe(GenerateData.dataRandom(arr_describe, n_describe));
			Time.setLink(GenerateData.dataRandom(arr_link, n_link));
			listTime.add(Time);
		}
		return listTime;

	}
}
