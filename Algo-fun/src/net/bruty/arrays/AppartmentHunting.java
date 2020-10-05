package net.bruty.arrays;

import java.util.List;
import java.util.Map;

public class AppartmentHunting {
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[][] minDistances = new int[reqs.length][];
        for (int i = 0; i < reqs.length; i++) {
            minDistances[i] = getMinDistances(blocks, reqs[i]);
        }
        // Get the maximum distance out of all the reqs
        int[] maxDistances = getMaxDistances(blocks, minDistances);
        return getMinIdx(maxDistances);
    }

    private static int[] getMinDistances(List<Map<String, Boolean>> blocks, String req) {
        int[] minDisntaces = new int[blocks.size()];
        int closestReqIdx = Integer.MAX_VALUE;
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).get(req)) closestReqIdx = i;
            minDisntaces[i] = Math.abs(i - closestReqIdx);
        }
        // Go back trough and ensure all values are correct
        for (int i = blocks.size() - 1; i >= 0; i--) {
            if (blocks.get(i).get(req)) closestReqIdx = i;
            // The minimum between currently stored and new computed value is the closest at index i
            minDisntaces[i] = Math.min(minDisntaces[i], Math.abs(i - closestReqIdx));
        }
        return minDisntaces;
    }

    private static int[] getMaxDistances(List<Map<String, Boolean>> blocks, int[][] minDistances) {
        int[] maxDistancesAtBlocks = new int[blocks.size()];
        for (int i = 0; i < blocks.size(); i++) {
            int[] minDistancesAtBlock = new int[minDistances.length];
            for (int j = 0; j < minDistances.length; j++) {
                minDistancesAtBlock[j] = minDistances[j][i];
            }
            maxDistancesAtBlocks[i] = maxFromArray(minDistancesAtBlock);
        }
        return maxDistancesAtBlocks;
    }

    private static int getMinIdx(int[] array) {
        int idxAtMin = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            if (current < minValue){
                minValue = current;
                idxAtMin = i;
            }
        }
        return idxAtMin;
    }

    private static int maxFromArray(int[] array) {
        int currMax = array[0];
        for (int i : array) {
            if (i > currMax) currMax = i;
        }
        return currMax;
    }

}
