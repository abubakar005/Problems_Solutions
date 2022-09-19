package amazon;

// Interview Date  06092022

/*

A TTS system can only consume numbers in their spoken form.
In a typical text, numbers appear in their digit form.
Convert numbers from digit form to their spoken form. E.g.

max: 999 billion ...


"1" "one"
"34" "thirty four"
"123456" "one hundred twenty three thousand four hundred fifty six"
"456456" "four hundred fifty six thousand four hundred fifty six"
"999456456" " nine hundred ninety nine million four hundred fifty six thousand four hundred fifty six"

public void numbersIntoDigits(String input) {

    String[] tens = {"One", "Two", "Three", ... "Ninteen"};
    //String[] teens = {"Eleven", --..... "Ninteen"};
    String[] tys = {"Twenty", "Thirty" --..... "Hundred"};
    String[] mls = {"Thousand", "Million", "Billion"};

    long inputInLong = Long.valueOf(input);     // 123
    long oneBillion = 1000000000;
    StringBuilder result = new StringBuilder();

    // I will check if the number is less than 20 then I will convert it directly from the

    int dig = inputInLong/10
    //int modval = inputInLong % 10

    // initially I will check if the number is greate than billion
    int billionValue = getBillion(inputInLong);

    if(billionvalue > 0) {
        inputInLong = inputInLong % oneBillion;

        // here I will call further methods to divide the result that I can excoect in thousands

        result.append(billionValue).append(mls[2]);
    }



    // check if in million then I will divide accordingly

}

public int getBillion(long input) {

    long oneBillion = 1000000000;
    int result = 0;

    if(input >= oneBillion)
        result = input/oneBillion;
}

public int getMillion() {

}

public int getThousands(int input) {

    if(input >= 999)
}

 */

public class DigitsToWords {

    public static void main(String[] args) {

        System.out.println(getWords(123456));
    }


    public static String getWords(long input) {

        String words = "";
        String[] ones = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        if(input/1000 > 0) {
            long thousands = input/1000;

            words = words + getWords(thousands) + " Thousands";
            input = input%1000;
        }

        if(input/100 > 0) {
            long hundreds = input/100;

            words = words + ones[(int) hundreds] + " Hundreds";
            input = input%100;
        }

        if(input > 19) {
            long ten = input/10;

            words = words + tens[(int) ten];
            input = input%10;
        }

        if(input > 0)
            words = words + ones[(int) input];

        return words;
    }

    // Searched by using the AI tool
    public static void convertNumberToCountingWord(int number) {
        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine"};
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
                "ninety"};
        String[] thousands = {"", "thousand", "million", "billion", "trillion", "quadrillion",
                "quintillion", "sextillion", "septillion", "octillion", "nonillion", "decillion",
                "undecillion", "duodecillion", "tredecillion", "quattuordecillion"};
        String[] hundreds = {"", "hundred"};

        String result = "";
        int thousandsIndex = 0;
        while (number > 0) {
            int hundredsDigit = number % 1000;
            if (hundredsDigit > 0) {
                String hundredsDigitWord = "";
                int hundredsDigitOnes = hundredsDigit % 10;
                int hundredsDigitTens = hundredsDigit / 10 % 10;
                int hundredsDigitHundreds = hundredsDigit / 100 % 10;

                if (hundredsDigitHundreds > 0) {
                    hundredsDigitWord += ones[hundredsDigitHundreds] + " " + hundreds[1] + " ";
                }

                if (hundredsDigitTens > 0) {
                    if (hundredsDigitTens == 1) {
                        hundredsDigitWord += teens[hundredsDigitOnes] + " ";
                    } else {
                        hundredsDigitWord += tens[hundredsDigitTens] + " ";
                    }
                }

                if (hundredsDigitTens != 1 && hundredsDigitOnes > 0) {
                    hundredsDigitWord += ones[hundredsDigitOnes] + " ";
                }

                hundredsDigitWord += thousands[thousandsIndex] + " ";
                result = hundredsDigitWord + result;
            }

            thousandsIndex++;
            number /= 1000;
        }

        System.out.println(result);
    }
}
