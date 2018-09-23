package com.mnp.dynamic;

public class PoisonousPlantsStack {
	static int poisonousPlants(int[] p) {
		int maxDay = 0;
		int loopCounter = p.length;
		int previousLoopCounter = p.length;
		boolean flag = false;
		java.util.Stack<Integer> lMax = new java.util.Stack<>();
		int i = 0;
		while (true) {
			if (i > (loopCounter - 1)) {
				previousLoopCounter = p.length;
				loopCounter = lMax.size();
				if (previousLoopCounter == loopCounter)
					return maxDay;
				flag = false;
				p = new int[lMax.size()];
				for (int j = lMax.size() - 1; j >= 0; j--) {
					p[j] = lMax.pop();
				}
				lMax = new java.util.Stack<>();
				i = 0;
			}
			if (lMax.isEmpty()) {
				lMax.push(p[i]);
				i++;
			} else {
				if (p[i] >p[i-1]) {
					if (!flag) {
						maxDay++;
						flag = true;
					}
				} else {
					lMax.push(p[i]);
				}
				i++;
			}
		}

	}

	public static void main(String[] args) {
		int[] p = new int[] { 6, 5, 8, 4, 7, 10, 9 };
		System.out.println(poisonousPlants(p));
	}
}
