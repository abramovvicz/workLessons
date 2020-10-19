package javaZaawansowaneHorstmann;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class Optionals {

    public static void main(String[] args) throws IOException {
       /* System.out.println(squareRoot(-5.0));
        Optional<Double> result = inverse(4.0).flatMap(Optionals::squareRoot);
        Optional<Double> result2 = Optional.of(4.0).flatMap(x -> inverse(x)).flatMap(x -> squareRoot(x));
        System.out.println("result is: " + result);
        System.out.println("result2 is: " + result2);*/


        String content = new String(Files.readAllBytes(Paths.get("src\\main\\resources\\alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(content.split("\\PL+"));
        Optional<String> optionalValueOfWords = words.stream().filter(s -> s.contains("Alice")).findFirst();
        System.out.println(optionalValueOfWords.orElse("Brak słów zawierających  'Fred'"));

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("BRAK");
        System.out.println("Wynik: " + result);
        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("Wynik: " + result);
   /*     try {
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("Wynik:" + result);
        } catch (Throwable l) {
            l.printStackTrace();
        }*/

        optionalValueOfWords = words.stream().filter(s->s.contains("red")).findFirst();
        optionalValueOfWords.ifPresent(s-> System.out.println(s +  " zawiera 'red'"));

        Set<String> strings = new HashSet<>();
        optionalValueOfWords.ifPresent(e -> strings.add(e));
        strings.stream().forEach(System.out::println);
        Optional<Boolean> optionalBoolean = optionalValueOfWords.map(strings::add);
        System.out.println(optionalBoolean); //ciekawy wynik - false ponieważ wyżej przy ifPresent się wykonało

        boolean t = true;
        Boolean aBoolean = Others.valueOf(t);



    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }


    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }


}
