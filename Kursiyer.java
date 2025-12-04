//Ali Osman Balcı 24100011827
package final_odevi;

import java.util.ArrayList;

public class Kursiyer {
	
	
	private int kursiyerId;
	private String kursiyerAdSoyad;
	private int KursiyerYas;

	
	public ArrayList<Kurs> alinanKurslar=new ArrayList<Kurs>();
	public Kursiyer(int kursiyerId, String kursiyerAdSoyad, int kursiyerYas, ArrayList<Kurs> alinanKurslar) {
		this.kursiyerId = kursiyerId;
		this.kursiyerAdSoyad = kursiyerAdSoyad;
		this.KursiyerYas = kursiyerYas;
		this.alinanKurslar = alinanKurslar;
	}

	
	
	public double BorcHesapla() {
		int borc=0;
		int kursSayisi= alinanKurslar.size();
		
		if(kursSayisi>3) {
		borc=(int) ((0.9*kursSayisi)*500);
		}
		boolean kontrol=false;
		
			switch(kursSayisi) {
			
			case 1:
				borc=500;
				break;
				
			case 2:
				borc=(int) ((1+0.8)*500);
			break;
				
			case 3:
				borc=(int) ((0.9*3)*500);
			break;
				
			
				
			
			
			
			}
			
			
			
		
		return borc;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public int getKursiyerId() {
		return kursiyerId;
	}
	public void setKursiyerId(int kursiyerId) {
		this.kursiyerId = kursiyerId;
	}
	public String getKursiyerAdSoyad() {
		return kursiyerAdSoyad;
	}
	public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
		this.kursiyerAdSoyad = kursiyerAdSoyad;
	}
	public int getKursiyerYas() {
		return KursiyerYas;
	}
	public void setKursiyerYas(int kursiyerYas) {
		KursiyerYas = kursiyerYas;
	}
	public ArrayList<Kurs> getAlinanKurslar() {
		return alinanKurslar;
	}
	public void setAlinanKurslar(ArrayList<Kurs> alinanKurslar) {
		this.alinanKurslar = alinanKurslar;
	}

	
	
	
	

}
