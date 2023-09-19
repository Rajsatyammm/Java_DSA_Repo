package Heaps;

import java.util.*;

public class Index {
    static class Heap {
        ArrayList<Integer> list = new ArrayList<>();

        public void add(int data) {
            list.add(data);

            int childIdx = list.size() - 1;
            int parIdx = (childIdx - 1) / 2;

            while(list.get(childIdx) < list.get(parIdx)) {
                int temp = list.get(childIdx);
                list.set(childIdx, list.get(parIdx));
                list.set(parIdx, temp);

                childIdx = parIdx;
                parIdx = (childIdx - 1) / 2;

            }
        }

        public void heapify(int idx) {
//            if(idx > list.size()) return;
            int leftChild = idx * 2 + 1;
            int rightChild = idx * 2 + 2;
            int minIdx = idx;

            if(leftChild < list.size() && list.get(leftChild) < list.get(minIdx)) {
                minIdx = leftChild;
            }

            if(rightChild < list.size() && list.get(rightChild) < list.get(minIdx)) {
                minIdx = rightChild;
            }

            if(minIdx != idx) {
                // swap minIdx with idx
                int temp = list.get(idx);
                list.set(idx, list.get(minIdx));
                list.set(minIdx, temp);

                heapify(minIdx);
            }

        }
        public int delete() {
            int val = list.get(0);

            //swap with last idx
            list.set(0, list.get(list.size() - 1));
            list.set(list.size() - 1, val);
            list.remove(list.size() - 1);

            heapify(0);
            return val;
        }

        public void heapify2(int[] arr, int n) {

        }
        public void heapSort(int[] arr) {
            int n = arr.length;

            //build max Heap
            for(int i=n/2; i>=0; i--) {
                heapify2(arr, n);
            }

            for(int i=n-1; i>0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
            }

        }

    }
    public static void main(String[] args) {
        Heap h = new Heap();
//        h.add(4);
//        h.add(10);
//        h.add(1);
//        h.add(8);
//        h.add(3);
//
        int[] arr = {2, 6, 1, 3, 9, 4, 5};

//        h.heapSort(arr, arr.length-1);
        for(int i : arr)
        {
            System.out.print(i + " ");
        }
//        System.out.println(h.list);
    }
}
