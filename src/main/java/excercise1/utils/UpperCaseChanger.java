package excercise1.utils;

public class UpperCaseChanger implements ChangeString {
    @Override
    public String changeString(String s) {
        return s.toUpperCase();
    }
}
