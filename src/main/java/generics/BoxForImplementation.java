package generics;

public class BoxForImplementation<T extends ClassExtention> {


    private T element;


    public BoxForImplementation(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public String getElementName() {
        return element.getElement();
    }

    public static void main(String[] args) {
        BoxForImplementation<Ananas> boxForImplementation= new BoxForImplementation<>(new Ananas());

    }
}


