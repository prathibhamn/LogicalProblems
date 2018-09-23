package com.mnp.dynamic;

import java.util.Arrays;

public class ATMWithDraw {

	public static void main(String[] args) {
	    
	    Integer.TYPE.getName();
		int money[]={1000,500,100,50,20,10,5,2,1};  //money to disbursed
		   int withdraw_amt=70;                         //For store withdrawl amount
		   int i=0,r; 
		  // clrscr();
		   System.out.println(" Enter An Amount to Withdrawal : ");
		// sys
		   while(withdraw_amt >0)
		   {
		        r=withdraw_amt/money[i]; // Withdrawl amount devided by each money sets on above
		        withdraw_amt= withdraw_amt%money[i]; //a reminder will set again withdrawal amount.
		        if(r>0)
		       System.out.println(" Please Collect  "+ r+" notes of "+money[i] +" ");
		        i++;
		   }
		   System.out.println(" THANKS FOR USING OUR ATM SERVICE ");
		  // Arrays.sort
		  // Arrays.binarySearch(money, 2, 1);
		 //  getch();
	}
}
