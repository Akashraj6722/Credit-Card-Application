package com.chainsys.dao;

import java.util.ArrayList;

import com.chainsys.model.CardDetails;
import com.chainsys.model.PreviewCard;

public class PreviewDetails {
	
	

	public static ArrayList<PreviewCard> display(PreviewCard preview) {
		
		ArrayList<PreviewCard> list=new ArrayList<PreviewCard>();
		preview.getHolderName();
		preview.getCardNumber();
		preview.getCvvNumber();
		preview.getCardAppliedDate();
		preview.getValidity();
		
		
		System.out.println("working...."+preview.getCardNumber());
		list.add(preview);
		return list;
		
		
	}

}
