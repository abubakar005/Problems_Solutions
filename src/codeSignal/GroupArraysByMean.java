package codeSignal;

import java.util.*;

public class GroupArraysByMean {

    public static void main(String args[]){

        GroupArraysByMean groupArraysByMean = new GroupArraysByMean();

        int[][] a = {{3, 3, 4, 2},
                {4, 4},
                {4, 0, 3, 3},
                {2, 3},
                {3, 3, 3}};

        int[][] b = {{-5, 2, 3},
                {0, 0},
                {0},
                {-100, 100}};

        int[][] response = groupArraysByMean.solution2(b);

        for(int[] arr: response)
            System.out.println(Arrays.toString(arr));
    }


    public int[][] solution(int[][] a) {

        Map<Double, List<Integer>> map = new HashMap<>();
        //TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();

        for(int i=0; i<a.length; i++) {

            double mean = 0;
            int j=0;

            for(; j<a[i].length; j++)
                mean += a[i][j];

            mean = mean/j;

            if(map.containsKey(mean)) {
                List<Integer> list = map.get(mean);
                list.add(i);
                map.put(mean, list);

             //   treeMap.put(i, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(mean, list);
             //   treeMap.put(i, list);
            }
        }

        int[][] result = new int[map.size()][0];
        int i = 0;

        for(List<Integer> list : map.values()) {

            int[] subArray = getArray(list);
           // Arrays.sort(subArray);
            result[i++] = subArray;
        }

        //Arrays.sort(result);
        return result;
    }


    public int[][] solution2(int[][] a) {

        Map<Double, TreeMap<Integer, List<Integer>>> map = new HashMap<>();
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();

        for(int i=0; i<a.length; i++) {

            double mean = 0;
            int j=0;

            for(; j<a[i].length; j++)
                mean += a[i][j];

            mean = mean/j;

            if(map.containsKey(mean)) {
                TreeMap<Integer, List<Integer>> oldTree = map.get(mean);
                List<Integer> list = oldTree.firstEntry().getValue();
                list.add(i);

                TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
                tree.put(Math.min(i, oldTree.firstEntry().getKey()), list);
                map.put(mean, tree);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);

                TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
                tree.put(i, list);
                map.put(mean, tree);
            }
        }

        for(TreeMap<Integer, List<Integer>> tree : map.values())
            treeMap.putAll(tree);

        int[][] result = new int[treeMap.size()][0];
        int i = 0;

        for(List<Integer> list : treeMap.values()) {
            int[] subArray = getArray(list);
            result[i++] = subArray;
        }

        return result;
    }

    private int[] getArray(List list) {

        int[] arr = new int[list.size()];

        for(int i=0; i<arr.length; i++)
            arr[i] = (int)list.get(i);

        return arr;
    }

}
