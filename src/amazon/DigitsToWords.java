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

}
