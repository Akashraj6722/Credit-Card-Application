package com.chainsys.model;



	import java.util.ArrayList;



	public class PreviewDetails {
		
		

		public static ArrayList<CreditCardDetails> display(CreditCardDetails card) {
			
			ArrayList<CreditCardDetails> list=new ArrayList<CreditCardDetails>();
			card.getHolderName();
			card.getCardNumber();
			card.getCvvNumber();
			card.getCardAppliedDate();
			card.getValidity();
			
			
			System.out.println("working...."+card.getCardNumber());
			list.add(card);
			return list;
			
			
		}

	}


