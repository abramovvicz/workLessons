package javaZaawansowaneHorstmann;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Others {
    
    
    public void someMethod(){
        Stream<String> someStrings = Stream.of("ads", "asdasd", "adas dsfg", "awgvcvcx");
        IntStream intStream = someStrings.mapToInt(String::length);
        int sum = intStream.sum();
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Others others = new Others();
        others.someMethod();
    }

    public void someMethodTwo(){
        int first = 0xB047;
        int second = 45127;

        System.out.println(first == second);
    }

    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
}
