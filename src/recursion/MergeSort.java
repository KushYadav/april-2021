package recursion;

import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int[] mergeSorted = mergeSort(arr, 0, arr.length - 1);
		display(mergeSorted);
	}

	public static int[] mergeSort(int arr[], int li, int hi) {
		if (li == hi) {
			return new int[] { arr[li] };
		}
		int mi = (li + hi) / 2;
		int[] l = mergeSort(arr, li, mi);
		int[] r = mergeSort(arr, mi + 1, hi);
		return mergeSortedArrays(l, r);
	}

	public static int[] mergeSortedArrays(int[] l, int[] r) {
		int[] merged = new int[l.length + r.length];
		int i = 0;
		int li = 0;
		int ri = 0;

		while (li < l.length && ri < r.length) {
			if (l[li] < r[ri]) {
				merged[i] = l[li];
				li++;
			} else {
				merged[i] = r[ri];
				ri++;
			}
			i++;
		}
		while (li < l.length) {
			merged[i] = l[li];
			li++;
			i++;
		}
		while (ri < r.length) {
			merged[i] = r[ri];
			ri++;
			i++;
		}
		return merged;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}
}
