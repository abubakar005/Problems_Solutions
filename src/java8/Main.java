package java8;

import java8.dto.PersonWithContacts;
import stream.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("ali", 21, 500));
        list.add(new Employee("hammad", 25, 850));
        list.add(new Employee("mohsin", 36, 620));
        list.add(new Employee("qaum", 20, 795));
        list.add(new Employee("kali", 35, 1500));
        list.add(new Employee("nomi", 41, 1600));
        list.add(new Employee("zainab", 50, 2500));
        list.add(new Employee("munib", 22, 500));

        List<PersonWithContacts> contactPersons = new ArrayList<>();
        contactPersons.add(new PersonWithContacts("ali", 21, Arrays.asList("3222244455", "9853475"), true));
        contactPersons.add(new PersonWithContacts("hasan", 25, Arrays.asList("1234567"), true));
        contactPersons.add(new PersonWithContacts("naveed", 23, Arrays.asList("458951254", "45789545"), true));
        contactPersons.add(new PersonWithContacts("mubin", 28, Arrays.asList("2365784"), true));
        contactPersons.add(new PersonWithContacts("fakhar", 35, Arrays.asList("96214568", "0145876"), true));

        // find list of employees whose age is greater than 25 and less than 40
        List<Employee> collect = list.stream()
                .filter(e -> e.getAge() > 25 && e.getAge() < 40)
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());

        // Employee who have max salary
        Employee maxSalary1 = list.stream()
                .sorted((e1, e2) -> e2.getSalary()-e1.getSalary())
                .findFirst()
                .get();

        Employee maxSalary2 = list.stream()
                .reduce((e1, e2) -> {
                   if(e1.getSalary() > e2.getSalary())
                       return e1;
                   else
                       return e2;
                })
                .get();

        // have some specific salary like 500
        List<Employee> sameSalary = list.stream()
                .filter(e -> e.getSalary() == 500)
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());

        // Count of employees whos age is greater than 25
        long ageMoreOf25 = list.stream()
                .filter(e -> e.getAge() > 25)
                .count();

        // marking inactive whose age is greater then 25
        contactPersons.stream()
                .filter(p -> p.getAge() > 25)
                .forEach(p -> p.setActive(false));
    //    contactPersons.stream().forEach(System.out::println);


        // getting all contacts
        List<List<String>> contacts = contactPersons.stream()
                .map(PersonWithContacts::getContacts)
                .collect(Collectors.toList());

        List<String> contactsWithFlatMap = contactPersons.stream()
                .flatMap(p -> p.getContacts().stream())
                .collect(Collectors.toList());

        //System.out.println(contactsWithFlatMap);


        // get a map of person with all contacts linked
        Map<String, List<String>> map = contactPersons.stream()
                .collect(Collectors.toMap(key -> key.getName(), val -> val.getContacts()));

        map.forEach((key, val) -> System.out.println(key+" "+val));

        //list.stream().max((Comparator.comparingInt(Integer::intValue))).ifPresent(System.out::println);
        //System.out.println(a.get());

        //list.stream().filter(x -> x==3).findFirst().ifPresent(System.out::println);


       // int s = list.stream().collect(Collectors.summingInt(Integer::intValue));

       // int a = list.stream().mapToInt(Integer::intValue).sum();


        try {
          //  main.test ();
            //main.test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, List<String>> listToMap(List<PersonWithContacts> contacts) {
        return contacts.stream().collect(Collectors.toMap(PersonWithContacts::getName, PersonWithContacts::getContacts));
    }

    private void test () throws Exception {

        Map<String, String> myMap = new HashMap<String, String>() {{
            put("key1", "value1");
            put("key2", "value2");
        }};

        Map<String, String> myMap2 = new HashMap<String, String>() {{
            put("key3", "value3");
            put("key4", "value4");
        }};

        Map<String, String> myMap3 = new HashMap<String, String>() {{
            put("key5", "value5");
            put("key6", "value6");
        }};

        String consumerNo = "value6m";

        List<Map<String, String>> mapList = new ArrayList<>();
        mapList.add(myMap);
        mapList.add(myMap2);
        mapList.add(myMap3);
        //List<Map<String, String>> mapList = Arrays.asList(myMap, myMap2, myMap3);
        List<Map<String, String>> toRemove = new ArrayList<>();

        try {
            if(mapList.size() > 0) {

                System.out.println("----------");
                System.out.println("Size: " + mapList.size());

                // Remove the current element from the iterator and the list.
               // mapList.removeIf(Map::isEmpty);


                //Search if a MSISDN already exists in meta
                for (Map<String, String> searchMap : mapList) {

                    for (String key : searchMap.keySet()) {

                        if (consumerNo.equals(searchMap.get(key))) {
                            //mapList.remove(searchMap);
                            toRemove.add(searchMap);
                        }

                       // mapList.removeIf(k -> consumerNo.equals(searchMap.get(key)));
                    }
                }

                mapList.removeAll(toRemove);
                System.out.println("Size: " + mapList.size());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test2() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        for (String str : list) {
            if ("A".equals(str)) {  // Here's the difference!
                list.remove(str);
            } else {
                System.out.println(str);
            }
        }
    }
}
