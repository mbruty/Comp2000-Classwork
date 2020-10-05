package net.bruty;


import java.util.*;

import net.bruty.BST.BST;
import net.bruty.arrays.AppartmentHunting;
import net.bruty.arrays.CalendarMatching;
import net.bruty.arrays.StringMeeting;
import net.bruty.sorting.*;

public class Main {

    public static void main(String[] args) {
        int[] data = createArray(1000000);
        int n = data.length;
        long startTime = System.nanoTime();
        Radix.radixsort(data, n);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / 1000000;
        System.out.println("Runtime duration: \t" + duration + "ms");
        System.out.println(checkArray(data));

        BST myBST = new BST(10);
        int[] bstValues = createArray(20);
        for (int i : bstValues) {
            myBST.insert(i);
        }
        myBST.remove(10, myBST);
        System.out.println(myBST.contains(15));
        System.out.println(BST.findClosestValue(myBST, 3));
        System.out.println(BST.validate(myBST));

        System.out.println("\t*** In order Traversal ***");
        List<Integer> BSTArr = myBST.inOrderTraversal();
        for (int i : BSTArr) {
            System.out.println(i);
        }
        System.out.println("\t*** Pre order Traversal ***");
        BSTArr = myBST.preOrderTraversal();
        for (int i : BSTArr) {
            System.out.println(i);
        }

        System.out.println("\t*** Post order Traversal ***");
        BSTArr = myBST.postOrderTraversal();
        for (int i : BSTArr) {
            System.out.println(i);
        }

        System.out.println("\t*** Min height ***");
        myBST.toMinHeight();
        myBST.printTree();

        System.out.println("\t*** Comparing Trees ***");
        // Creating a new bst with the original values, but will have a different structure
        // Because myBst is now changed to a min height bst
        BST newBST = new BST(10);

        for (int i : bstValues) {
            newBST.insert(i);
        }

        System.out.println(myBST.equals(newBST));

        // Creating a new bst with different values
        newBST = new BST(10);
        bstValues = createArray(20);
        for (int i : bstValues) {
            newBST.insert(i);
        }

        System.out.println(myBST.equals(newBST));

        System.out.println("\t *** Calendar Matching ***");
        List<StringMeeting> calendar1 = new ArrayList<>();
        calendar1.add(new StringMeeting("9:00", "10:30"));
        calendar1.add(new StringMeeting("12:00", "13:00"));
        calendar1.add(new StringMeeting("16:00", "18:00"));
        StringMeeting bounds1 = new StringMeeting("9:00", "20:00");

        List<StringMeeting> calendar2 = new ArrayList<>();
        calendar2.add(new StringMeeting("10:00", "11:30"));
        calendar2.add(new StringMeeting("12:30", "14:30"));
        calendar2.add(new StringMeeting("14:30", "15:00"));
        calendar2.add(new StringMeeting("16:00", "17:00"));
        StringMeeting bounds2 = new StringMeeting("10:00", "18:30");
        List<StringMeeting> result = CalendarMatching.match(calendar1, bounds1, calendar2, bounds2, 30);
        StringBuilder toPrint = new StringBuilder();
        for (StringMeeting meeting : result) {
            toPrint.append("\n").append(meeting.start).append(" => ").append(meeting.end);
        }

        System.out.println(toPrint);

        System.out.println("\t*** Apartment Hunting ***");
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        blocks.add(craftMap(new Boolean[]{false, true, false}));
        blocks.add(craftMap(new Boolean[]{true, false, false}));
        blocks.add(craftMap(new Boolean[]{true, true, false}));
        blocks.add(craftMap(new Boolean[]{false, true, false}));
        blocks.add(craftMap(new Boolean[]{false, true, true}));
        System.out.println(AppartmentHunting.apartmentHunting(blocks, new String[]{"gym", "school", "store"}));
    }

    private static Map<String, Boolean> craftMap(Boolean[] bools) {
        return new HashMap<>() {
            {
                put("gym", bools[0]);
                put("school", bools[1]);
                put("store", bools[2]);
            }
        };
    }

    private static int[] createArray(int size) {
        int[] output = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            output[i] = rand.nextInt(Integer.MAX_VALUE);
        }
        return output;
    }

    private static Boolean checkArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (i > array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
