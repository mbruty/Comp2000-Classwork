package net.bruty.algofun.BST;



import java.util.ArrayList;
import java.util.List;


public class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value){
        this.value = value;
    }

    public Boolean equals(BST tree){
        List<Integer> first = this.toSortedArray();
        List<Integer> second = tree.toSortedArray();

        if(first.size() != second.size()) return false;
        if (first.size() == 0 && second.size() == 0) return true;

        for(int i = 0; i < first.size(); i++){
            if(!first.get(i).equals(second.get(i))) return false;
        }
        return true;
    }

    public void toMinHeight(){
        final List<Integer> sortedValues = this.toSortedArray();
        BST result = createMinHeight(sortedValues, null, 0, sortedValues.size() - 1);
        assert result != null;
        this.value = result.value;
        this.left = result.left;
        this.right = result.right;
    }

    private static BST createMinHeight(List<Integer> array, BST bst, int start, int end){
        if (end < start) return null;
        int mid = (start + end ) / 2;
        int toAdd = array.get(mid);
        if(bst == null) {
            bst = new BST(toAdd);
        }
        else{
            bst.insert(toAdd);
        }
        createMinHeight(array, bst, start, mid - 1);
        createMinHeight(array, bst, mid + 1, end);
        return bst;
    }

    public void insert (int value){
        if(value < this.value){
            if(left == null){
                left = new BST(value);
            }
            else{
                left.insert(value);
            }
        }
        else {
            if(right == null){
                right = new BST(value);
            }
            else{
                right.insert(value);
            }
        }
    }

    public boolean contains(int value){
        if (value < this.value) {
            if (left == null) return false;
            else return left.contains(value);
        }
        else if (value > this.value){
            if(right == null) return false;
            else return right.contains(value);
        }
        else return true;
    }

    public void remove(int value, BST parent){
        if (value < this.value){
            if (left != null) left.remove(value, this);
        }
        else if (value > this.value) {
            if (right != null) right.remove(value, this);
        }
        else {
            if( left != null && right != null){
                this.value = right.getMinValue();
                right.remove(this.value, this);
            }
            else if (parent == null){
                if(left != null) {
                    this.value = left.value;
                    right = left.right;
                    left = left.left;
                }
                else if (right != null) {
                    this.value = right.value;
                    left = right.left;
                    right = right.right;
                }
            }
            else if (parent.left == this) {
                parent.left = left != null ? left : right;
            }
            else if (parent.right == this){
                parent.right = left != null ? left : right;
            }
        }
    }

    public int getMinValue(){
        if (left == null) {
            return this.value;
        }
        else {
            return left.getMinValue();
        }
    }

    public static int findClosestValue( BST tree, int target){
        return findClosestValue(tree, target, 0);
    }
    public static int findClosestValue(BST tree, int target, int closest){
        // Comparing the absolute difference between target and closest
        if (Math.abs(target - closest) > Math.abs(target - tree.value)){
            closest = tree.value;
        }

        if (target < tree.value && tree.left != null) return findClosestValue(tree.left, target, closest);
        else if (target > tree.value && tree.right != null) return findClosestValue(tree.right , target, closest);
        else return closest;
    }

    public static boolean validate(BST tree){
        return validate(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validate(BST tree, int min, int max){
        if (tree.value < min || tree.value >= max){
            return false;
        }
        if(tree.left != null && !validate(tree.left, min, tree.value)){
            return false;
        }
        return tree.right == null || validate(tree.right, tree.value, max);
    }

    public List<Integer> toSortedArray(){
        return this.inOrderTraversal();
    }
    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(this, result);
        return result;
    }

    private static List<Integer> inOrderTraversal(BST tree, List<Integer> array){
        if(tree != null){
            inOrderTraversal(tree.left, array);
            array.add(tree.value);
            inOrderTraversal(tree.right, array);
        }
        return array;
    }

    public List<Integer> preOrderTraversal(){
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(this, result);
        return result;
    }

    private static List<Integer> preOrderTraversal(BST tree, List<Integer> array){
        if(tree != null){
            array.add(tree.value);
            preOrderTraversal(tree.left, array);
            preOrderTraversal(tree.right, array);
        }
        return array;
    }

    public List<Integer> postOrderTraversal(){
        List<Integer> array = new ArrayList<>();
        return postOrderTraversal(this, array);
    }

    private static List<Integer> postOrderTraversal(BST tree, List<Integer> array){
        if(tree != null){
            postOrderTraversal(tree.left, array);
            postOrderTraversal(tree.right, array);
            array.add(tree.value);
        }
        return array;
    }
    public void printTree(){
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(this, result);
        for(int i : result){
            System.out.println(i);
        }
    }

}
