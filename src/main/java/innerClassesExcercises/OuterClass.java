package innerClassesExcercises;

public class OuterClass {

    public static class InnerClass {
        //this is inner class


    }

    private  InnerClass inintiateClass() {
        return new InnerClass();
    }

    private static void someInnerClassInstance(){
      InnerClass instance = new OuterClass.InnerClass();

    }
}
