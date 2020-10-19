package javaZaawansowaneHorstmann;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toSet;

public class CollectorsTest {

    public static class City {
        private String name;
        private String state;
        private int population;

        public City(String name, String state, int population) {
            this.name = name;
            this.state = state;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public String getState() {
            return state;
        }

        public int getPopulation() {
            return population;
        }
    }

    public static Stream<City> readCities(String filename) throws IOException {
        return Files.lines(Paths.get(filename)).map(l -> l.split(", "))
                .map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
    }



    public static void main(String[] args) throws IOException {

        Stream<City> cityStream = readCities("src\\main\\resources\\cities.txt");
//        Map<String, Set<City>> collect = cityStream.collect(groupingBy(City::getName, toSet()));
        Map<String, String> collect = cityStream.collect(groupingBy(City::getName, mapping(City::getState, joining(","))));
        collect.entrySet().stream().forEach(s->System.out.println(s + " to jest to gowno dziwko"));

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(groupingBy(
                Locale::getCountry, toSet()));
//        System.out.println("countryToLocaleSet: " + countryToLocaleSet);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocaleCounts = locales.collect(groupingBy(
                Locale::getCountry, counting()));
        System.out.println("countryToLocaleCounts: " + countryToLocaleCounts);

        Stream<City> cities = cityStream;
        Map<String, Integer> stateToCityPopulation = cities.collect(groupingBy(
                City::getName, summingInt(City::getPopulation)));
        System.out.println("stateToCityPopulation: " + stateToCityPopulation);

        cities = cityStream;
        Map<String, Optional<String>> stateToLongestCityName = cities
                .collect(groupingBy(
                        City::getState,
                        mapping(City::getName,
                                maxBy(Comparator.comparing(String::length)))));

        System.out.println("stateToLongestCityName: " + stateToLongestCityName);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryToLanguage = locales
                .collect(Collectors
                .groupingBy(Locale::getCountry, mapping(Locale::getDisplayLanguage, toSet())));

        cities = cityStream;
        Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities
                .collect(groupingBy(City::getState,
                        summarizingInt(City::getPopulation)));
        System.out.println(stateToCityPopulationSummary.get("NY"));

        cities = cityStream;
        Map<String, String> stateToCityNames = cities.collect(groupingBy(
                City::getState,
                reducing("", City::getName, (s, t) -> s.length() == 0 ? t : s
                        + ", " + t)));

        cities = cityStream;
        stateToCityNames = cities.collect(groupingBy(City::getState,
                mapping(City::getName, joining(", "))));
        System.out.println("stateToCityNames: " + stateToCityNames);



    }
}
