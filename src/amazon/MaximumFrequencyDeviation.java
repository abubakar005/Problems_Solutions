package amazon;

public class MaximumFrequencyDeviation {

    public static void main(String[] args) {
        String s = "abdbcdacbcadbbc";
        findMaxPossibleFrequencyDeviation(s);
    }

    public static void findMaxPossibleFrequencyDeviation(String s)
    {
        int[] freq = new int[26];
        for (int i = 0; i < s.length();) {
            int j = i;
            int maxFreq = 0;
            while(j < s.length() && s.charAt(j) == s.charAt(i) )
            {
                j++;
                maxFreq++;
            }

            if(maxFreq==0)
                maxFreq++;
            if(freq[s.charAt(i)-'a'] == 0)
                freq[s.charAt(i)-'a'] = maxFreq;
            else if(freq[s.charAt(i)-'a'] < maxFreq)
                freq[s.charAt(i)-'a'] = maxFreq;
            i = j;
        }
        System.out.println((findMax(freq) -findMin(freq)));
    }

    public static int findMax(int[] arr)
    {
        int max = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static int findMin(int[] arr)
    {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] < min && arr[i] != 0)
                min = arr[i];
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
    }
}
