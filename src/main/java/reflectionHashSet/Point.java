package reflectionHashSet;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }


    @Override
    public int hashCode() {
        int result = x << 16;
//        int result = x;
        //System.out.println(re
        // sult);
        result = result ^ y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }


}


