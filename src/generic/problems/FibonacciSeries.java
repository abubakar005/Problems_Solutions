package generic.problems;

public class FibonacciSeries {

    public static void main(String args[]){

        int prev1 = 0;
        int prev2 = 1;

        print(prev1);
        print(prev2);

        for(int i=2; i<10; i++) {

            int temp = prev1 + prev2;
            print(temp);
            prev1 = prev2;
            prev2 = temp;
        }
    }

    static void print(int num) {
        System.out.print(num + " ");
    }
}
