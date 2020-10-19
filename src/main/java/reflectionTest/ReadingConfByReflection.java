package reflectionTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadingConfByReflection {

    private static String getResource(String source) throws IOException {
        String value = "";
        StringBuilder stringBuilder = new StringBuilder(value);


        InputStream resourceAsStream = ReadingConfByReflection.class.getResourceAsStream(source);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8))) {
//            Stream<String> lines = bufferedReader.lines();
//            List<String> collect = lines.collect(Collectors.toList());
//            collect.stream().filter(x->x.length()>10).forEach(System.out::print);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        value = String.valueOf(stringBuilder);
        return value;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getResource("/alice.txt"));

    }


}
