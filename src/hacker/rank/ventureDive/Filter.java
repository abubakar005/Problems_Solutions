package hacker.rank.ventureDive;

import java.util.function.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Create the Filter and Mapper classes here.
 */

class Filter {
    public static Predicate<String> nameStartingWithPrefix(String prefix) {
        // String name;
        Predicate<String> isPrefix = x -> x.startsWith(prefix);
        return isPrefix;
    }
}

class Mapper {
    public static Function<String, CharactersCount> getDistinctCharactersCount() {
        Function<String, CharactersCount> func = (String x) -> {
            Function<String, Long> count = xa -> xa.chars().distinct().count();
            CharactersCount cc = new CharactersCount(x, count.apply(x).intValue());
            return cc;
        };
        return func;
    }
}

class CharactersCount {
    private final String name;
    private final Integer distinctCharacterCount;

    public CharactersCount(String name, Integer distinctCharacterCount) {
        this.name = name;
        this.distinctCharacterCount = distinctCharacterCount;
    }

    @Override
    public String toString() {
        return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "aaryanna",
                "aayanna",
                "airianna",
                "alassandra",
                "allanna",
                "allannah",
                "allessandra",
                "allianna",
                "allyanna",
                "anastaisa",
                "anastashia",
                "anastasia",
                "annabella",
                "annabelle",
                "annebelle"
        );

        names.stream()
                .filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
                .map(Mapper.getDistinctCharactersCount())
                .forEachOrdered(System.out::println);
    }
}
