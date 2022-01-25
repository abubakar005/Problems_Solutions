package codeSignal.upwork.practice.test;


import java.util.HashMap;
import java.util.Map;

/**         Problem statement
 You have installed a new tracking system in your local shop. The system tracks every time a customer enters or exits the shop.
 Now you'd like to test if the system works correctly.

 At the beginning and at the end of the day there are no customers in the shop.
 The system logs all the in and out movements of customers in a two-dimensional array of strings events,
 where events[i][0] is the unique id of the customer entering or exiting the shop, and events[i][1] is either "in" or "out",
 depending on the direction of movement of that customer.

 Your task is to write a function solution(events), which returns true if the system may have worked correctly, and false otherwise.

 Example

             For

             events = [
             ["John_0", "in"],
             ["Mary_0", "in"],
             ["John_0", "out"],
             ["Mary_0", "out"]
             ]
             the output should be solution(events) = true.

             For

             events = [
             ["John_0", "in"],
             ["John_0", "in"],
             ["John_0", "out"],
             ["John_0", "out"]
             ]
 the output should be solution(events) = false.

 The same person cannot enter the shop twice without exiting.

             For

             events = [
             ["John_0", "in"],
             ["John_1", "in"],
             ["John_1", "out"]
             ]
             the output should be solution(events) = false.

 The customer with the id John_0 cannot be in the shop at the end of the day.

 [example explanation]

 Input/Output

 [execution time limit] 3 seconds (java)

 [input] array.array.string events

 A two-dimensional array describing the entrances and exits of customers.

 events[i][0] is the id of the customer;
 events[i][1] is either "in" or "out".
 Guaranteed constraints:
 1 ≤ events.length ≤ 105,
 events[i].length = 2,
 1 ≤ events[i][0].length ≤ 20,
 events[i][1] ∈ { "in", "out" } .

 [output] boolean

 Whether or not the system may have worked correctly.

 */


public class Task4 {

    public static void main(String[] args) {

        Task4 task4 = new Task4();

        String[][] events = {
                {"John_0", "in"},
                {"John_1", "in"},
                {"John_1", "out"},
                {"John_2", "out"}};

        System.out.println("Result: " + task4.solution(events));
    }

    boolean solution(String[][] events) {

        Map<String, String> shopEntries = new HashMap<>();
        System.out.println("Array Size: " + events.length);


        for(int i=0; i<events.length; i++) {

            if(shopEntries.containsKey(events[i][0])) {

                String in = shopEntries.remove(events[i][0]);

                if(in.equals(events[i][1]))
                    return false;

            } else {
                shopEntries.put(events[i][0], events[i][1]);
            }
        }

        return shopEntries.isEmpty();
    }
}
