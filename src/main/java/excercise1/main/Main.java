package excercise1.main;

import excercise1.utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    private static String testString = "some string to test removing 12132 numbers from him 12314";

    public static void main(String[] args) {

        List<ChangeString> listOfModifiers = new ArrayList<>();
        listOfModifiers.add(new AllSpacesRemover());
        listOfModifiers.add(new UpperCaseChanger());
        listOfModifiers.add(new LowerCaseChanger());
        listOfModifiers.add(new AllNumbersRemover());


        listOfModifiers.forEach(x -> x.changeString(testString));

      /*  listOfModifiers.forEach(x -> System.out.println(x.changeString(testString2)));
        listOfModifiers.forEach(x -> System.out.println(x.changeString(testString3)));
        listOfModifiers.forEach(x -> System.out.println(x.changeString(testString4)));
*/
        for (ChangeString listOfModifier : listOfModifiers) {
            testString = listOfModifier.changeString(testString);
        }
        System.out.println(testString);
    }
}

