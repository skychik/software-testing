package ru.ifmo.cs.software_testing.lab1.heap_sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

	@Test
	void sort() {
		List<Double> arr = Arrays.asList(8.0, 1.0, 5.0, 7.38, 2.56, 4.3, -1232.0, 0.0, -213.132123, 213123123.0);
		List<Double> sortedArr = new ArrayList<>(arr);
		Collections.sort(sortedArr);
		HeapSort.sort(arr);
		assertEquals(arr, sortedArr);
	}

	@Test
	void heapify() {

	}

	@Test
	void main() {
	}
}