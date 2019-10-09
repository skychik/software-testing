package ru.ifmo.cs.software_testing.lab1.heap_sort;

import java.util.*;

public class HeapSort {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Write amount of numbers:");
		int n = scanner.nextInt();
		System.out.println("Type your numbers:");
		ArrayList<Double> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(scanner.nextDouble());
		}

		System.out.println("Unsorted array: " + arr.toString());

		HeapSort.sort(arr);
		System.out.print("Sorted array: " + arr.toString());
	}

    public static void sort(List<Double> arr) {
        int n = arr.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
	        heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            Collections.swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    public static void heapify(List<Double> arr, int heapSize, int rootIndex) {
        int largestIndex = rootIndex;
        int leftIndex = 2 * rootIndex + 1;
        int rightIndex = 2 * rootIndex + 2;

        if (leftIndex < heapSize && arr.get(leftIndex) > arr.get(largestIndex)) {
	        largestIndex = leftIndex;
        }
        if (rightIndex < heapSize && arr.get(rightIndex) > arr.get(largestIndex)) {
	        largestIndex = rightIndex;
        }
        if (largestIndex != rootIndex) {
            Collections.swap(arr, largestIndex, rootIndex);
            heapify(arr, heapSize, largestIndex);
        }
    }
}
