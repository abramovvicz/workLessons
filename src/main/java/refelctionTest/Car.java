package refelctionTest;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Car {

    String name = "some car";
    String color = "some color";



    public Car(String name, String color) {
        this.name = name;
        this.color = color;

    }

    public void someMethod() {

    }


}
