package zalando;

import java.util.*;

public class Question3 {

    public static void main(String[] args) {

        String[] arr = {"801234567", "180234567", "0", "189234567", "891234567", "98", "9"};
        String[] arr2 = {"039", "4", "14", "32", "", "34", "7"};
        String[] arr3 = {"5421", "245", "1452", "0345", "53", "345"};

        System.out.println(solutions(arr3));
        //System.out.println(solutions(new String[]{"039", "4", "14", "32", "", "34", "7"}));
    }

    static int solutions(String[] E) {

        Map<Integer, List<Integer>> employeeMapForDays = new HashMap<>();
        int employee = 0;

        for(String employeeDays : E) {

            List<Integer> listOfDays = new ArrayList<>();

            for (int i =0; i < employeeDays.length(); i++) {
                int day = Integer.parseInt(String.valueOf(employeeDays.charAt(i)));
                listOfDays.add(day);
            }
            employeeMapForDays.put(employee, listOfDays);
            employee++;
        }

        Map<Integer, Long> daysCountMap = new HashMap<>();

        for(List<Integer> employeeDaysList : employeeMapForDays.values()) {
            for(Integer day : employeeDaysList) {
                Long dayCount = daysCountMap.get(day);
                if (dayCount == null)
                    dayCount =0L;

                daysCountMap.put(day, dayCount+1);
            }
        }

        daysCountMap.values().removeIf(daysCount -> daysCount == 1L);

        Map<String, Integer> daysMap = new HashMap<>();
        Set<Integer> daysSet = daysCountMap.keySet();

        for (String daysOfEmployee : E) {
            for (int day : daysSet) {
                if (daysOfEmployee.contains(String.valueOf(day))){
                    daysMap.put(daysOfEmployee, day);
                }
            }
        }

        return daysMap.entrySet().size();
    }
}

