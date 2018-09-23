package com.mnp.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class MagicNumbers {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line = "100 1000";
		Integer a = 0;
		Integer b = 0;

		/*
		 * while ((line = in.readLine()) != null) { // System.out.println(line); }
		 */
		@SuppressWarnings("null")
		String[] splitVal = line.split(" ");
		a = Integer.valueOf(splitVal[0]);
		b = Integer.valueOf(splitVal[1]);
		java.util.Queue<Integer> aMagicStack = new java.util.LinkedList<>();

		for (int i = a; i < b; i++) {
			if (isNotRepeatative(i)) {
				Boolean isMagic = isMagicNumber(i);
				if (isMagic) {
					aMagicStack.add(i);
				}
			}
		}
		while (!aMagicStack.isEmpty())
			System.out.println(aMagicStack.poll());
	}

	private static boolean isNotRepeatative(int a) {
		String str = a + "";
		char[] charArray = str.toCharArray();
		Set<Character> lSet = new HashSet<Character>();
		for (Character charval : charArray) {
			lSet.add(charval);
		}
		if (lSet.size() == charArray.length)
			return true;

		else
			return false;
	}

	private static boolean isMagicNumber(int a) {

		String str = a + "";
		char[] charArray = str.toCharArray();
		Set<Character> lSet = new HashSet<Character>();
		boolean flag = false;
		int pos = charArray[0];
		int i = 0;
		while (true) {
			i = i + pos;
			i = i % charArray.length;
			pos = charArray[i];
			if (i == 0 && lSet.size() == charArray.length - 1) {
				flag = true;
				break;
			} else if (i == 0 && lSet.size() != charArray.length - 1) {
				flag = false;
				break;
			}
			if (!lSet.contains(charArray[i])) {
				lSet.add(charArray[i]);
			} else {
				flag = false;
				break;
			}
		}

		return flag;
	}
}
