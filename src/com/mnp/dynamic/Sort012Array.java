package com.mnp.dynamic;

public class Sort012Array {

	// driver function
	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, 2,0,0, 1, 1, 1 };
		int n = arr.length;
		segregate0and1(arr, n);
		print(arr, n);

	}

	private static void segregate0and1(int[] arr, int n) {
		int start = 0, mid = 0, end = n - 1;

		while (mid <= end) {
			switch (arr[mid]) {
			case 0: {
				int temp =arr[start];
				arr[start] =arr[mid];
				arr[mid] =temp;
				mid++;
				start++;
				
				break;
			}

			case 1: {
				mid++;
				break;
			}

			case 2: {
				int temp =arr[end];
				arr[end] =arr[mid];
				arr[mid] =temp;
				mid++;
				end--;
				break;
			}
			default:
				System.out.println("");
			}
		}
	}

	private static void print(int[] arr, int n) {
		 int i;
	        for (i = 0; i < arr.length; i++)
	            System.out.print(arr[i]+" ");
	        System.out.println("");

	}

}
