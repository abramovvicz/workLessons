package javaZaawansowaneHorstmann;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class LoadFile {


    public LoadFile() throws IOException {
    }

    public List<String> loadFile() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("./src/main/resources/alice.txt")), StandardCharsets.UTF_8);
            return Arrays.asList(content.split("\\PL+"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Arrays.asList("");
    }
}
