package generate_data;

import java.util.ArrayList;

import entity.Country;


public class GenerateCountryData {
	/**
	 * function generate s list data of country randomly*/
	public static ArrayList<Country> data(int n) {
		ArrayList<Country> listCountry = new ArrayList<>();

		ArrayList<String> arr_name = GenerateData.listData("data//Country_nhan.txt");
		int n_name = arr_name.size();

		ArrayList<String> arr_id = GenerateData.listData("data//Country_dinhDanh.txt");
		int n_id = arr_id.size();

		ArrayList<String> arr_describe = GenerateData.listData("data//Country_moTa.txt");
		int n_describe = arr_describe.size();

		ArrayList<String> arr_link = GenerateData.listData("data//Country_link.txt");
		int n_link = arr_link.size();

//		ArrayList<String> arr_ngay_trich_rut = generateData.listData("data\\country_ngayTrichRut.txt");
//		int n_ngay_trich_rut = arr_ngay_trich_rut.size();

		ArrayList<String> arr_acreage = GenerateData.listData("data//Country_dienTich.txt");
		int n_acreage = arr_acreage.size();
		
		ArrayList<String> arr_capital = GenerateData.listData("data//Country_thuDo.txt");
		int n_capital = arr_capital.size();
		
		ArrayList<String> arr_officialLanguages = GenerateData.listData("data//Country_ngonNgu.txt");
		int n_officialLanguages = arr_officialLanguages.size();
		
		
		for (int i = 1; i < n; i++) {
			Country country = new Country();
			country.setName(GenerateData.dataRandom(arr_name, n_name));
			country.setIdentifier(GenerateData.dataRandom(arr_id, n_id) + '_' + i);
			country.setDescribe(GenerateData.dataRandom(arr_describe, n_describe));
			country.setLink(GenerateData.dataRandom(arr_link, n_link));
			country.setAcreage(GenerateData.dataRandom(arr_acreage, n_acreage));
			country.setCapital(GenerateData.dataRandom(arr_capital, n_capital));
			country.setOfficialLanguages(GenerateData.dataRandom(arr_officialLanguages, n_officialLanguages));
			listCountry.add(country);
		}
		return listCountry;

	}
}
