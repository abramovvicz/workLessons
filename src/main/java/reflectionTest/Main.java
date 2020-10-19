package reflectionTest;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Bike bike = new Bike("MTB");

    public static void main(String[] args) throws ClassNotFoundException {


        Car car = new Car("Mazda", "black");
        checkPrivateFieldsInClass(car.getClass());
        checkPrivateMethodsInClass(car.getClass());
        checkPrivateConstructors(car.getClass());
        car.setName("Mazda");
        Class someClass = car.getClass();

        Field[] fields = someClass.getDeclaredFields();

        System.out.println(bike.getBikeType());
        Main main = new Main();
        main.checkBikeClass(bike.getClass());


        try {
            Field someField = someClass.getDeclaredField("name");
            Field checkPrivateColorField = someClass.getDeclaredField("color");
            someField.setAccessible(true);
            someField.set(car, "BMW");
            Object o = someField.get(car);
            System.out.println("new name of car in private: " + o.toString());

        } catch (Exception e) {
            System.out.println("Something goes wrong");
        }
    }


    private void checkBikeClass(Class bikeClass) {


//        try {
//            String name = new Bike("ROAD").getClass().getName();
//            System.out.println(name);
//            Class anotherClass = Class.forName("reflectionTest.Bike");
//            Method method = bikeClass.getDeclaredMethod("rideByChosenBikeType", bikeClass);
//            method.setAccessible(true);
//            boolean instance = bikeClass.isInstance(bike);
//            System.out.println(instance);
//            System.out.println(ReadingConfByReflection.main(bikeClass.isInstance(bike)).);

//            method.invoke(bikeClass.isInstance(bike), bikeClass);
//        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    private static void checkPrivateFieldsInClass(Class someClass) {

        Map<String, String> someMap = new HashMap<>();
        int i = 0;
        for (String s : someMap.keySet()) {
            while (i < 10) {
                s = s + i;
                someMap.put(s, "Bartek");
                i++;
            }
        }

        String name1 = someMap.getClass().getName();
        System.out.println("Klasa Mapy to?" + name1);

        Field[] fields = someClass.getDeclaredFields();

        for (Field field : fields) {
            Class classType = field.getType();
            String name = field.getName();

            if (name.length() > 0) {
                System.out.println("class type: " + classType + " and " + "name filed: " + name);
            }

        }
    }

    private static void checkPrivateMethodsInClass(Class someClass) throws ClassNotFoundException {
        Method[] methods = someClass.getMethods();
        Class<? extends Class> aClass = someClass.getClass();
        String name = someClass.getName();
        System.out.println(name);
        Class<?> car = Class.forName("reflectionTest.Car");
        System.out.println(car);


        for (Method method : methods) {
            Class returnType = method.getReturnType();
            String methodName = method.getName();
            String modifiers = Modifier.toString(method.getModifiers());

            Class[] paramTypes = method.getParameterTypes();


            for (Class paramType : paramTypes) {
                System.out.println(paramType.getName());
            }
        }
    }

    private static void checkPrivateConstructors(Class someClass) {
        Constructor[] constructors = someClass.getConstructors();

        for (Constructor constructor : constructors) {

            String name = constructor.getName();
            String modifiers = Modifier.toString(constructor.getModifiers());

            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println("Constructor parameters " + parameterType.getName());
            }

        }
    }


}
