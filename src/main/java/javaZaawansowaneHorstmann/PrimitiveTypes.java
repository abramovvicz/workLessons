package javaZaawansowaneHorstmann;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveTypes {

    private static final boolean DEBUG = true;

    public static void show(String title, IntStream intStream) {
        final int SIZE = 10;
        int[] elements = intStream.limit(SIZE + 1).toArray();
        System.out.println(title + ":");
        for (int i = 0; i < elements.length; i++) {
            if (i > 0) System.out.println(",");
            if (i < SIZE) System.out.println(elements[i]);
            else System.out.println("");
        }
    }

    public static void main(String[] args) throws IOException {
        double v = Math.random() * 100;
        IntStream intStream = IntStream.generate(() -> (int) v);
        IntStream intStream1 = IntStream.range(0, 5);

        Stream<Integer> integerStream = IntStream.range(0, 100).boxed();
        //boxed - zwraca strumień obiektów zawierający opakowane wartości z tego strumienia
        IntStream intStream2 = integerStream.mapToInt(Integer::intValue);

        PrimitiveTypes.show("TEST STREAM", intStream2);

        LoadFile loadFile = new LoadFile();
        List<String> strings = loadFile.loadFile();
        IntStream intStream3 = strings.stream().mapToInt(String::length);
        show("intstream3", intStream3);

        String sentence = "\u0835\u0046 to zbiór oktononówcd?...";
        System.out.println(sentence);
        IntStream codes = sentence.codePoints();
//        show("Intstream4", codes);
//        System.out.println(codes.mapToObj(c -> String.format("%X ", c)).collect(Collectors.joining()));


        Map<Integer, List<String>> collect = strings.parallelStream().collect(Collectors.groupingBy(s -> s.length()));
        System.out.println(collect.get(14));
        Map<Integer, List<String>> collect2 = strings.parallelStream().collect(Collectors.groupingByConcurrent(s -> s.length()));
        System.out.println(collect2.get(14));

    }


}
