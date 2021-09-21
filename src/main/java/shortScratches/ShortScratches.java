package shortScratches;

import java.util.Arrays;
import java.util.List;

public class ShortScratches {

    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Null", "abc", "Cc", "35", null);
        Character character = listOfStrings.stream().flatMap(value -> value.chars().mapToObj(s -> (char) s).filter(c -> Character.isUpperCase(c))).findFirst().orElse('0');
        System.out.println(character);
    }
}
