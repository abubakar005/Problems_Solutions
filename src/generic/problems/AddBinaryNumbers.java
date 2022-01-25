package generic.problems;

public class AddBinaryNumbers {

    public static void main(String args[]){

        int num1 = 0b11;
        int num2 = 0b01;

        int sum = num1 + num2;
        System.out.println(sum);

        System.out.println("num2: " + num2);
        //convertDecimalToBinary(5);
    }

    static void convertDecimalToBinary(int num) {
        System.out.println(Integer.toBinaryString(num));
    }
}
