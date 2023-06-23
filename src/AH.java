import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AH {

    public static void main(String[] args) {

        //MimeTypeUtils.APPLICATION_JSON_VALUE;
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Ali", "Ahmed", 10));
        customers.add(new Customer("Sami", "Jawad", 12));
        customers.add(new Customer("Hasan", "Khalil", 8));

     //   System.out.println(getAllNames(customers, 10));
        int n = 3;
        StringBuilder str = new StringBuilder();
        IntStream.rangeClosed(1, n)
                .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? str.append("FizzBuzz") : str.append("Fizz")) : (i % 5 == 0 ? str.append("Buzz") : i))
                .forEach(System.out::println);


    }

    public static String dnaComplement(String dna) {

        /*Map<Character, Character> dnaComplement = Map.of(
                'A', 'T',
                'T', 'A',
                'C', 'G',
                'G', 'C'
        );

        if(dna.isEmpty())
            return "";

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i<dna.length(); i++) {
            builder.append(dnaComplement.get(dna.charAt(i)));
        }

        return builder.toString(); */
        return null;
    }

    public static List<String> getAllNames(List<Customer> customers, int minAge) {
        // your solution here

        return customers.stream()
                .filter(c -> (c.getAge()>minAge || c.getAge()==minAge))
                .sorted(Comparator.comparing(Customer::getLastName).thenComparing(Customer::getFirstName))
                .map(c -> c.getLastName()+", "+c.getFirstName())
                .collect(Collectors.toList());
    }



    static class Customer {

        Customer (String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        String firstName;
        String lastName;
        int age;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
