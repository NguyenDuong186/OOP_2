package generate_data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class GenerateData {
	
	/**
	 * Tra ve mot list cac data voi dau vao la mot path file*/
	public static ArrayList<String> listData(String path) {
		ArrayList<String> arr = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader bfr = new BufferedReader(isr);
			String line = bfr.readLine();
			while (line != null) {
				arr.add(line);
				line = bfr.readLine();
			}
//            fis.close();
//            isr.close();
			bfr.close();
			isr.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arr;
	}

	/**
	 * lay ngau nhien mot phan tu trong array list
	 * */
	public static String dataRandom(ArrayList<String> arr, int n) {
		Random rd = new Random();
		int i = rd.nextInt(n);
		return arr.get(i);
	}
}
