package generate_data;

import java.util.ArrayList;

import entity.Event;

public class GenerateEventData {
	public static ArrayList<Event> data(int n) {
		ArrayList<Event> listEvent = new ArrayList<>();

		ArrayList<String> arr_name = GenerateData.listData("data//Event_nhan.txt");
		int n_name = arr_name.size();

		ArrayList<String> arr_id = GenerateData.listData("data//Event_dinhDanh.txt");
		int n_id = arr_id.size();

		ArrayList<String> arr_describe = GenerateData.listData("data//Event_moTa.txt");
		int n_describe = arr_describe.size();

		ArrayList<String> arr_link = GenerateData.listData("data//Event_link.txt");
		int n_link = arr_link.size();

		for (int i = 1; i < n; i++) {
			Event Event = new Event();
			Event.setName(GenerateData.dataRandom(arr_name, n_name));
			Event.setIdentifier(GenerateData.dataRandom(arr_id, n_id) + '_' + i);
			Event.setDescribe(GenerateData.dataRandom(arr_describe, n_describe));
			Event.setLink(GenerateData.dataRandom(arr_link, n_link));
			listEvent.add(Event);
		}
		return listEvent;

	}
}
