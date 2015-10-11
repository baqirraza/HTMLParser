package com.sainsbury.grocery.json;

import java.util.List;

import com.sainsbury.grocery.item.GroceryItem;
import com.sainsbury.grocery.util.CommonUtils;

public class GroceryJSONMarsheller {

	
	List<GroceryItem> items;
	
	public GroceryJSONMarsheller(List<GroceryItem> items) {
		this.items = items;
	}
	
	public void marshalJson(){
		
		/*
		{
			"results":[
						{
							"title":"Sainsbury's Avocado, Ripe & Ready x2",
							"size": "90.6kb",
							"unit_price": 1.80,
							"description": "Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5..."
						},
						
						{
							"title":"Sainsbury's Avocado, Ripe & Ready x4",
							"size": "87kb",
							"unit_price": 2.00,
							"description": "Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5..."
						}
					],
			"total": 3.80
		}
		 */
		
		if(items == null)
			return;
		
		if(items.size()<=0)
			return;
		
		
		System.out.println("{");
		
		System.out.println("\"results\":[");
		
		StringBuilder jb = new StringBuilder();
		
		double total = 0.0;
		
		for (GroceryItem item : items) {
			
			jb.append("{");
			jb.append("\"title\":\"").append(item.getTitle()).append("\",");
			jb.append("\"size\":\"").append(item.getSize()).append("\",");
			jb.append("\"unit_price\":\"").append(item.getUnitPrice()).append("\",");
			jb.append("\"description\":\"").append(item.getDescription()).append("\"");
			jb.append("},");
			
			total += CommonUtils.parsePrice(item.getUnitPrice());
			
			
			
			
		}
		jb.deleteCharAt(jb.lastIndexOf(","));
		
		System.out.println(jb.toString());
		
		System.out.println("],");
		
		System.out.print("\"total\":");
		System.out.println(total);
		
		System.out.println("}");
		
	}

}
