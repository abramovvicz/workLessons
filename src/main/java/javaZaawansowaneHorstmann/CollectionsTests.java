package javaZaawansowaneHorstmann;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class CollectionsTests {

    private LoadFile loadFile;
    private Stream<Locale> locales;


    public Stream<String> noVowels() throws IOException {
        loadFile = new LoadFile();
        List<String> strings = loadFile.loadFile();
//        return strings.stream().map(s -> s.replaceAll("[aieouAIEOU]", ""));
        return strings.stream().filter(s -> s.length() > 10);
    }

    public <T> void show(String label, Set<T> set) {
        System.out.println(label + " : " + set.getClass().getName());
        System.out.println(set.stream().limit(10).map(Object::toString).collect(Collectors.joining(",")));
    }

    public static void main(String[] args) throws IOException {
        CollectionsTests collectionsTests = new CollectionsTests();
        collectionsTests.noVowels();
        Set<String> strings = collectionsTests.noVowels().collect(Collectors.toSet());
        collectionsTests.show("Some label", strings);
        IntSummaryStatistics summaryStatistics = collectionsTests.noVowels().collect(Collectors.summarizingInt(s -> s.length()));
        System.out.println("Average : " + summaryStatistics.getAverage());
        System.out.println("Max : " + summaryStatistics.getMax());
        System.out.println("SUM : " + summaryStatistics.getSum());

        Integer[] integers = Stream.iterate(0, n -> n + 1).limit(50).toArray(s -> new Integer[s]);
//        Stream.of(integers).forEach(System.out::println);

//        collectionsTests.countLanguageCountries(collectionsTests.getLocaleStream());
        collectionsTests.countLanguageCountriesSecond();
    }

    private Stream<Locale> getLocaleStream() {

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languages =
                locales.collect(Collectors.toMap(Locale::getDisplayLanguage, x -> x.getDisplayLanguage(x), (existingValue, newValue) -> existingValue));
//        System.out.println("KEYS: " + languages.keySet() + "," + "VALUES: " + languages.values());
        return locales;
    }

    private void countLanguageCountries(Stream<Locale> locales) {
        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> languagesSet =
                locales.collect(Collectors.toMap(
                        Locale::getDisplayCountry,
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) ->
                        { // Suma zbiorów a i b
                            Set<String> union = new HashSet<>(a);
                            union.addAll(b);
                            return union;
                        }));
        System.out.println(languagesSet);
    }

    private void countLanguageCountriesSecond() {
        locales = Stream.of(Locale.getAvailableLocales());
//        Map<Boolean, List<Locale>> listMap = locales.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
        Map<String, Long> stringListMap = locales.collect(Collectors.groupingBy(Locale::getCountry, counting()));
//        List<Locale> englishLocaleList = listMap.get(true);
        stringListMap.entrySet().forEach(System.out::println);
//        englishLocaleList.forEach(System.out::println);
    }


}
