package com.mnp.dynamic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MissingNumberInArrays {

	public static void main(String[] args) {

		int[] a;
		int[] b;
		String[] aStrArra = null;
		String[] bStrArra = null;
		int t = 0;
		int contents = 0;
		boolean isZeroExists = false;
		Scanner sc = new Scanner(System.in);
		try {
			contents = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < contents; i++) {
				// Array a
				t = Integer.parseInt(sc.nextLine());
				a = new int[t];
				if (sc.hasNextLine())
				aStrArra = sc.nextLine().split(" ");
				for (int ia = 0; ia < aStrArra.length; ia++) {
					a[ia] = Integer.parseInt(aStrArra[ia]);
				}
				// Array b
				if (sc.hasNextLine())
					t = Integer.parseInt(sc.nextLine());
				b = new int[t];
				if (sc.hasNextLine())
				bStrArra = sc.nextLine().split(" ");
				for (int ia = 0; ia < bStrArra.length; ia++) {
					b[ia] = Integer.parseInt(bStrArra[ia]);
					if (b[ia] == 0) {
						isZeroExists = true;
					}
				}
				missingNumber(a, b, isZeroExists);
				System.out.println(" ");
				aStrArra = null;
				bStrArra = null;
			}
			sc.close();
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static void missingNumber(int[] a, int[] b, boolean isZeroExists) {
		Map<Integer, Integer> lALsit = new TreeMap<>();
		Map<Integer, Integer> lBLsit = new TreeMap<>();

		Arrays.sort(a);
		Arrays.sort(b);

		for (int j = 0; j < a.length; j++) {
			if (!lALsit.containsKey(a[j]))
				lALsit.put(a[j], 1);
			else {
				lALsit.put(a[j], (lALsit.get(a[j]) + 1));
			}
		}
		for (int j = 0; j < b.length; j++) {
			if (!lBLsit.containsKey(b[j]))
				lBLsit.put(b[j], 1);
			else {
				lBLsit.put(b[j], (lBLsit.get(b[j]) + 1));
			}
		}
		a =null;
		b=null;
		Iterator<Integer> lblsitKeyIter = lBLsit.keySet().iterator();
		while (lblsitKeyIter.hasNext()) {
			Integer key = lblsitKeyIter.next();
			if (null == lALsit.get(key)) {
				if ((key == 0) && !isZeroExists) {
					continue;
				} else {
					System.out.print(key + " ");
				}
			} else if (!((lALsit.get(key)).equals(lBLsit.get(key)))) {
				if ((key == 0) && !isZeroExists) {
					continue;
				} else {
					System.out.print(key + " ");
				}
			}

		}

	}

}
