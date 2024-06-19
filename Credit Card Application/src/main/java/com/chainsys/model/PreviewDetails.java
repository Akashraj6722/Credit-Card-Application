package com.chainsys.model;



	import java.util.ArrayList;
import java.util.List;



	public class PreviewDetails {
		
		

		public static List<CreditCardDetails> display(CreditCardDetails card) {
			
			ArrayList<CreditCardDetails> list=new ArrayList<CreditCardDetails>();
			card.getHolderName();
			card.getCardNumber();
			card.getCvvNumber();
			card.getCardAppliedDate();
			card.getValidity();
			
			
			list.add(card);
			return list;
			
			
			
		}

		private PreviewDetails() {
			super();
		}

	}


