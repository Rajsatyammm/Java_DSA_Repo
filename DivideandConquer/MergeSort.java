 package DivideandConquer;

public class MergeSort {
    public static void printArr(int arr[]) {
        // for(int i : arr) {
        //     System.out.print(arr[i] + " ");
        // }
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // kaam
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp array

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    public static void main(String[] args) {
        int arr[] = { 4, 6, 2, 1, 8, 3 };
        System.out.print("Before Sorting : ");
        printArr(arr);
        System.out.println();
        mergeSort(arr, 0, arr.length - 1);
        System.out.print("After Sorting : ");
        printArr(arr);

    }
}
