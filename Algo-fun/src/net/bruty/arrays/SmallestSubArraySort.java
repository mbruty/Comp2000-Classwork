package net.bruty.arrays;

// Find the smallest subarray inside an array that needs to be sorted in order for the entire array to be sorted
public class SmallestSubArraySort {

    public static int[] subarraySort(int[] array) {
        // Find the value of the two numbers that are out of order
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++){
            if (isOutOfOrder(i, array[i], array)){
                minOutOfOrder = Math.min(minOutOfOrder, array[i]);
                maxOutOfOrder = Math.max(maxOutOfOrder, array[i]);
            }
        }
        if (minOutOfOrder == Integer.MAX_VALUE) return new int[] {-1, -1};
        int smallerPtr = 0;
        while(minOutOfOrder >= array[smallerPtr]){
            smallerPtr++;
        }
        int largerPtr = array.length - 1;
        while (maxOutOfOrder <= array[largerPtr]){
            largerPtr--;
        }
        return new int[] {smallerPtr, largerPtr};
    }

    private static boolean isOutOfOrder(int i, int num, int[] array){
        if(i == 0) return num > array[i + 1];
        if (i == array.length - 1) return num < array[i - 1];
        return num > array[i + 1] || num < array[i - 1];
    }
}
