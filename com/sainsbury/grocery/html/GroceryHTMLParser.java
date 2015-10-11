package com.sainsbury.grocery.html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sainsbury.grocery.item.GroceryItem;

public class GroceryHTMLParser {
	
	String URL;
	
	public GroceryHTMLParser(String url) {
		this.URL = url;
	}
	
	public List<GroceryItem> loadGroceryItemsHTML(){
		
		List<GroceryItem> groceryItems = null;
		
		try {
			Document doc = Jsoup.connect(URL).get();
			
			Map<String, String> items = loadMainItems(doc);
			
			groceryItems = loadSubItems(items);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return groceryItems;
		
	}
	
	private List<GroceryItem> loadSubItems(Map<String, String> items) {
		
		GroceryItem rtrnItem;
		List<GroceryItem> rtrnList = new ArrayList<GroceryItem>();
		
		for (Entry<String, String> entry : items.entrySet()) {
			
			rtrnItem = loadLinDetails(entry);
		    rtrnList.add(rtrnItem);
		    
		}
		
		return rtrnList;
	}

	private GroceryItem loadLinDetails(Entry<String, String> entry) {
		
		GroceryItem rtrnItem = new GroceryItem();
	    String title = entry.getKey();
	    String link = entry.getValue();
	    
	    try{
	    	
	    	Document doc = Jsoup.connect(link).get();
	    	int bytes = doc.data().getBytes().length;
	    	
	    	/*
			Element titleContainer = doc.getElementsByClass("productTitleDescriptionContainer").get(0);
			Element node = titleContainer.child(0);
			String title = node.text();
			*/
			
			Element price = doc.getElementsByClass("pricePerUnit").get(0);
			String unitPriceTxt = price.text();
			
			Element descriptionContainer = doc.getElementsByClass("productDataItemHeader").get(0);
			Element nodeDesc = descriptionContainer.nextElementSibling();
			String description = nodeDesc.text();
			
	    	rtrnItem.setSize(""+bytes);
	    	rtrnItem.setTitle(title);
	    	rtrnItem.setUnitPrice(unitPriceTxt);
	    	rtrnItem.setDescription(description);
	    	
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    
		return rtrnItem;
	}

	private Map<String, String> loadMainItems(Document doc) throws Exception{
		
		Map<String, String> items = new HashMap<String, String>();
		
		Elements elements = doc.getElementsByClass("productInfo");
		
		for (Element element : elements) {
			
			Element item = element.getElementsByTag("h3").get(0);
			Elements links = item.getElementsByTag("a");
			
			for (Element link : links) {
				  String linkHref = link.attr("href");
				  String linkText = link.text();
				  
				  items.put(linkText, linkHref);
			}
		}
		return items;
	}
	
}
