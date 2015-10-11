package com.sainsbury.grocery.item;

public class GroceryItem {

	private String title;
	private String size;
	private String unitPrice;
	private String description;
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(title).append("\r\n")
			.append(size).append("\r\n")
			.append(unitPrice).append("\r\n")
			.append(description).append("\r\n");
		
		return sb.toString();
	}
		
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the unitPrice
	 */
	public String getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
