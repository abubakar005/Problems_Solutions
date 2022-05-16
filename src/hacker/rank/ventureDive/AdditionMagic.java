package hacker.rank.ventureDive;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AdditionMagic {

    public String add(double a, String b) {
        return a + b;
    }

    public String add(double a, double b) {
        BigDecimal x = BigDecimal.valueOf(a);
        BigDecimal y = BigDecimal.valueOf(b);
        BigDecimal result = new BigDecimal(x.add(y).doubleValue()).setScale(2, RoundingMode.HALF_UP);
        // double result = a+b;
        return String.valueOf(result.doubleValue());
    }

    public String add(String a, String b) {
        return a+b;
    }

    public static void main(String args[] ) throws Exception {
        // Enter your code here. Read input from STDIN. Print output to STDOUT /
        Scanner sc = new Scanner(System.in);
        String sub = sc.nextLine();
        int n = Integer.parseInt(sub);
        for(int i=0;i<n;i++) {
            String[] temp = sc.nextLine().split(" ");
            Boolean  firstDouble = isFloat(temp[0]);
            Boolean  secondDouble = isFloat(temp[1]);
            AdditionMagic additionMagic = new AdditionMagic();
            if(firstDouble && secondDouble){
                System.out.println(additionMagic.add(Double.parseDouble(temp[0]), Double.parseDouble(temp[1])));
            }else {
                System.out.println(additionMagic.add(temp[0], temp[1]));
            }
        }
    }

    private static final Pattern DOUBLE_PATTERN = Pattern.compile(
            "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
                    "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
                    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
                    "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");

    public static boolean isFloat(String s) {
        return DOUBLE_PATTERN.matcher(s).matches();
    }
}
