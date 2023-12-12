package vehicleInsuranceApp;

/*
Proje: Araç Sigorta Prim Hesaplama
       Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                    -otobüs: 18-30 koltuk veya 31 ve üstü koltuk

       Tarife dönemi:Aralık 2023,Haziran 2023
          1.dönem :Haziran 2023               2.dönem:Aralık 2023
          otomobil: 2000                       otomobil: 2500
          kamyon:   3000                       kamyon:   3500
          otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
          motosiklet: 1500                     motosiklet: 1750

        1-Tekrar tekrar kullanılan bir seçim menüsü(form) gösterelim.
        2-Tarife dönemi bilgisi,araç tipi bilgilerini kullanıcıdan alalım.
        3-Hatalı girişte hesaplama başarısız uyarısı verip tekrar menü(form) gösterilsin.
        4-Menüde yeni işlem veya çıkış için seçenek sunulsun .
        5-tarife dönemi ve araç tipine göre sigorta primi hesaplansın.
 */

import java.util.Scanner;

public class VehicleInsuranceApp {

    public static void main(String[] args) {
        //1-uygulamayi baslatmak icin bir metod
        start();



    }

    private static void start() {
        //2-kullanicidan bilgileri alalim
         Scanner inp = new Scanner(System.in);
         boolean isAgain;

         //3-menu gosterelim
        do {
            System.out.println("*** Zorunlu Arac Sigortasi Primi Hesaplama ***");
            System.out.println("Tarife donemi seciniz : ");
            System.out.println("1. Haziran 2023");
            System.out.println("2. Aralik 2023");
            int term = inp.nextInt();

            // tarife donemi dogru ise isleme devam aksi halde hatali giris ve yeniden form
            if (term==1 || term==2){
                //4-Arac objesi olusturealim
                Arac arac = new Arac(); // Arac class'ini olusturunca biz yazmasak bile constructor'i olusturulur , java tarafindan otomatik olarak
                System.out.println("Arac tipini giriniz : ");
                System.out.println("otomobil, kamyon, otobus, motosiklet");
                String type = inp.next().trim(); // kamyon

                arac.setType(type); // kamyon
                arac.setPrim(term); // primi hesapladik

                // prim = 0 ise hatali giris , uyari ve yeni islem secenegi
                // prim > 0 ise hesaplama basarili, sonucu goruntuleme ve yeni islem secenegi

                if(arac.getPrim()>0){
                    // sonucu goruntule
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("Arac tipi : "+ arac.getType());
                    System.out.println("Tarife donemi :"+(term == 1 ? "Haziran 2023" : "Aralik 2023" ) );
                    System.out.println("Aracinizin ilgili donem zorunlu sigorta primi : "+arac.getPrim());
                    System.out.println("-----------------------------------------------------------------");

                }else {
                    System.out.println("Hesaplama basarisiz, tekrar deneyiniz");
                }

                System.out.println("Yeni islem icin 1 , CIKIS icin 0 seciniz :");
                int select = inp.nextInt(); // 1 veya 0

                isAgain = select!=0 ? true : false;


            }else{
                System.out.println("hatali giris, yeniden deneyiniz!");
                isAgain=true;
            }

        }while (isAgain);

        System.out.println("iyi gunler dileriz...");





    }


}
