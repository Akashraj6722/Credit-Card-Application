package com.chainsys.util;

public class CardEligibility {
	
	
	public static void check(long income) {
		
		if(income>200000 && income<400000) {
			System.out.println("You are eligible for Silver Card");
		
		}else if(income>200000  && income<300000){
			System.out.println("You are eligible for Gold Card");

			
		}else if(income>400000  && income<600000){
		
			System.out.println("You are eligible for Platinum Card");

		
	}else if(income>600000  ){
		System.out.println("You are eligible for Elite Card");

	}else {
		
		System.out.println("Sorry! You're Income does'nt meet our minimum requirements");
		
	}
	
}
}
