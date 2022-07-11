package generic.problems;

public class CountUniqueCharacters {

    public static void main(String[] args) {

        String str = "hello";
        System.out.println(countUniqueCharacters(str));
        System.out.println(countUniqueCharactersStream(str));
    }

    public static int countUniqueCharacters(String input) {

        boolean[] isItThere = new boolean[Character.MAX_VALUE];

        for (int i = 0; i < input.length(); i++) {
            isItThere[input.charAt(i)] = true;
        }

        int count = 0;
        for (int i = 0; i < isItThere.length; i++) {
            if (isItThere[i] == true){
                count++;
            }
        }

        return count;
    }

    public static long countUniqueCharactersStream(String input) {
        return input.chars()
                .distinct()
                .count();
    }
}
