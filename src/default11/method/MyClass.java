package default11.method;

public class MyClass implements MyInterface {

    @Override
    public void method() {
        System.out.println("Implemented method");
    }

   /* @Override
    public void dMethod() {
        System.out.println("Override: This is default method");
    }*/

    public static void main(String args[]){

        MyClass myClass = new MyClass();

        myClass.dMethod();
        myClass.method();
    }
}
