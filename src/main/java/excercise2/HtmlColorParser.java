package excercise2;

import java.util.Map;

public class HtmlColorParser
{

    private final Map<String, String> presetColors;

    public HtmlColorParser(Map<String, String> presetColors) {
        this.presetColors = presetColors;
    }

    public RGB parse(String color) {
        return new RGB(0, 128, 255);
    }
}
