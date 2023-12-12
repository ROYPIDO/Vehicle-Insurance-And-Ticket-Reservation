package biletRezervasyon;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    // 2 - plaka ve koltuk no

    public String numberPlate;  // Plaka no  // 34 TPE 212

    public List<String> seats = new ArrayList<>();

    // 3 - otobus objesi olusturuldugunda plakasi ve koltuk no'lari set edilsin
        public Bus(String plate){
            this.numberPlate = plate;
            for (int i= 1; i<33;i++){
                //this.seats.add(String.valueOf(i));
                this.seats.add(i+"");
            }

        }

}
