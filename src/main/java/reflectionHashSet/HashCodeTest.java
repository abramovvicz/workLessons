package reflectionHashSet;

public class HashCodeTest {
    public static void main(String[] args) {
        Point point = new Point(11,11);
        Point point1 = new Point(45,548);
        //System.out.println(point.hashCode());
        System.out.println(Integer.toBinaryString(hash8(point)));
        System.out.println(Integer.toBinaryString(hash8(point1)));
        System.out.println(Integer.toBinaryString(hash7(point)));
        System.out.println(Integer.toBinaryString(hash7(point1)));
        System.out.println("indeks dla java 7: "+indexFor7(point.hashCode(),16));
        System.out.println("indeks dla java 8: "+indexFor8(hash8(point),16));


    }
    static int hash8(Point key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    static int hash7(Point point) {
        int h = point.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
    static int indexFor7(int h, int length) {
        return h & (length-1);
    }
    static int indexFor8(int hash, int legth){
        return (legth-1)& hash;
    }


}
