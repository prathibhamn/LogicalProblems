package com.mnp.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Java8Lambda {

	public static void main(String[] args) throws IOException {/*
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.isOdd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = ob.isPrime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ob.isPalindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}
	*/}
	
	/* public PerformOperation checkEvenOdd() {
	       return (n) -> {           
	           return (n % 2 == 0) ? 0 : 1;
	       };
	   }

	    public PerformOperation checkPrime() {
	        return (n) -> {
	            return java.math.BigInteger.valueOf(n).isProbablePrime(15) ? 0 : 1;
	        };
	    }

	    public PerformOperation checkPalindrome() {
	        return (n) -> {
	            String str = String.valueOf(n);
	            
	            for (int i = 0; i < str.length() / 2; i++) {
	                if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
	                    return 1;
	                }
	            }
	            
	            return 0;
	        };
	    }
	}*/

}



interface PerformOperation {
	boolean check(int a);
}

class MyMath {
	public static boolean checker(PerformOperation p, int num) {
	  return p.check(num);
	 }

	
}