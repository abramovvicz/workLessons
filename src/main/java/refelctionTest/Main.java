package refelctionTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {


        Car car = new Car("Mazda", "black");
        checkPrivateFieldsInClass(car.getClass());
        checkPrivateMethodsInClass(car.getClass());
        checkPrivateConstructors(car.getClass());
        car.setName("Mazda");
        Class someClass = car.getClass();

        Field[] fields = someClass.getDeclaredFields();


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


    private static void checkPrivateFieldsInClass(Class someClass) {

        Field[] fields = someClass.getDeclaredFields();


        for (Field field : fields) {
            Class classType = field.getType();
            String name = field.getName();

            if (name.length() > 0) {
                System.out.println("class type: " + classType + " and " + "name filed: " + name);
            }

        }
    }

    private static void checkPrivateMethodsInClass(Class someClass) {
        Method[] methods = someClass.getMethods();

        for (Method method : methods) {
            Class returType = method.getReturnType();
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
