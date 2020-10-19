package javaZaawansowaneHorstmann;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingStreams {


    private <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> list = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.println(title + " : ");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) System.out.print(",");
            if (i < 10) System.out.print(list.get(i));
            else System.out.println("...");
        }
        System.out.println();
    }


    public static void main(String[] args) throws IOException {
        LoadFile loadFile = new LoadFile();
        List<String> strings = loadFile.loadFile();

        CreatingStreams creatingStreams = new CreatingStreams();
        creatingStreams.show("ALICE", Stream.of(strings));

        Stream<String> songs = Stream.of("jakies", "z dupy", "słowa", "do", "testowania");
        creatingStreams.show("SONGS", songs);

        Stream<Double> doubles = Stream.generate(() -> Math.floor(Math.random() * 10));
        creatingStreams.show("LICZBY", doubles);

        Stream<String> isEmpty = Stream.empty();
        creatingStreams.show("Is Empty", isEmpty);

        Stream<String> echoes = Stream.generate(() -> "echos"); // generuje stałe
        creatingStreams.show("ECHOS", echoes);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        creatingStreams.show("LICZBY", integers);


        creatingStreams.show("ANOTHER WAY", Stream.of(strings));

        creatingStreams.show("lines", Stream.of(strings));

        System.out.println(Pattern.matches("a*b", "aaaab"));


        creatingStreams.show("WORDS LENGTH MORE THEN 12", strings.stream().filter(s -> s.length() > 12));

        Stream<String> uniqueWords = Stream.of("radosnie", "radosnie", "radosnie", "delikatnie").distinct();
        creatingStreams.show("uniqWords", uniqueWords);

        Object[] powers = Stream.iterate(1.0, p -> p * 2).peek(e -> System.out.println("Pobieram element e: " + e)).limit(20).toArray();


    }

}
