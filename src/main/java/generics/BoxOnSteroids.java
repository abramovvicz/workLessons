package generics;

public class BoxOnSteroids<T> {

    public T fruit;

    public BoxOnSteroids(T fruit) {
        this.fruit = fruit;
    }

    public T getFruit() {
        return fruit;
    }

    public static void main(String[] args) {
        BoxOnSteroids<Apple> appleBox = new BoxOnSteroids<>(new Apple());
        BoxOnSteroids<Orange> orangeBox = new BoxOnSteroids<>(new Orange());


        Apple apple = appleBox.getFruit();
        Orange orange = orangeBox.getFruit();

        BoxOnSteroids boxOnSteroids = new BoxOnSteroids(new String());
        boxOnSteroids.createPairOfBoxOnSteroids();

    }

    private void createPairOfBoxOnSteroids() {
        PairOfBoxOnSteroids<BoxOnSteroids<Apple>, BoxOnSteroids<Orange>> pairOfBoxOnSteroids =
                new PairOfBoxOnSteroids(new BoxOnSteroids<>(new Orange()), new BoxOnSteroids<>(new Apple()));


        PairOfBoxOnSteroids<Apple, Orange> boxOnSteroids= new PairOfBoxOnSteroids(new Apple(), new Orange());
        PairOfBoxOnSteroids appleBoxOnSteroids =  boxOnSteroids;
        PairOfBoxOnSteroids orangeBoxOnSteroids = boxOnSteroids;
    }

    public class PairOfBoxOnSteroids<T, P> {
        private T firstBox;
        private P secondBox;

        public PairOfBoxOnSteroids(T firstBox, P secondBox) {
            this.firstBox = firstBox;
            this.secondBox = secondBox;
        }

        public T getFirstBox() {
            return firstBox;
        }

        public P getSecondBox() {
            return secondBox;
        }
    }
}
