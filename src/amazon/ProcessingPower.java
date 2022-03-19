package amazon;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ProcessingPower {

    public static void main(String[] args){
       /* int[] processingPower = new int[]{1, 2, 3, 4};
        int[] bootingPower = new int[]{1, 2, 3, 4};
        int maxPower = 10;*/

        List<Integer> processingPower = Arrays.asList(3,6,1,3,4);
        List<Integer> bootingPower = Arrays.asList(2,1,3,4,5);
        int maxPower = 25;

        ProcessingPower test = new ProcessingPower();
        //System.out.println(test.maxLengthValidSubArray(processingPower, bootingPower, maxPower));   // output should be 2
        System.out.println(findMaximumSustainableClusterSize(processingPower, bootingPower, maxPower));
    }

    public int maxLengthValidSubArray(int[] processingPower, int[] bootingPower, int maxPower){
        if(processingPower == null || bootingPower == null
                || processingPower.length == 0 || processingPower.length != bootingPower.length){
            return 0;
        }

        PriorityQueue<Integer> maxBootingPower = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int maxLength = 0;
        int currentLength = 1;

        int start = 0;
        int end = 0;

        int currentSumProcessingPower = processingPower[0];
        maxBootingPower.add(bootingPower[0]);
        while(end < processingPower.length){
            int currentBootingPower = maxBootingPower.peek();
            int currentPower = currentBootingPower + currentSumProcessingPower * currentLength;

            if(currentPower <= maxPower){
                maxLength = currentLength;
                end++;
                currentLength++;
            }
            else{
                currentSumProcessingPower -= processingPower[start];
                maxBootingPower.remove(bootingPower[start]);
                start++;
                end++;
            }

            if(end < processingPower.length){
                maxBootingPower.add(bootingPower[end]);
                currentSumProcessingPower += processingPower[end];
            }
        }

        return maxLength;
    }

    public static int findMaximumSustainableClusterSize(List<Integer> processingPower, List<Integer> bootingPower, long powerMax) {
        int len = processingPower.size();
        if(len == 0 || processingPower == null || bootingPower == null) return 0;
        int ans = 0;
        for(int i=0;i<len;i++){
            int count = 1, maxCount=1, sum =0, mul;
            int max = Integer.MIN_VALUE;
            for(int j=i;j<len;j++){
                sum += processingPower.get(j);
                mul = sum * count;
                count++;

                max = Math.max(max,bootingPower.get(j));
                long tempPower = mul + max;
                if(tempPower <= powerMax){
                    System.out.println(tempPower);
                    ans = Math.max(maxCount, ans);
                    maxCount++;
                }else {maxCount = 1;}
            }
        }
        return ans;
    }
}
