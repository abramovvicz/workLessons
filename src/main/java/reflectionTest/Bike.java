package reflectionTest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bike {

    private String bikeType;


    public Bike(String bikeType) {
        this.bikeType = bikeType;
    }

    private String rideByChosenBikeType(Bike bike)
    {
        bikeType = "MTB";
        System.out.println("wybrany bike to :" + bikeType);
        return bikeType;
    }
}
