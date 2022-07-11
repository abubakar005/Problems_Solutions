package toptal;

import java.util.concurrent.atomic.AtomicReference;

public class CropMessage {

    public static void main(String[] args) {

        CropMessage cm = new CropMessage();
        String msg = "Codility We test coders";
        String msg1 = "To crop or not to crop";
        int K = 21;

        System.out.println(System.currentTimeMillis());
        System.out.println("Result: " + cm.solution(msg1, K));
        System.out.println(System.currentTimeMillis());

        System.out.println("---------------------");

        System.out.println(System.currentTimeMillis());
        System.out.println("Result: " + cm.test(msg1, K));
        System.out.println(System.currentTimeMillis());
    }

    public String solution3(String message, int K) {
        // write your code in Java SE 8
        String result = null;
        StringBuilder builder = new StringBuilder();

        if(message == null || message.isEmpty())
            return message;

        message = message.trim();

        if(message.length() <= K)
            return message;

        String [] words = message.split(" ");

        for(String w: words) {

            builder.append(w);

            if(builder.toString().length() > K) {
                return result;
            } else {
                result = builder.toString();
                builder.append(" ");
            }
        }

        return result.trim();
    }

    public String solution2(String message, int K) {
        // write your code in Java SE 8
        String result = "";
        StringBuilder builder = new StringBuilder();

        if(message.length() <= K)
            return message;

        for(char c: message.toCharArray()) {

            if(c == ' ') {
                if(builder.toString().length() > K)
                    return result;
                else {
                    result = builder.toString();
                }
            }

            builder.append(c);
        }

        return result;
    }

    /** As per my opinion this is best way to do */
    public String solution(String message, int K) {
        // write your code in Java SE 8
        String result = "";

        if(message.length() <= K)
            return message;

        int index = K-1;
        if(message.charAt(index) == ' ')
            return message.substring(0, index);

        if(message.charAt(index+1) == ' ')
            return message.substring(0, index+1);

        String str = message.substring(0, K);

        for(int i=K-2; i>=0; i--) {

            if(str.charAt(i) == ' ')
                return str.substring(0, i);
        }

        return result;
    }

    public String test(String input, int K) {

        StringBuilder builder = new StringBuilder();
        AtomicReference<String> result = new AtomicReference<>("");

        input.chars().forEach(c -> {

            if(c == ' ') {
                if(builder.toString().length() > K)
                    return;

                result.set(builder.toString());
            }

            builder.append(c);
        });

        return result.get();
    }
}
