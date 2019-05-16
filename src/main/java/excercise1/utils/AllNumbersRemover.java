package excercise1.utils;

public class AllNumbersRemover implements ChangeString {
    @Override
    public String changeString(String s) {
        return s.replaceAll("[^A-Za-z^ ]", "");
    }
}
