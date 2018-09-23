package com.mnp.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class TallesInClass {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String classStudent = null;
		Integer classStudentArr[] = null;
		String[] aStrArra;
		int testCases = 0;
		int stndStrngth = 0;
		testCases = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testCases; i++) {
			stndStrngth = Integer.parseInt(sc.nextLine());
			if (sc.hasNextLine())
				classStudent = sc.nextLine();
			aStrArra = classStudent.split(" ");
			classStudentArr = new Integer[stndStrngth];
			if (aStrArra.length != stndStrngth) {
				System.out.println(" No of students doesnt match with strength");
				return;
			}
			for (int ia = 0; ia < aStrArra.length; ia++) {
				classStudentArr[ia] = Integer.parseInt(aStrArra[ia]);
			}

			findTallest(classStudentArr);
		}
	}

	private static void findTallest(Integer[] classStudent) {
		int tallStud = classStudent[0];
		Integer tallStudIndex[] = new Integer[classStudent.length-1];
		int indx = 0;
		tallStudIndex[0] = 0;
		for (int j = 1; j < classStudent.length-1; j++) {
			if ((tallStud > classStudent[j])) {
				tallStudIndex[indx] = tallStudIndex[indx] + 1;
			} else {
				tallStud = classStudent[j];
				// up to
				tallStudIndex[indx] = tallStudIndex[indx] + 1;
				indx = j;
				tallStudIndex[indx] = 0;
			}

		}
		tallStud = 0;
		indx = 0;
		for (int j = 0; j < tallStudIndex.length; j++) {
			if (tallStudIndex[j]!=null&&tallStudIndex[j] >= tallStud) {
				tallStud = tallStudIndex[j];
				indx = j + 1;
			}
		}
		System.out.println(indx);
	}
}
