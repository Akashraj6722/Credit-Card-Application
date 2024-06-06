package com.chainsys.dao;

import java.util.Random;

public class NumberGeneration {

	public static void main(String[] args) {

//		
		System.out.println("ACC.No: "+accountNumber());
		System.out.println("IFSC code: "+ifsc());
		
		  System.out.println(visaCreditCardNumber());
		  System.out.println(masterCreditCardNumber());




	}

	public static String accountNumber() {
		
		Random random =new Random();
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<4;i++) {
			
			sb.append(random.nextInt(10));
			
		}
		String accountNumber="212300"+sb.toString();
		return accountNumber;
		
	}
	
	public static String ifsc() {
		
		Random random=new Random();
		
		StringBuilder sb= new StringBuilder();
		
		sb.append("MITB000");
		
		for(int i=0;i<1 ;i++) {
			 char randomChar = (char) (65 + random.nextInt(25));
			sb.append(randomChar);
		}
		
		for(int i=0;i<3;i++) {
			sb.append(random.nextInt(10));
		}
		
		String ifsc=sb.toString();
		return ifsc;
	}
	
	public static String visaCreditCardNumber() {
		
        Random random=new Random();
        
        
		
		StringBuilder sb= new StringBuilder();
		
		for(int i=0;i<=15 ;i++) {
			
			sb.append(random.nextInt(10));
			
		}
		String cardNumber="4"+sb.toString();
		
//		String [] cardArray=cardNumber.split("(?<=\\G.{4})");
//		
//		for(int i =0;i<4;i++) {
//			
//			System.out.println(cardArray[i]);
//			
//		}
		return cardNumber;
		
		
	}

	public static String masterCreditCardNumber() {
		
        Random random=new Random();
        
        
		
		StringBuilder sb= new StringBuilder();
		
		for(int i=0;i<=15 ;i++) {
			
			sb.append(random.nextInt(10));
			
		}
		String cardNumber="5"+sb.toString();
		
//		String [] cardArray=cardNumber.split("(?<=\\G.{4})");
//		
//		for(int i =0;i<4;i++) {
//			
//			System.out.println(cardArray[i]);
//			
//		}
		return cardNumber;
		
	}
	
}
