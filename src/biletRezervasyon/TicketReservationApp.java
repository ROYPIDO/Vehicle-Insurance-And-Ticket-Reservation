package biletRezervasyon;

/*
Project: Bilet Rezervasyon ve Bilet Fiyatı Hesaplama Uygulaması

    1- Uygulama mesafe ve kurallara göre otobüs bileti fiyatı hesaplar sonuç olarak bilet bilgisini verir
    2- Kullanıcıdan     mesafe (KM),
                        yolcu adı, yaşı ,
                        yolculuk tipi (Tek Yön, Gidiş-Dönüş)
                        ve koltuk no bilgilerini alınır.
             NOT: Koltuk numaraları 1-32 aralığında olmalıdır.)
                  Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
                  Aksi halde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

    3-Fiyat hesaplama kuralları:
       -Mesafe başına ücret:
                  Tek yön: 1 Lira / km       Çift Yön(Gidiş-Dönüş): 2 Lira/km
       -Tekli Koltuk ücreti:
                  Koltuk no 3 veya 3 ün katı ise fiyat %20 daha fazladır(Tek yön: 1.2 Lira/km, Çift Yön:2.4 Lira/km).
       -İlk olarak seferin mesafe, yön ve koltuk no bilgisine göre fiyatı hesaplanır,
        sonrasında koşullara göre aşağıdaki indirimler uygulanır ;
                   i)-Çift Yön indirimi:
                               "Yolculuk Tipi" gidiş dönüş seçilmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
                   ii)-Yaş indirimi:
                                Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
                                Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

 */

import java.util.Scanner;

public class TicketReservationApp {

    public void start(){

        // 1- bilet rezervasyonu icin bilet ve otobus objesine ihtiyacimiz var

        Bus bus = new Bus("34 TPE 212"); // "1","2","3","4","5","6","7"......"32"
        Ticket ticket = new Ticket();

        Scanner scanner = new Scanner(System.in);
        int select ; // CIKIS icin 0'i seciniz (select == 0)

        do {

            // 7- Kullanicidan bilgileri alalim
            System.out.println("* Bilet rezervasyon ssitemine hosgeldiniz *");
            System.out.println("Luten ad-soyad giriniz");
            String name = scanner.nextLine();

            System.out.println("Lutfen yasinizi giriniz :");
            int age = scanner.nextInt();

            System.out.println("Lutfen gidilecek mesafe bilgisini KM olarak giriniz : ");
            double distance = scanner.nextDouble();

            System.out.println("Lutfen yolculuk tipini seciniz  : ");
            System.out.println("1 - Tek Yon");
            System.out.println("2 - Gidi/Donus");
            int type = scanner.nextInt();

            System.out.println("Koltuk no seciniz   : ");
            System.out.println("Tekli koltuk ucreti %20 daha fazladir!");
            System.out.println(bus.seats);  // mevcut koltuk no'lari "1","2","3","4","5"....."32"
            String seat = scanner.next();

            // Secilen koltuk daha once rezerve edilmis mi? Listede var mi?
            boolean isReserved = !bus.seats.contains(seat);

            if (isReserved){
                System.out.println("Secilen koltuk numarasi otobuste bulunmamaktadir ya da rezerve edilmistir!");
            }

            // Girilen degerler gecerli mi

            if(age>0 && distance>0 && (type==1 || type==2) && !isReserved){

                // bileti dolduralim
                ticket.distance = distance;
                ticket.typeNo = type;
                ticket.seatNo = seat;
                ticket.setPrice(age);

                // otobusun listesinden bu koltuk no'yu kaldirmamiz gerekir
                bus.seats.remove(seat);

                // bileti yazdiralim artik
                ticket.printTicket(bus,name);

            }else{
                System.out.println("Gecersiz giris yaptiniz!");
            }

            System.out.println("Yeni islem icin gecerli bir sayi giriniz ya da CIKIS icin 0 'a giriniz!");
            select = scanner.nextInt(); // 1,2,3 ..... veya 0
            scanner.nextLine(); //  Bu satiri yaziyoruz cunku , ikinci kez giriste isim almadan dogrudan yasa geciyor.\n i okumasi icinCOZUM

            // Ornek 2\n  nextInt metodu bu \n karakterini okumadigi icin yukaridaki satir eklemek zorunda kaldik

        }while(select !=0);

        System.out.println("Iyi gunler dileriz...");



    }



}
