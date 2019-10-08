package ru.ifmo.cs.software_testing.lab1.heap_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HeapSort {

    public ArrayList<Double> sort(ArrayList<Double> arr) {
        ArrayList<Double> sortedArr = new ArrayList<>(arr);
        int n = arr.size();

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(sortedArr, n, i);

        for (int i = n-1; i >= 0; i--) {
            Collections.swap(sortedArr, 0, i);

            heapify(sortedArr, i, 0);
        }
        return sortedArr;
    }

    void heapify(ArrayList<Double> arr, int n, int rootIndex) {
        int largest = rootIndex;
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        if (left < n && arr.get(left) > arr.get(largest))
            largest = left;

        if (right < n && arr.get(right) > arr.get(largest))
            largest = right;

        if (largest != rootIndex) {
            Collections.swap(arr, largest, rootIndex);

            heapify(arr, n, largest);
        }
    }

    public static void main(String args[])
    {
        ArrayList<Double> arr = new ArrayList<>(Arrays.asList(8.0, 1.0, 5.0, 7.38, 2.56, 4.3));

        HeapSort ob = new HeapSort();
        ArrayList<Double> sortedArr = ob.sort(arr);

        System.out.print("Sorted array: ");

        for (Double num : sortedArr) {
            System.out.print(num + " ");
        }
    }
}