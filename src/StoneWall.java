import java.util.ArrayList;

public class StoneWall {

    public int solution(int[] H)
    {
        // rules
        /*
         * so when we find two indices that are of the same height, we can use the same block, providing all the values in-between are higher.
         *
         * if we find a lower value, end the block.

         * idea - store a list of currently-active blocks. next interations can build upon top of these.
         * once the height of an index is lower than an active block, remove that block from activity, and add a new block equaling the index's height
         * to the active list.

         * are we able to accurately track the number of blocks used by doing this?

         * Must be O(N) - no inner loops.
         * no addition or multiplication - should be safe using ints rather than longs.



         * extra - can we store blocks individual heights in the list rather than total height? an int tracking total height?
         */

        int numberOfBlocks = 0;
        int totalHeight = 0;

        final ArrayList<Integer> activeBlocks = new ArrayList<Integer>(); // depending on this being insertion-order.

        for (int i = 0; i < H.length; i++)
        {
            int height = H[i];

            if (totalHeight > height)
            {
                // remove block(s) - add another if necessary.

                for (int j = activeBlocks.size() - 1; j >= 0; j--) // first trouble - how do we scan and remove lesser blocks in O(N) time... is it still O(N)?
                {
                    int latestBlock = activeBlocks.get(j);
                    activeBlocks.remove(j);
                    totalHeight -= latestBlock;

                    if ((totalHeight) <= height) // removed the latest block and now we're not too high.
                    {
                        // we're done.
                        break;
                    }
                }

                // adding the other if necessary.
                if (totalHeight < height)
                {
                    int newBlock = height - totalHeight;
                    totalHeight += newBlock;
                    activeBlocks.add(newBlock);
                    numberOfBlocks++;
                }

            }
            else if (totalHeight == height)
            {
                continue;
            }
            else
            {
                int newBlock = height - totalHeight;
                activeBlocks.add(newBlock);
                totalHeight += newBlock;

                // add a block. increase total height.
                numberOfBlocks++;
            }
        }

        return numberOfBlocks;
    }

    public static int solution(int[] A, int N) {
        int bushstrokes = 0;
        int a = 4;//A.Max();   /// need to correct according to java
        for (int i = 0; i < a; i++)
        {
            int iter = 0;
            while (iter < N)
            {
                if (A[iter] < i + 1)
                    if (iter != 0 && A[iter - 1] >= i + 1)
                    {
                        bushstrokes++;
                        iter++;
                        continue;
                    }
                iter++;
            }
            if (A[iter - 1] >= i + 1)
                bushstrokes++;
        }
        return bushstrokes;
    }
}
