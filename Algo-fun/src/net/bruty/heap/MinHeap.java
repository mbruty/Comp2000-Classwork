package net.bruty.heap;

import java.util.List;

public class MinHeap {
    List<Integer> heap;

    public MinHeap(List<Integer> array) {
        heap = array;
        buildHeap();

    }

    public void buildHeap() {
        int firstParentIdx = (heap.size() - 2) / 2;
        for (int i = firstParentIdx; i >= 0; i--) {
            siftDown(i, heap.size() - 1);
        }
    }

    private void siftUp(int currentIdx) {
        int parentIdx = (currentIdx - 1) / 2;
        while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }

    private void siftDown(int currentIdx, int endIdx) {
        int childOneIdx = currentIdx * 2 + 1;
        while (childOneIdx <= endIdx) {
            int idxToSwap;
            int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
            if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                idxToSwap = childTwoIdx;
            } else {
                idxToSwap = childOneIdx;
            }
            if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                swap(currentIdx, idxToSwap);
                currentIdx = idxToSwap;
                childOneIdx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    public void insert(int value) {
        this.heap.add(value);
        siftUp(heap.size() - 1);
    }

    public int remove() {
        swap(0, heap.size() - 1);
        int toRemove = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1);
        return toRemove;
    }

    public int peek() {
        return heap.get(0);
    }

    private void swap(int i, int j) {
        int temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }
}
