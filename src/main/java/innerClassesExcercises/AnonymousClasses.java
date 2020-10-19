package innerClassesExcercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AnonymousClasses {

    public static class Robot {
        private final GreetingModule greetingModule;

        public Robot(GreetingModule greetingModule) {
            this.greetingModule = greetingModule;
        }

        public void saySthRobot() {
            greetingModule.sayHello();
        }
    }

    public static class ListTest {
        private final GreetingModule greetingModule;
        private static List<String> strings;

        public ListTest(GreetingModule greetingModule, List<String> strings) {
            this.greetingModule = greetingModule;
            this.strings = strings;
        }

        public static List<String> getStrings() {
            return strings;
        }

        public static void setStrings(List<String> strings) {
            ListTest.strings = strings;
        }

        public void sortList() {
            greetingModule.showList();
        }

    }

    public interface GreetingModule {
        void sayHello();

        void showList();
    }


    public static void main(String[] args) {
        Robot jan = new Robot(new GreetingModule() {
            @Override
            public void sayHello() {
                System.out.println("Jan mówi dziń dobry");
            }

            @Override
            public void showList() {
                //
            }
        });

        Robot john = new Robot(new GreetingModule() {
            @Override
            public void sayHello() {
                System.out.println("John mówi hello");
            }

            @Override
            public void showList() {
                //
            }
        });

        Robot robotIsSpekkingInGerman = new Robot(new GreetingModule() {
            @Override
            public void sayHello() {
                System.out.println("robot is spekking in german");
            }

            @Override
            public void showList() {

            }
        });
        ListTest testWithList = new ListTest(new GreetingModule() {

            List<String> strings = new ArrayList<>();
            private Scanner scanner = new Scanner(System.in);


            @Override
            public void sayHello() {
                //
            }

            @Override
            public void showList() {
                System.out.println("Podaj 5 wyrazów");

                while (strings.size() <= 4) {
                    String next = scanner.nextLine();
                    strings.add(next);
                }

                System.out.println("Before sort: ");
                strings.forEach(s -> System.out.print(s + " "));

                strings.sort(Comparator.comparing(String::length));

                ListTest.setStrings(strings);
                System.out.println("After sort: ");
                strings.forEach(s -> System.out.print(s + " "));

            }
        }, ListTest.getStrings());


        jan.saySthRobot();
        john.saySthRobot();
        robotIsSpekkingInGerman.saySthRobot();

        testWithList.sortList();


    }
}
