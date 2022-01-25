package default11.method;

public interface MyInterface {

    void method();

    default void dMethod() {
        System.out.println("This is default method");
    }
}
