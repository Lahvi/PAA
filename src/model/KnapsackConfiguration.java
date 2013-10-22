package model;

import java.util.ArrayList;
import java.util.List;

public class KnapsackConfiguration {
	private int currentWeight;
	private int currentPrice;
	
	private int capacity;
	private List<KnapsackItem> items;
	private List<KnapsackItem> availableItems;
	
	public KnapsackConfiguration(int capacity, List<KnapsackItem> availableItems){
		this.capacity = capacity;
		this.items = new ArrayList<KnapsackItem>();
		this.availableItems = new ArrayList<KnapsackItem>(availableItems);
		currentPrice = 0;
		currentWeight = 0;
	}
	
	private KnapsackConfiguration(KnapsackConfiguration origin){
		this.capacity = origin.capacity;
		this.currentPrice = origin.currentPrice;
		this.currentWeight = origin.currentWeight;
		
		this.items = new ArrayList<KnapsackItem>(origin.items);
		this.availableItems = new ArrayList<KnapsackItem>(origin.availableItems);
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
	
	public KnapsackConfiguration getClone(){
		
	}
}
