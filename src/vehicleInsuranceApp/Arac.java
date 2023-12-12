package vehicleInsuranceApp;

import java.util.Scanner;

public class Arac { // POJO class : fields (instance variable'lar , getter-setter, constructor , toString

    // data hiding : encapsulation

    private String type; // aracc tipi, kullanicidan alacagiz
    private int prim; // tarife donemine gore biz olusturuyoruz

    // getter-setter


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrim() {
        return prim;
    }

    public void setPrim(int term) {
        //aracin tipine gore ve tarife donemine gore
        /*
        Tarife dönemi:Aralık 2023,Haziran 2023
          1.dönem :Haziran 2023               2.dönem:Aralık 2023
          otomobil: 2000                       otomobil: 2500
          kamyon:   3000                       kamyon:   3500
          otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
          motosiklet: 1500                     motosiklet: 1750
         */
        switch (this.type){
            case "otomobil":
                this.prim=  term ==1 ? 2000 : 2500 ;
                break;
            case "kamyon":
                this.prim=term ==1 ? 3000 : 3500 ;
                break;
            case "otobus":
                countBusPrim(term);
                break;
            case "motosiklet":
                this.prim=term ==1 ? 1500 : 1750 ;
                break;
            default:
                System.out.println("Hatali giris!");
                this.prim=0;
                break;
        }

    }

    private void countBusPrim(int term) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Otobus tipini seciniz : ");
        System.out.println("1. (18-30) numarali koltuklar ");
        System.out.println("2. 31 no'lu koltuk ve uzeri");
        int busType=inp.nextInt();
        switch (busType) {
            case 1: // 18-30 koltuk arasi
                this.prim=term==1 ? 4000 : 4500;
                break;
            case 2: // 31 koltuk ve uzeri
                this.prim=term==1 ? 5000 : 5500;
                break;
            default:
                System.out.println("Hatali giris :( )");
                this.prim=0;
                break;

        }

    }
}
