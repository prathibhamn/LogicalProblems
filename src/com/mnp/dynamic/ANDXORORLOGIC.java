package com.mnp.dynamic;

public class ANDXORORLOGIC {
	static int andXorOr(int[] a) {

		int result = Integer.MIN_VALUE;
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		for (int number : a) {
			while (!stack.empty()) {
				result = Math.max(result, andXorOrUtility(number, stack.peek()));

				if (number < stack.peek()) {
					stack.pop();
				} else {
					break;
				}
			}

			stack.push(number);
		}
		return result;

	}

	static int andXorOrUtility(int x, int y) {
		return ((x & y) ^ (x | y)) & (x ^ y);
	}

	public static void main(String[] args) {
		int a[] = new int[] { 9, 6, 3, 5, 2 };
		System.out.println(andXorOr(a));;
	}
}
