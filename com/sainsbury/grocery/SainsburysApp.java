package com.sainsbury.grocery;

import java.util.List;

import com.sainsbury.grocery.html.GroceryHTMLParser;
import com.sainsbury.grocery.item.GroceryItem;
import com.sainsbury.grocery.json.GroceryJSONMarsheller;
import com.sainsbury.grocery.util.CommonUtils;

/**
 *
 */
public class SainsburysApp {
	
    public static void main( String[] args ){
    	
    	GroceryHTMLParser parser = new GroceryHTMLParser(CommonUtils.MAIN_URL);
    	List<GroceryItem> items = parser.loadGroceryItemsHTML();
    	
    	GroceryJSONMarsheller marshaller = new GroceryJSONMarsheller(items);
    	marshaller.marshalJson();
    	
    }
}
