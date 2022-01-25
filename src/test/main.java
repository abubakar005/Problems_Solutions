package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class Main {

    List list = new ArrayList<String>();
    //list.




    Object message(){
        return "Hello!";

    }
    public static void main(String[] args) {
     //   System.out.print(new Main().MESSAGE());

        MyThread2 myThread = new MyThread2();
        myThread.start();

        //System.out.print(new Main2().message());
    }
}
class Main2 extends Main {
    String message(){
        return "World!";
    }
}