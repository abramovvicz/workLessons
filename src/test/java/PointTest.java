import org.junit.jupiter.api.Test;
import reflectionHashSet.Point;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class PointTest {

    //private static final int SAMPLE_SIZE = 35000;
    private static final int SAMPLE_SIZE = 50;

    @Test
    public void test() throws Exception {
        HashSet<Point> set = new HashSet<>(SAMPLE_SIZE);
        Point a = new Point(0, 0);
        for (int i = 0; i < SAMPLE_SIZE; i++) {
            a = new Point(i, i);
            set.add(a);
            assertTrue(set.contains(a));
        }
        int size;
        try {
            size = (Integer) set.getClass().getMethod("size").invoke(set);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(a);
        printHashSet(set);
        getFromHashCode(set);
    }


    @Test
    public void test2() throws Exception {
        HashSet<Point> set = new HashSet<>(SAMPLE_SIZE);
        for (int i = 0; i < SAMPLE_SIZE; i++) {
            Point a = new Point(i, i * 2);
            set.add(a);
            assertTrue(set.contains(a));
        }
        printHashSet(set);
    }

    @Test
    public void test3() throws Exception {
        HashSet<Point> set = new HashSet<>(SAMPLE_SIZE);
        Point a = new Point(0, 0);
        for (int i = 0; i < SAMPLE_SIZE; i++) {
            a = new Point(i, i + 2);
            set.add(a);
            assertTrue(set.contains(a));

        }
        int size;
        try {
            size = (Integer) set.getClass().getMethod("size").invoke(set);

        } catch (Exception e) {
            e.printStackTrace();
        }

        printHashSet(set);
        getFromHashCode(set);
    }


    private void printHashSet(HashSet<Point> set) throws Exception {


    }

    private static Point getFromHashCode(HashSet<Point> set) throws Exception {
        // reflection stuff
        Field field = set.getClass().getDeclaredField("map");
        field.setAccessible(true);

        // get the internal map
        @SuppressWarnings("unchecked")
        Map<Object, Object> interalMap = (Map<Object, Object>) (field.get(set));
        Field[] declaredFields = HashMap.class.getDeclaredFields();
        Field mapField = HashMap.class.getDeclaredField("table");
        System.out.println();

        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            if (name.equals("table")) {

                declaredField.setAccessible(true);
                Map.Entry<Object, Object>[] realTable = (Map.Entry<Object, Object>[]) declaredField.get(interalMap);

                int emptyBuckets = 0;
                int notEmptyBuckest = 0;

                for (int i = 0; i < realTable.length; i++) {

                    if (realTable[i] == null) {
                        emptyBuckets++;
//                        System.out.println(realTable[i].getKey());
//                        System.out.println(realTable[i].getValue());
                    } else {
                        notEmptyBuckest++;
                    }

//                    System.out.println(String.format("Bucket : %d, Entry: %s", i, realTable[i]));
                }

                System.out.println("Number of empty buckets: " + emptyBuckets);
                System.out.println("Number of NON empty buckets: " + notEmptyBuckest);
                System.out.println("Sum of buckets: " + realTable.length);
            }
        }
        return null;
    }

}
