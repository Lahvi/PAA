package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t945122
 *
 */
public class Knapsack {
	
	private List<KnapsackItem> items;
	private int id;
	private int instanceSize;
	private int capacity;
	
	public Knapsack(int id, int size, int capacity, List<KnapsackItem> items){
		this.id = id;
		this.instanceSize = size;
		this.capacity = capacity;
		this.items = items;
	}
	
	public Knapsack(){
		this.items = new ArrayList<KnapsackItem>();
	}

	public List<KnapsackItem> getItems() {
		return items;
	}

	public void setItems(List<KnapsackItem> items) {
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInstanceSize() {
		return instanceSize;
	}

	public void setInstanceSize(int instanceSize) {
		this.instanceSize = instanceSize;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public KnapsackItem[] getItemsArray(){
		KnapsackItem[] itemsArray = new KnapsackItem[instanceSize];
		return items.toArray(itemsArray);
	}
}
