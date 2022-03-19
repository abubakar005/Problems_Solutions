package amazon;

import java.util.*;

public class AmazonPackages {

    static class SinglePackage {
        int count;
        StringBuilder items;

        SinglePackage (String item) {
            count = 1;
            items = new StringBuilder(item);
        }

        void add (String item) {
            count++;
            items.append(" ").append(item);
        }
    }

    public static List<List<String>> performWarehouseQueries2(List<List<String>> queries) {

        List<SinglePackage> list = new ArrayList<>();
        int currentIndex = 0;
        List<List<String>> result = new ArrayList<>();

        for(List<String> query : queries) {

            if(query.get(0).equals("INSERT")) {

                SinglePackage currentPackage;

                if(list.isEmpty()) {
                    currentPackage = new SinglePackage(query.get(1));
                    list.add(currentPackage);
                } else {
                    currentPackage = list.get(currentIndex);

                    if(currentPackage.count == 3) {
                        currentIndex++;
                        currentPackage = new SinglePackage(query.get(1));
                        list.add(currentPackage);
                    } else {
                        currentPackage.add(query.get(1));
                    }
                }
            } else if (query.get(0).equals("SHIP")) {

                if(list.size() > 1) {
                    SinglePackage removedPackage = list.remove(0);
                    result.add(Arrays.asList(removedPackage.items.toString()));
                    currentIndex--;
                } else {

                    if(list.isEmpty() || list.get(currentIndex).count < 3 )
                        result.add(Arrays.asList("N/A"));
                    else
                        result.add(Arrays.asList(list.remove(currentIndex).items.toString()));
                }
            }
        }
        return result;
    }

    public static List<List<String>> performWarehouseQueries(List<List<String>> queries) {

        List<List<String>> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        for(List<String> query : queries) {
            if(query.get(0).equals("INSERT"))
                queue.add(query.get(1));
            else if (query.get(0).equals("SHIP")) {
                List<String> pack = new ArrayList<>();
                if(queue.size()>=3){
                    for(int i=0; i<3; i++) {
                        pack.add(queue.remove());
                    }
                } else {
                    pack.add("N/A");
                }
                result.add(pack);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> queries = new ArrayList<>();
        List<String> query = null;

        queries.add(Arrays.asList("INSERT", "NJ513501348"));
        queries.add(Arrays.asList("INSERT", "GP235136011"));
     //   queries.add(Arrays.asList("SHIP", "-"));
        queries.add(Arrays.asList("INSERT", "ER6245096201"));
        queries.add(Arrays.asList("INSERT", "NJ7006246135"));
     //   queries.add(Arrays.asList("SHIP", "-"));
        queries.add(Arrays.asList("INSERT", "BG6245028637"));
        queries.add(Arrays.asList("INSERT", "NY7006246980"));
        queries.add(Arrays.asList("SHIP", "-"));
       // queries.add(Arrays.asList("SHIP", "-"));

        List<List<String>> result = performWarehouseQueries2(queries);

        for(List<String> pack : result) {
            for(String order : pack)
                System.out.print(order + " ");
            System.out.println();
        }
    }
}
