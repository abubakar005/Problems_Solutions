import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import mypackage.Math;
import mypackage.elementary.*;

public class Main {

    static int count = 0;
    int var = 10;


    public static DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static LocalDate parseLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DEFAULT_DATE_FORMATTER);
    }

    public static void main(String args[]){


        String st = "{\"meterCollector\":[{\"parameter\":\"heartbeat\",\"value\":\"{\\\"modelName\\\":\\\"modelName\\\",\\\"deviceName\\\":\\\"router\\\",\\\"version\\\":\\\"version\\\",\\\"powerSource\\\":\\\"powerSource\\\",\\\"macAddress\\\":\\\"28:1c:02:20:41:98\\\",\\\"serialNumber\\\":\\\"serialNumber\\\",\\\"wwan_ip\\\":\\\"10.72.22.6\\\",\\\"time\\\":1604509280}\"}]}";

        System.out.println(st);
        st = st.replaceAll("\\\\", "");
        System.out.println(st);


        Main main = new Main();
        System.out.println("Hello   " + main.var);
        //Math.round();
        int x = 7 , y = 4;

        x = x+y;
        y= x-y;
        x=x-y;

        System.out.println("x: " + x + " y: " + y);


        String str1 = "tdhello";
        String[] arr = str1.split("td");
        System.out.println("arr: " + Arrays.toString(arr));

        String str = "false";
        boolean res = Boolean.parseBoolean(str);
        System.out.println("res: " + res);


        String date = "2021-06-09";

        LocalDate cnicIssueDate = parseLocalDate(date.replace("-",""));
        System.out.println("cnicIssueDate: " + cnicIssueDate);





        String array[] = {"5", "hello", "abc", "2", "10", "0", "9", "cde"};
        List<String> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(Arrays.asList(array));
        System.out.print(Arrays.toString(array));

        /*Map<String, Integer> map = new HashMap<>();
        map.put("guitar", 1200);
        map.put("cello", 3000);
        map.put("drum", 200);
        map.put("cello", 4500);
        System.out.print(map.size());*/


    //    System.out.println(Math.abs(123));

       /* int array[] = {1, 2, 3, 4};
            for (int i = 0; i < array.size(); i++) {
                System.out.print(array[i]);
        }*/

        /*String message = "Hello wold!";
        String newMessage = message.substring(6, 12)
                + message.substring(12, 6);
        System.out.println(newMessage);*/

        /*List list = new ArrayList();
        list.add("hello");
        list.add(2);
        System.out.print(list.get(0) instanceof Object);
        System.out.print(list.get(1) instanceof Integer);*/


       /* if(count <3){
            count++;
            main(null);
        }else{
            return;
        }
        System.out.println("Hello World");*/


       /* List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(Boolean.parseBoolean("False"));
        list.add(Boolean.TRUE);
        System.out.print(list.size());
        System.out.print(list.get(1) instanceof Boolean);*/



       /* List list = new ArrayList<String>();
        list.add("Hello");
        list.add("word");
        list.add("test");

        System.out.println("list: " + list);
        Collections.sort(list);
        System.out.println("list: " + list);*/

       /* for (int i=0; i<10; i++){
            i+=1;
           // i=i++;
            System.out.println("I: " + i);
            System.out.println("Hello World!");
        }*/

        double value = 200.3446;
        long val = 2;

        double devideResult = value/val;
    //    System.out.println("Result: " + devideResult);

        String result = String.format("%.2f", devideResult);
     //   System.out.println("Result: " + result);
    }

   /* public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }*/

    Object message() {
        return "Hello!";
    }


}
