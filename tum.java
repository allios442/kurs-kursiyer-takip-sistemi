//Ali Osman Balcı 24100011827

package final_odevi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Anasayfa {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		File my_file=new File("C:\\Users\\alios\\Desktop\\nyp uyg slaytları\\kurs.txt");
		if(my_file.exists()==false) {
			System.out.println("dosya bulunamadı");
			return;
		}
		
		FileReader fr=new FileReader(my_file);
		BufferedReader br= new BufferedReader(fr);

		String okunan;
		String okunandizi[];
		
		ArrayList<Kurs> kurslar=new ArrayList<Kurs>();
		ArrayList<Kursiyer> kursiyerler=new ArrayList<Kursiyer>();
		while((okunan=br.readLine()) != null) {
			okunandizi=okunan.split("%");
			kurslar.add(new Kurs(Integer.parseInt(okunandizi[0]),okunandizi[1]));
			
		}
		fr.close();
		br.close();
		
	

		
		
		try (FileReader fr2 = new FileReader("C:\\Users\\alios\\Desktop\\nyp uyg slaytları\\kursiyer.txt");
			     BufferedReader br2 = new BufferedReader(fr2)) {

			    
			    Kursiyer mevcutKursiyer = null; 

			    while ((okunan = br2.readLine()) != null) {
			        if (okunan.startsWith("*")) {
			            
			             okunandizi = okunan.substring(1).split("%"); 
			            if (okunandizi.length >= 3) {
			                mevcutKursiyer = new Kursiyer(Integer.parseInt(okunandizi[0]),  okunandizi[1], Integer.parseInt(okunandizi[2]), new ArrayList<>());
			                
			                kursiyerler.add(mevcutKursiyer);
			            } else {
			                System.out.println("Eksik kursiyer bilgisi: " + okunan);
			            }
			        } else if (okunan.startsWith("+") && mevcutKursiyer != null) {
			            
			             okunandizi = okunan.substring(1).split("%");
			            if (okunandizi.length >= 2) {
			                mevcutKursiyer.getAlinanKurslar().add(new Kurs(Integer.parseInt(okunandizi[0]), okunandizi[1]));
			                    
			                
			            } else {
			                System.out.println("Eksik kurs bilgisi: " + okunan);
			            }
			        }
			    }
			} catch (IOException e) {
	            System.out.println("Dosya okuma hatası " + e.getMessage());
	        }

		
		
		
		

		
		
	Scanner scan=new Scanner(System.in);
		boolean kontrol=true;
		int secim=0;
		while(kontrol) {
			System.out.println("\n1-  kurs ekle");
			System.out.println("2-  kurs listele");
			System.out.println("3-  kurs ara");
			System.out.println("4-  kurs sil");
			System.out.println("5-  kursiyer ekle");
			System.out.println("6-  kursiyer ara");
			System.out.println("7-  kursiyer sil");
			System.out.println("8-  kursiyerleri listele");
			System.out.println("9-  kursiyerleri ayrıntılı listele");
			System.out.println("10- kursiyerin ödeyeceği tutarı hesapla");
			System.out.println("11- Çıkış");
			System.out.print("bir seçim yapınız:");
			secim=scan.nextInt();
			scan.nextLine();

			String ad, alinankurs;
			int ID, yas;
		switch(secim) {
		
		case 1:
			boolean kursKontrol=false;
			System.out.println("kurs adını giriniz:");
			ad=scan.nextLine();
			System.out.println("kurs id giriniz:");
			ID=scan.nextInt();
			for(Kurs krs:kurslar) {
				
				if(krs.getKursId()==ID) {
					System.out.println("girdiğiniz id kullanılıyor farklı bir id giriniz!");
					kursKontrol=true;
					break;
					}
				}
				if(kursKontrol==false) {
					kurslar.add(new Kurs(ID,ad));
					System.out.println("kurs eklendi!");
					break;

			}
			
			break;
			
			
		case 2:
			
		for(Kurs krs:kurslar) {
			System.out.println("kurs ad: "+krs.getKursAd());
			System.out.println("kurs id: "+krs.getKursId());

			}
			break;
			
			
		case 3:
			int a_id;
			boolean bulundu=false;
			
			System.out.println("aranacak kursun ID'sini giriniz");
			a_id=scan.nextInt();
			
			for(Kurs krs:kurslar) {
				if(a_id==krs.getKursId()) {
					bulundu=true;
					System.out.println("kurs id: "+krs.getKursId());
					System.out.println("kurs adı: "+krs.getKursAd());	
					}
				}	
				if(bulundu==false) {
					System.out.println("kurs mevcut değil, geçerli bir id giriniz");
				}
			break;
			
			
		case 4:
			int s_id;
			bulundu=false;
			boolean krsyKontrol=false;
			System.out.print("silinecek kursun ID'sini giriniz :");
			s_id=scan.nextInt();
			
			
			for(Kurs krs:kurslar) {
				if(s_id==krs.getKursId()) {
					for(Kursiyer krsy_k:kursiyerler) {
						for(Kurs krs_k:krsy_k.alinanKurslar) {
							if(s_id==krs_k.getKursId()) {
								System.out.println("kursu alan kursiyer olduğu için bu kur silinemez!");
								krsyKontrol=true;
								bulundu=true;

								break;
							}
						}
						if (krsyKontrol) break;
					}
					if(krsyKontrol==false) {
						kurslar.remove(krs);
						System.out.println("kurs silindi");
						bulundu=true;
						break;
					}
					break;
				}
				}
			
			if(bulundu==false) {
				System.out.println("kurs mevcut değil, geçerli bir id giriniz");
			}
			break;
			
			
		case 5:
			int ks,kursid,k_id;
			boolean kursiyerBulundu = false;
			System.out.println("kursiyerin id'sini giriniz: ");
			k_id=scan.nextInt();
			scan.nextLine();
			System.out.println("kursiyerin adını soyadını giriniz: ");
			ad=scan.nextLine();
			System.out.println("kursiyerin yaşını giriniz: ");
			yas=scan.nextInt();
			System.out.println("kursiyerin alacağı kurs sayısını giriniz");
			ks=scan.nextInt();
			
			Kursiyer mevcutKursiyer = null;
			
			for(Kursiyer krsi:kursiyerler) {
				if(k_id==krsi.getKursiyerId()) {
					kursiyerBulundu = true;
					System.out.println("kursiyer id kullanılıyor! tekrar deneyiniz");
					break;
				}
			}	
				if(kursiyerBulundu==false) {
			
					mevcutKursiyer =new Kursiyer(k_id,  ad, yas, new ArrayList<>());
					boolean kursBulundu = false;
					for(int i=0; i<ks;i++) {
						System.out.println((i+1)+". kursun id'sini giriniz");
						kursid=scan.nextInt();
						for(Kurs krs:kurslar) {
							if(kursid==krs.getKursId()){
								kursBulundu = true;
								mevcutKursiyer.getAlinanKurslar().add(new Kurs(krs.getKursId(), krs.getKursAd()));
								
								System.out.println("kurs eklendi");
								break;
							}
							
						}
						if(kursBulundu==false) {
								System.out.println("kurs mevcut değil, tekrar deneyiniz");
								break;
							}
					}kursiyerler.add(mevcutKursiyer);
					break;
				}
				
			break;
			
			
		case 6:
			String k_ad;
			bulundu=false;
			
			System.out.println("aranacak kursiyerin adını soyadını giriniz");
			k_ad=scan.nextLine();
			
			for(Kursiyer krs:kursiyerler) {
				if(k_ad.equals(krs.getKursiyerAdSoyad())) {
					bulundu=true;
					System.out.println("ad soyad: "+krs.getKursiyerAdSoyad());
					System.out.println("kursiyer id: "+krs.getKursiyerId());
					System.out.println("kursiyer yaş: "+krs.getKursiyerYas());
					break;
				}
			}	
				if(bulundu==false) {
					System.out.println("kursiyer mevcut değil, geçerli bir isim giriniz");
					break;
					}
				
			break;
			
			
		case 7:
			boolean kursBulundu2=false;
			int kr_id;
			System.out.print("silinecek kursiyerin ID'sini giriniz :");
			kr_id=scan.nextInt();
			
			for(Kursiyer krs:kursiyerler) {
				if(kr_id==krs.getKursiyerId()) {
					kursBulundu2=true;
					kursiyerler.remove(krs);
					System.out.println("kursiyer silindi");
					break;
				}
			}
			
			if(kursBulundu2==false) {
				System.out.println("kursiyer id mevcut değil, geçerli bir id giriniz");
				break;
			}
			
			break;
			
			
		case 8:
				System.out.println("Tüm Kursiyerler");
			for(Kursiyer krs:kursiyerler) {
				System.out.print(krs.getKursiyerId()+" ");
				System.out.print(krs.getKursiyerAdSoyad()+" ");
				System.out.println(krs.getKursiyerYas());

				}
				break;
				
		case 9:
			System.out.println("Tüm Kursiyerler ve aldıkları kurslar");
			for(Kursiyer krs:kursiyerler) {
				System.out.print(krs.getKursiyerId()+" ");
				System.out.print(krs.getKursiyerAdSoyad()+" ");
				System.out.println(krs.getKursiyerYas());
					for(Kurs akrs:krs.alinanKurslar) {
						System.out.print("\t"+akrs.getKursId());	
						System.out.println(" "+akrs.getKursAd());	
					}
				}
				break;
				
		case 10:
			
			boolean kursBulundu3=false;
			int kry_id;
			System.out.println("kursiyer id giriniz");
			kr_id=scan.nextInt();
			
			for(Kursiyer krs:kursiyerler) {
				if(kr_id==krs.getKursiyerId()) {
					kursBulundu3=true;
					
					System.out.println("kursiyer borç:"+krs.BorcHesapla());
					break;
				}
			}
			
			if(kursBulundu3==false) {
				System.out.println("kursiyer id mevcut değil, geçerli bir id giriniz");
				break;
			}
				break;
		

			
		case 11:
			FileWriter fw=new FileWriter(my_file);
			BufferedWriter bw=new BufferedWriter(fw);
			
			for(Kurs krs:kurslar) {
				bw.write("+"+krs.getKursId()+"%"+krs.getKursAd()+" "+"\n");
			}
			
			
			File my_file2=new File("C:\\Users\\alios\\Desktop\\nyp uyg slaytları\\kursiyer.txt") ;
			FileWriter fw2=new FileWriter(my_file2);
			BufferedWriter bw2=new BufferedWriter(fw2);
			
			
			for (Kursiyer krs : kursiyerler) {
			    bw2.write("*"+krs.getKursiyerId()+"%"+krs.getKursiyerAdSoyad()+"%"+ krs.getKursiyerYas()+"\n");
			    for (Kurs akrs : krs.getAlinanKurslar()) {
			        bw2.write("+"+akrs.getKursId()+"%"+akrs.getKursAd()+"\n");
			    }
			}
			
			
			bw.flush();
			bw2.flush();
			
			System.out.println("çıkış yapılıyor....");
			kontrol=false;
			break;
			
			
		default:
			System.out.println("geçersiz giriş. lütfen 1-11 arasında bir sayı giriniz");
	
			
			}
				
			}
			
			
		}
			
			
			
			
	}

//Ali Osman Balcı 24100011827
package final_odevi;

public class Kurs {


	private int kursId;
	private String kursAd;
	public Kurs(int kursId, String kursAd) {
		
		this.kursId = kursId;
		this.kursAd = kursAd;
	}
	
	
	
	
	
	
		public int getKursId() {
		return kursId;
	}
	public void setKursId(int kursId) {
		this.kursId = kursId;
	}
	public String getKursAd() {
		return kursAd;
	}
	public void setKursAd(String kursAd) {
		this.kursAd = kursAd;
	}
	
}

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

//Ali Osman Balcı 24100011827
package final_odevi;

public interface Hesaplama {
	public abstract int  borchesapla()  ;

	
	
	
	
}

