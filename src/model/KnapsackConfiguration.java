package model;

import java.util.ArrayList;
import java.util.List;

public class KnapsackConfiguration {
	private int currentWeight;
	private int currentPrice;
	
	private int capacity;
	private List<KnapsackItem> items;
	
	public KnapsackConfiguration(int capacity){
		this.capacity = capacity;
		this.items = new ArrayList<KnapsackItem>();
		currentPrice = 0;
		currentWeight = 0;
	}
	
	public boolean isPosibleAddItem(KnapsackItem item){
		if((currentWeight + item.getWeight()) > capacity){
			return false;
		}
		return true;
	}
	
	public void addItem(KnapsackItem item){
		items.add(item);
		currentPrice += item.getPrice();
		currentWeight += item.getWeight();
	}

	public int getCurrentWeight() {
		return currentWeight;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public int getCapacity() {
		return capacity;
	}

	public List<KnapsackItem> getItems() {
		return items;
	}
}
