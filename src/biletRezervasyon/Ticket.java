package biletRezervasyon;

public class Ticket {
    // 4- mesafe (KM), koltuk no,fiyat, yolculuk tipi
    public double distance;

    public String seatNo;

    private double price; // verilen bilgilere gore hesaplanacak

    public int typeNo;

    // 5- bilet fiyatini hesaplama

    public void setPrice(int age) {

        double total = 0;
        int seat = Integer.parseInt(this.seatNo);

        switch (this.typeNo) {
            case 1 : // tek yon
                if(seat % 3 == 0){
                    total = this.distance*1.2;
                }else{
                    total = this.distance*1;
                }
                System.out.println("Toplam tutar : " + total);  // This line isn't necessary, but we would like how our code is working
                break;
            case 2 :  // cift yon
                if(seat % 3 == 0){
                    total = this.distance*2.4;
                }else{
                    total = this.distance*2;
                }
                System.out.println("Toplam tutar : " + total);  // This line isn't necessary, but we would like how our code is working
                total = total*0.8;
                System.out.println("Cift yon indirimli tutar tutar : " + total);  // This line isn't necessary, but we would like how our code is working
                break;

        }

        if(age<12){

            total = total*05;
            System.out.println("Yas indirimli tutar : " + total);  // This line isn't necessary, but we would like how our code is working

        }else if(age>65){
            total = total*0.7;
            System.out.println("Yas indirimli tutar : " + total);  // This line isn't necessary, but we would like how our code is working
        }

        this.price = total;

    }

    // 6- bileti

    public void printTicket(Bus bus, String name){

        System.out.println("*".repeat(42));
        System.out.println("--- Bilet Detayi ---");
        System.out.println(" Sayin "+name);
        System.out.println("Otobus plakasi      :"+bus.numberPlate);
        System.out.println("Mesafe              :"+this.distance);
        System.out.println("Yolculuk tipi       :"+(this.typeNo == 1 ? "Tek yon" : "Gidis - Donus"));
        System.out.println("Koltuk No           :"+this.seatNo);
        System.out.println("Toplam Tutar        :"+this.price);
        System.out.println("Keyifli yolculuklar dileriz");
        System.out.println("*".repeat(42));





    };




}
