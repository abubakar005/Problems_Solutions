package hacker.rank.careem;

public class IsPossible {

    public static void main(String[] ags) {


    }

    public String numberConvertable(int a, int b, int c, int d) {

        if(a == c && b == d)
            return "Yes";

        if(a > c || b > d)
            return "No";

        while (a < c || b < d) {

        }

        return null;
    }
}
