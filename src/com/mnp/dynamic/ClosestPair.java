package com.mnp.dynamic;

public class ClosestPair {

	public static void printClosest(int[] arr, int n, int x) {
		int index1 = 0, index2 = 0;
		int start = 0, end = n - 1;
		int diff = Integer.MAX_VALUE;

		while (end > start) {

			if (arr[end] + arr[start] - x < diff) {
				index1 = end;
				index2 = start;
				diff = Math.abs(arr[end] + arr[start] - x);

			}
			if(arr[end]+arr[start]>x)
			{
			end--;	
			}
			else start++;
		}
		System.out.println(arr[index1]+"            "+arr[index2]);
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int arr[] = { 10, 22, 28, 29, 30, 40 }, x = 32;
		int n = arr.length;
		printClosest(arr, n, x);
	}
}
