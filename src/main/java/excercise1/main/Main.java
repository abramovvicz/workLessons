package excercise1.main;

import excercise1.utils.AllNumbersRemover;
import excercise1.utils.AllSpacesRemover;
import excercise1.utils.LowerCaseChanger;
import excercise1.utils.UpperCaseChanger;

public class Main {

    private static String testString = "some string to test removing 12132 numbers from him 12314";
    private static String testString2 = "some string which have remove spaces and spaces and    spaces";
    private static String testString3 = "SOME STRING WHICH IS CHANGING TO LOWE CASE";
    private static String testString4 = "some string which is changing to upper case with out numbers 121 and spaces";

    public static void main(String[] args) {

        AllNumbersRemover numbersRemover = new AllNumbersRemover();
        System.out.println(numbersRemover.changeString(testString));

        AllSpacesRemover allSpacesRemover = new AllSpacesRemover();
        System.out.println(allSpacesRemover.changeString(testString2));

        LowerCaseChanger lowerCaseChanger = new LowerCaseChanger();
        System.out.println(lowerCaseChanger.changeString(testString3));

        UpperCaseChanger upperCaseChanger = new UpperCaseChanger();
        System.out.println(upperCaseChanger.changeString(testString4));

    }
}
