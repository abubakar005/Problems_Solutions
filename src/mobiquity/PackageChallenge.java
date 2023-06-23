package mobiquity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PackageChallenge {

    static class Item {
        int index;
        double weight;
        int cost;

        public Item(int index, double weight, int cost) {
            this.index = index;
            this.weight = weight;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }
    }

    static class Item1 implements Comparable<Item1> {
        int index;
        double weight;
        int cost;
        double costWeightRatio;

        public Item1(int index, double weight, int cost) {
            this.index = index;
            this.weight = weight;
            this.cost = cost;
            this.costWeightRatio = cost / weight;
        }

        @Override
        public int compareTo(Item1 other) {
            return Double.compare(other.costWeightRatio, this.costWeightRatio);
        }
    }

    public static void main(String[] args) {
        double packageLimit = 10;
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(1, 3, 5));
        items.add(new Item(2, 2, 3));
        items.add(new Item(3, 2, 2));
        items.add(new Item(4, 4, 8));
        items.add(new Item(5, 4, 10));

        double packageLimit2 = 81;
        ArrayList<Item> items2 = new ArrayList<>();
        items2.add(new Item(1, 53.38, 45));
        items2.add(new Item(2, 88.62, 98));
        items2.add(new Item(3, 78.48, 3));
        items2.add(new Item(4, 72.30, 76));
        items2.add(new Item(5, 30.18, 9));
        items2.add(new Item(6, 46.34, 48));

        double packageLimit3 = 8;
        ArrayList<Item> items3 = new ArrayList<Item>();
        items3.add(new Item(1, 15.3, 34));


        double packageLimit4 = 75;
        ArrayList<Item> items4 = new ArrayList<>();
        items4.add(new Item(1, 85.31, 29));
        items4.add(new Item(2, 14.55, 74));
        items4.add(new Item(3, 3.98, 16));
        items4.add(new Item(4, 26.24, 55));
        items4.add(new Item(5, 63.69, 52));
        items4.add(new Item(6, 76.25, 75));
        items4.add(new Item(7, 60.02, 74));
        items4.add(new Item(8, 93.18, 35));
        items4.add(new Item(9, 89.95, 78));

        double packageLimit5 = 56;
        ArrayList<Item> items5 = new ArrayList<>();
        items5.add(new Item(1, 90.72, 13));
        items5.add(new Item(2, 33.80, 40));
        items5.add(new Item(3, 43.15, 10));
        items5.add(new Item(4, 37.97, 16));
        items5.add(new Item(5, 46.81, 36));
        items5.add(new Item(6, 48.77, 79));
        items5.add(new Item(7, 81.80, 45));
        items5.add(new Item(8, 19.36, 79));
        items5.add(new Item(9, 6.76, 64));

        List<Item> result = knapsack(items5, packageLimit5);
       // List<Integer> listaa = selectItems(items4, packageLimit4);
      //  listaa.forEach(System.out::println);

        System.out.println("Selected items:");
        for (Item item : result) {
            System.out.println("Item " + item.index + " (weight: " + item.weight + ", cost: " + item.cost + ")");
        }
    }

    private static List<Integer> findBestPackage(int weightLimit, List<Item> items) {
        List<Integer> bestPackage = null;
        double bestCost = 0;
        for (int i = 0; i < (1 << items.size()); i++) {
            List<Integer> currentPackage = new ArrayList<>();
            double currentCost = 0;
            for (int j = 0; j < items.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    currentPackage.add(j + 1);
                    currentCost += items.get(j).cost;
                }
            }
            if (currentPackage.size() > 0 && currentCost > bestCost && currentPackage.stream().mapToDouble(it -> items.get(it - 1).weight).sum() <= weightLimit) {
                bestPackage = currentPackage;
                bestCost = currentCost;
            }
        }
        return bestPackage;
    }

    public static ArrayList<Item> knapsack(ArrayList<Item> items, double packageLimit) {

        System.out.println("Before.............");
        print(items);
/*
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                double ratio1 = item1.cost / item1.weight;
                double ratio2 = item2.cost / item2.weight;
                System.out.println("[item1: " + item1.index + "] [ratio1: " + ratio1 + "] ---- [item2: " + item2.index +  "] [ ratio2: " + ratio2);
                if (ratio1 < ratio2) {
                    return 1;
                } else if (ratio1 > ratio2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        */
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                double ratio1 = i1.cost / i1.weight +i1.cost;
                double ratio2 = i2.cost / i2.weight + i2.cost;
                if (ratio1 == ratio2) {
                    return Double.compare(i1.weight, i2.weight);
                }
                return Double.compare(ratio2, ratio1);
            }
        });

        System.out.println("After.............");
        print(items);

        ArrayList<Item> selectedItems = new ArrayList<>();
        double totalWeight = 0;
        for (Item item : items) {
            if (totalWeight + item.weight <= packageLimit) {
                selectedItems.add(item);
                totalWeight += item.weight;
            }
        }

        return selectedItems;
    }

    private static List<Item> solveKnapsackProblem(ArrayList<Item> items, double weightLimit) {
        int n = items.size();
        double[][] dp = new double[n + 1][(int) (weightLimit + 1)];
        int[][] parent = new int[n + 1][(int) (weightLimit + 1)];
        for (int i = 1; i <= n; i++) {
            Item item = items.get(i - 1);
            for (int j = 0; j <= weightLimit; j++) {
                if (item.weight > j) {
                    dp[i][j] = dp[i - 1][j];
                    parent[i][j] = j;
                } else {
                    double take = dp[i - 1][(int) (j - item.weight)] + item.cost;
                    double leave = dp[i - 1][j];
                    if (take > leave) {
                        dp[i][j] = take;
                        parent[i][j] = (int) (j - item.weight);
                    } else {
                        dp[i][j] = leave;
                        parent[i][j] = j;
                    }
                }
            }
        }
        List<Item> result = new ArrayList<>();
        int i = n, j = (int) weightLimit;
        while (i > 0 && j > 0) {
            if (parent[i][j] != j) {
                result.add(items.get(i - 1));
            }
            int temp = j;
            j = parent[i][j];
            i--;
            parent[i][temp] = j;
        }
        Collections.reverse(result);
        return result;
    }

    private static List<Integer> findBestPackage(List<Item> items, double maxWeight) {
        int n = items.size();
        int[][] dp = new int[n + 1][(int) maxWeight + 1];

        // Build table dp[][] in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                if (items.get(i - 1).weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][(int) (j - items.get(i - 1).weight)] + items.get(i - 1).cost);
                }
            }
        }

        // Find items in the best package
        List<Integer> result = new ArrayList<>();
        int i = n, j = (int) maxWeight;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                result.add(items.get(i - 1).index);
                j -= items.get(i - 1).weight;
            }
            i--;
        }
        Collections.sort(result);
        return result;
    }

    public static List<Integer> fillPackage(List<Item1> items, double maxWeight) {
        // Sort the items in non-increasing order of their cost-to-weight ratios
        Collections.sort(items);

        List<Integer> selectedItems = new ArrayList<>();
        double remainingWeight = maxWeight;

        for (Item1 item : items) {
            if (remainingWeight <= 0) {
                break;
            }
            if (item.weight <= remainingWeight) {
                selectedItems.add(item.index);
                remainingWeight -= item.weight;
            }
        }

        return selectedItems;
    }

    public static List<Integer> selectItems(List<Item> items, double weightLimit) {
        // Sort the items by their cost in descending order
        Collections.sort(items, Comparator.comparingInt(Item::getCost).reversed());

        int n = items.size();
        double[][] dp = new double[n + 1][(int) weightLimit + 1];
        boolean[][] selected = new boolean[n + 1][(int) weightLimit + 1];

        // Calculate the maximum cost for each weight limit up to the total weight limit
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= weightLimit; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (items.get(i - 1).weight <= j) {
                    double includeCost = items.get(i - 1).cost + dp[i - 1][(int) (j - items.get(i - 1).weight)];
                    double excludeCost = dp[i - 1][j];

                    if (includeCost > excludeCost && items.get(i - 1).weight <= j) {
                        dp[i][j] = includeCost;
                        selected[i][j] = true;
                    } else {
                        dp[i][j] = excludeCost;
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Get the selected items that have the maximum cost and total weight less than or equal to the weight limit
        List<Integer> result = new ArrayList<>();
        int i = n;
        int j = (int) weightLimit;
        while (i > 0 && j > 0) {
            if (selected[i][j]) {
                result.add(items.get(i - 1).index);
                j -= items.get(i - 1).weight;
            }
            i--;
        }
        Collections.sort(result);

        return result;
    }

    private static List<Item> findBestCombination(List<Item> items, double maxWeight) {
        int n = items.size();
        double[][] dp = new double[n + 1][(int) (maxWeight + 1)];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else {
                    Item item = items.get(i - 1);
                    if (item.weight > w) {
                        dp[i][w] = dp[i - 1][w];
                    } else {
                        dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][(int) (w - item.weight)] + item.cost);
                    }
                }
            }
        }
        List<Item> result = new ArrayList<>();
        int i = n;
        int w = (int) maxWeight;
        while (i > 0 && w > 0) {
            if (dp[i][w] != dp[i - 1][w]) {
                Item item = items.get(i - 1);
                result.add(item);
                w -= item.weight;
            }
            i--;
        }
        Collections.reverse(result);
        return result;
    }



    private static void print(ArrayList<Item> items) {
        for (Item item : items) {
            System.out.println("Item " + item.index + " (weight: " + item.weight + ", cost: " + item.cost + ") ||| Profit Ration: " + item.cost/item.weight);
        }
    }
}

