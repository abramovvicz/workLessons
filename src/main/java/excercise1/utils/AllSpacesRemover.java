package excercise1.utils;

public class AllSpacesRemover implements ChangeString {

    @Override
    public String changeString(String s) {
        return s.replaceAll(" ", "");
    }
}
