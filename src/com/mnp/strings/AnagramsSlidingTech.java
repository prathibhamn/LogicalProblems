package com.mnp.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class AnagramsSlidingTech  implements Cloneable{

	public static void findAnagrams(String x , String y ) throws CloneNotSupportedException
	{
	    
	    Queue<Integer> lQuesLst= new LinkedList<>();
	    
	    AnagramsSlidingTech l = new AnagramsSlidingTech();
	    l.clone();
	   Map<Integer,Integer> lMap = new HashMap<>();
	   lMap.put( null, null );
		
		int m =x.length() , n = y.length();
		if(n>m)
		{
			System.out.println("no anaagrams");
			return ;
		}
		Multiset<Character> window = HashMultiset.create();
		Multiset<Character> set = HashMultiset.create();
		for(char c : y.toCharArray())
		{
			set.add(c);
		}
		
		for(int i =0; i< x.length();i++)
		{
			
			if(i<n)
			{
				window.add(x.charAt(i));
			}
			else
			{
				if(window.containsAll(set)) {
					System.out.println("anagram found " +x.substring(i-n, i) + " index "+(i-n));
				}
				
				
					if(window.contains(x.charAt(i-n)))
					{
						window.remove(x.charAt(i-n));
					}
				
				window.add(x.charAt(i));
			}
		}
		
		if(window.containsAll(set)) {
			System.out.println("anagram found  " +x.substring(m-n, m));
		}
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		findAnagrams("XYYZXZYZXXYZ","XYZ");
	}
	
	 public static void findAllAnagrams(String X, String Y)
	    {
	        // m and n stores size of string Y and X respectively
	        int m, n;

	        // invalid input
	        if ((m = Y.length()) > (n = X.length())) {
	            return;
	        }

	        // maintains count of characters in current window
	        Multiset<Character> window = HashMultiset.create();

	        // maintains count of characters in second string
	        Multiset<Character> set = HashMultiset.create();

	        // insert all characters of string Y into set
	        for (int i = 0; i < m; i++) {
	            set.add(Y.charAt(i));
	        }

	        // Note that Guava's HashMultiset can maintain duplicate
	        // elements unlike java.util.HashSet

	        // maintain a sliding window of size m with adjacent characters
	        // of string X
	        for (int i = 0; i < n; i++)
	        {
	            // add first m characters of string X into current window
	            if (i < m) {
	                window.add(X.charAt(i));
	            }
	            else
	            {
	                // If all characters in current window matches that of
	                // string Y, we found an anagram
	                if (window.containsAll(set)) {
	                    System.out.println("Anagram " + X.substring(i - m, i) +
	                                 " present at index " + (i - m));
	                }

	                // consider next substring of X by removing leftmost element of
	                // the sliding window and add next character of string X to it

	                // delete only "one" occurrence of leftmost element of
	                // current window
	                if (window.contains(X.charAt(i - m))) {
	                    window.remove(X.charAt(i - m));
	                }

	                // insert next character of string X in current window
	                window.add(X.charAt(i));
	            }
	        }

	        // if last m characters of string X matches that of string Y,
	        // we found an anagram
	        if (window.containsAll(set)) {
	            System.out.println("Anagram " + X.substring(n - m, n) +
	                                       " present at index " + (n - m));
	        }
	    }

}
