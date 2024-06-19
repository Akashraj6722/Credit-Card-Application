package com.chainsys.dao;

import java.util.Random;

public class NumberGeneration {

    static Random random=new Random();


	public static String accountNumber() {
		
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<4;i++) {
			
			sb.append(random.nextInt(10));
			
		}
		return "212300"+sb.toString();
		
	}
	
	public static String ifsc() {
		
		
		StringBuilder sb= new StringBuilder();
		
		sb.append("MITB000");
		
		for(int i=0;i<1 ;i++) {
			 char randomChar = (char) (65 + random.nextInt(25));
			sb.append(randomChar);
		}
		
		for(int i=0;i<3;i++) {
			sb.append(random.nextInt(10));
		}
		
		
		return sb.toString();
	}
	
	public static int ccvNumber() {
		
		

        
		return 100 + random.nextInt(100);
		
		
		
	}
	
	public static String visaCreditCardNumber() {
		
        
        
		
		StringBuilder sb= new StringBuilder();
		
		for(int i=0;i<15 ;i++) {
			
			sb.append(random.nextInt(10));
			
		}
		
		

		return "4"+sb.toString();
		
		
	}

	public static String masterCreditCardNumber() {
		
        
        
		
		StringBuilder sb= new StringBuilder();
		
		for(int i=0;i<15 ;i++) {
			
			sb.append(random.nextInt(10));
			
		}

		return"5"+sb.toString();
		
	}
public static String rupayCreditCardNumber() {
		
        
        
		
		StringBuilder sb= new StringBuilder();
		
		for(int i=0;i<15 ;i++) {
			
			sb.append(random.nextInt(10));
			
		}

		return "6"+sb.toString();
		
	}

public static String pulseCreditCardNumber() {
	
    
    
	
	StringBuilder sb= new StringBuilder();
	
	for(int i=0;i<15 ;i++) {
		
		sb.append(random.nextInt(10));
		
	}
	

	return "3"+sb.toString();
	
}

private NumberGeneration() {
	super();
}
	
}
