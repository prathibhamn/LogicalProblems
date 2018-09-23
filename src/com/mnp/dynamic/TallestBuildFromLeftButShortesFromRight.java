package com.mnp.dynamic;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TallestBuildFromLeftButShortesFromRight {

	public static void main(String[] args) {

		int[] a;
		int[] b;
		String[] aStrArra;
		String[] bStrArra;
		String aStr = new String();
		String bStr = new String();
		int t = 0;
		int contents = 0;
		Scanner sc = new Scanner(System.in);
		contents = sc.nextInt();

		try {
			for (int i = 0; i < contents; i++) {
				//Array a
				t = sc.nextInt();
				a = new int[t];
				if(sc.hasNextLine())
				aStr = sc.nextLine();
				aStrArra = aStr.split(" ");
				for (int ia = 0; ia < aStrArra.length; ia++) {
					a[ia] = Integer.parseInt(aStrArra[ia]);
				}
				//Array  b
				if (sc.hasNextInt())
					t = sc.nextInt();
				b = new int[t];
				if(sc.hasNextLine())
				bStr = sc.nextLine();
				bStrArra = bStr.split(" ");
				for (int ia = 0; ia < bStrArra.length; ia++) {
					a[ia] = Integer.parseInt(bStrArra[ia]);
				}

				missingNumber(a, b);
				aStr = new String();
				bStr = new String();
			}
			sc.close();
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static void missingNumber(int[] a, int[] b) {
		Map<Integer, Integer> lALsit = new TreeMap<>();
		Map<Integer, Integer> lBLsit = new TreeMap<>();
		for (int j = 0; j < a.length; j++) {
			if (lALsit.containsKey(a[j]))
				lALsit.put(a[j], lALsit.get(a[j]) + 1);
			else
				lALsit.put(a[j], 1);
		}
		for (int k = 0; k < b.length; k++) {
			if (lBLsit.containsKey(b[k]))
				lBLsit.put(b[k], lBLsit.get(b[k]) + 1);
			else
				lBLsit.put(b[k], 1);
		}
		Iterator<Map.Entry<Integer, Integer>> lBLstIterator = lBLsit.entrySet().iterator();
		while (lBLstIterator.hasNext()) {
			Map.Entry<Integer, Integer> entry = lBLstIterator.next();
			if (lALsit.containsKey(entry.getKey())) {
				if (lALsit.get(entry.getKey()).equals(entry.getValue()))
					continue;
				else {
					if (!entry.getKey().equals(0))
						System.out.print(entry.getKey() + "   ");

				}
			} else {
				if (!entry.getKey().equals(0))
					System.out.print(entry.getKey() + "   ");
			}
		}
	}

}
