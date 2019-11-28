package fact;

import java.util.ArrayList;
import java.util.Random;

import entity.Country;
import entity.Event;
import entity.Location;
import entity.Organization;
import entity.Person;
import entity.Time;


public class generateFact {
	//Diễn ra tại giữa Event và Location
		public static ArrayList<Fact> dienRaTai(ArrayList<Event> a, ArrayList<Location> b, int m){
			ArrayList<Fact> FactDienRaTai = new ArrayList<Fact>();
			int i =0 ;
			for (i = 0; i < m; i++){
				Random n = new Random();
				String dinhDanh1 = a.get(n.nextInt(m)).getIdentifier();
				String dinhDanh2 = b.get(n.nextInt(m)).getIdentifier();
				Fact Fact1 = new Fact("PlaceIn",dinhDanh1,dinhDanh2);
				FactDienRaTai.add(Fact1);
				System.out.println(FactDienRaTai.get(i).toString());
			}
			return FactDienRaTai;
		}
		//Diễn ra lúc (Event và Time)
		public static ArrayList<Fact> dienRaLuc(ArrayList<Event> a, ArrayList<Time> b, int m){
			ArrayList<Fact> FactDienRaLuc = new ArrayList<Fact>();
			int i =0 ;
			for (i = 0; i < m; i++){
				Random n = new Random();
				String dinhDanh1 = a.get(n.nextInt(m)).getIdentifier();
				String dinhDanh2 = b.get(n.nextInt(m)).getIdentifier();
				Fact Fact1 = new Fact("HappenAt",dinhDanh1,dinhDanh2);
				FactDienRaLuc.add(Fact1);
				System.out.println(FactDienRaLuc.get(i).toString());
			}
			return FactDienRaLuc;
		}
		//Tổ chức (Organization và Event)
		public static ArrayList<Fact> toChuc(ArrayList<Organization> a, ArrayList<Event> b, int m){
			ArrayList<Fact> FactToChuc = new ArrayList<Fact>();
			int i =0 ;
			for (i = 0; i < m; i++){
				Random n = new Random();
				String dinhDanh1 = a.get(n.nextInt(m)).getIdentifier();
				String dinhDanh2 = b.get(n.nextInt(m)).getIdentifier();
				Fact Fact1 = new Fact("Organize",dinhDanh1,dinhDanh2);
				FactToChuc.add(Fact1);
				System.out.println(FactToChuc.get(i).toString());
			}
			return FactToChuc;
		}
		//Đến thăm (Person và Location)
		public static ArrayList<Fact> denTham(ArrayList<Person> a, ArrayList<Location> b, int m){
			ArrayList<Fact> FactDenTham = new ArrayList<Fact>();
			int i =0 ;
			for (i = 0; i < m; i++){
				Random n = new Random();
				String dinhDanh1 = a.get(n.nextInt(m)).getIdentifier();
				String dinhDanh2 = b.get(n.nextInt(m)).getIdentifier();
				Fact Fact1 = new Fact("Visit",dinhDanh1,dinhDanh2);
				FactDenTham.add(Fact1);
				System.out.println(FactDenTham.get(i).toString());
			}
			return FactDenTham;
		}
		//Gặp mặt (Person và Person)
		public static ArrayList<Fact> gapMat(ArrayList<Person> a, ArrayList<Person> b, int m){
			ArrayList<Fact> FactGapMat = new ArrayList<Fact>();
			int i =0 ;
			for (i = 0; i < m; i++){
				Random n = new Random();
				String dinhDanh1 = a.get(n.nextInt(m)).getIdentifier();
				String dinhDanh2 = b.get(n.nextInt(m)).getIdentifier();
				Fact Fact1 = new Fact("Meet",dinhDanh1,dinhDanh2);
				FactGapMat.add(Fact1);
				System.out.println(FactGapMat.get(i).toString());
			}
			return FactGapMat;
		}
		//Thành lập (Person và Organization)
		public static ArrayList<Fact> thanhLap(ArrayList<Person> a, ArrayList<Organization> b, int m){
			ArrayList<Fact> FactThanhLap = new ArrayList<Fact>();
			int i =0 ;
			for (i = 0; i < m; i++){
				Random n = new Random();
				String dinhDanh1 = a.get(n.nextInt(m)).getIdentifier();
				String dinhDanh2 = b.get(n.nextInt(m)).getIdentifier();
				Fact Fact1 = new Fact("Establish",dinhDanh1,dinhDanh2);
				FactThanhLap.add(Fact1);
				System.out.println(FactThanhLap.get(i).toString());
			}
			return FactThanhLap;
		}
		//Là người tổ chức (Person và Event)
		public static ArrayList<Fact> laNguoiToChuc(ArrayList<Person> a, ArrayList<Event> b, int m){
			ArrayList<Fact> FactLaNguoiToChuc = new ArrayList<Fact>();
			int i =0 ;
			for (i = 0; i < m; i++){
				Random n = new Random();
				String dinhDanh1 = a.get(n.nextInt(m)).getIdentifier();
				String dinhDanh2 = b.get(n.nextInt(m)).getIdentifier();
				Fact Fact1 = new Fact("Organizer",dinhDanh1,dinhDanh2);
				FactLaNguoiToChuc.add(Fact1);
				System.out.println(FactLaNguoiToChuc.get(i).toString());
			}
			return FactLaNguoiToChuc;
		}
		//Diễn ra tại nước (Event và Country)
		public static ArrayList<Fact> dienRaTaiNuoc(ArrayList<Event> a, ArrayList<Country> b, int m){
			ArrayList<Fact> FactDienRaTaiNuoc = new ArrayList<Fact>();
			int i =0 ;
			for (i = 0; i < m; i++){
				Random n = new Random();
				String dinhDanh1 = a.get(n.nextInt(m)).getIdentifier();
				String dinhDanh2 = b.get(n.nextInt(m)).getIdentifier();
				Fact Fact1 = new Fact("PlaceInCountry",dinhDanh1,dinhDanh2);
				FactDienRaTaiNuoc.add(Fact1);
				System.out.println(FactDienRaTaiNuoc.get(i).toString());
			}
			return FactDienRaTaiNuoc;
		}
		//Thuộc nước (Location và Country)
		public static ArrayList<Fact> thuocNuoc(ArrayList<Location> a, ArrayList<Country> b, int m){
			ArrayList<Fact> FactThuocNuoc = new ArrayList<Fact>();
			int i =0 ;
			for (i = 0; i < m; i++){
				Random n = new Random();
				String dinhDanh1 = a.get(n.nextInt(m)).getIdentifier();
				String dinhDanh2 = b.get(n.nextInt(m)).getIdentifier();
				Fact Fact1 = new Fact("BelongToCountry",dinhDanh1,dinhDanh2);
				FactThuocNuoc.add(Fact1);
				System.out.println(FactThuocNuoc.get(i).toString());
			}
			return FactThuocNuoc;
		}
		//Thành lập vào thời gian (Organization và Time)
		public static ArrayList<Fact> thanhLapVaoThoiGian(ArrayList<Organization> a, ArrayList<Time> b, int m){
			ArrayList<Fact> FactThanhLapVaoThoiGian = new ArrayList<Fact>();
			int i =0 ;
			for (i = 0; i < m; i++){
				Random n = new Random();
				String dinhDanh1 = a.get(n.nextInt(m)).getIdentifier();
				String dinhDanh2 = b.get(n.nextInt(m)).getIdentifier();
				Fact Fact1 = new Fact("FoundedTime",dinhDanh1,dinhDanh2);
				FactThanhLapVaoThoiGian.add(Fact1);
				System.out.println(FactThanhLapVaoThoiGian.get(i).toString());
			}
			return FactThanhLapVaoThoiGian;
		}
		//Quản lí (Persion và Organization)
		public static ArrayList<Fact> quanLi(ArrayList<Person> a, ArrayList<Organization> b, int m){
			ArrayList<Fact> FactQuanLi = new ArrayList<Fact>();
			int i =0 ;
			for (i = 0; i < m; i++){
				Random n = new Random();
				String dinhDanh1 = a.get(n.nextInt(m)).getIdentifier();
				String dinhDanh2 = b.get(n.nextInt(m)).getIdentifier();
				Fact Fact1 = new Fact("Manage",dinhDanh1,dinhDanh2);
				FactQuanLi.add(Fact1);
				System.out.println(FactQuanLi.get(i).toString());
			}
			return FactQuanLi;
		}
		//Phát biểu tại (Person và Event)
		public static ArrayList<Fact> phatBieuTai(ArrayList<Person> a, ArrayList<Event> b, int m){
			ArrayList<Fact> FactPhatBieuTai = new ArrayList<Fact>();
			int i =0 ;
			for (i = 0; i < m; i++){
				Random n = new Random();
				String dinhDanh1 = a.get(n.nextInt(m)).getIdentifier();
				String dinhDanh2 = b.get(n.nextInt(m)).getIdentifier();
				Fact Fact1 = new Fact("Speech",dinhDanh1,dinhDanh2);
				FactPhatBieuTai.add(Fact1);
				System.out.println(FactPhatBieuTai.get(i).toString());
			}
			return FactPhatBieuTai;
		}
}
