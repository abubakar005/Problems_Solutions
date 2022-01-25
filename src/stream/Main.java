package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        List<Employee> list = new ArrayList<>();
        list.add(new Employee("ali", 21));
        list.add(new Employee("hammad", 25));
        list.add(new Employee("mohsin", 36));
        list.add(new Employee("qaum", 20));
        list.add(new Employee("kali", 45));


        // For a given List<Employee>, write a code using streams to fetch Employee List whose age is greater than 32
        // For a given List<Employee>, write a code using streams to sort Employee List by name in ASC order
        // For a given List<Employee>, write a code using streams to fetch first Employee whose age is greater than 32
        List<Employee> result = list.stream().filter(e-> e.age>32).collect(Collectors.toList());
      //  result.forEach(System.out::println);
        //System.out.println("result:: " + Arrays.toString(result.));

        Optional<Employee> a = list.stream().filter(e-> e.age>32).findFirst();
        System.out.println("First Employee: " + a.get());

        list.forEach(System.out::println);
        System.out.println("===============");
       // Stream<Employee> b = list.stream().sorted(C);

     //   list.stream().sorted(Comparator.comparingInt(Employee::getAge);


        List<Employee> sortedList = list.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);
    }
}
