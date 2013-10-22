package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.Knapsack;
import model.KnapsackItem;

public class BranchAndBound {
	private Knapsack problemInstance;
	private int capacity;
	private int bestPrice;
	private List<KnapsackItem> bestConfig;
	
	public BranchAndBound(Knapsack intance){
		this.problemInstance = intance;
		capacity = problemInstance.getCapacity();
	}
	
	public void exectue(){
		List<KnapsackItem> items = new ArrayList<KnapsackItem>(problemInstance.getItems());
		for (int i = 0; i < items.size(); i++){
			List<KnapsackItem> newItems = new ArrayList<KnapsackItem>(items);
			KnapsackItem newItem = newItems.remove(i);
			solve(newItem, newItems, new ArrayList<KnapsackItem>());
		}
	}
	
	private void solve(KnapsackItem item, List<KnapsackItem> items, List<KnapsackItem> results){
		if(getItemsPrice(items) + getItemsPrice(results) <= bestPrice){
			return;
		}
		if(getItemsWeight(results) + item.getWeight() > capacity){
			return;
		}
		results.add(item);
		int price = getItemsPrice(results);
		if(price > bestPrice){
			bestPrice = price;
			bestConfig = results;
		}
		for (int i = 1; i < items.size(); i++){
			List<KnapsackItem> newItems = new ArrayList<KnapsackItem>(items);
			KnapsackItem newItem = newItems.remove(i);
			solve(newItem, newItems, new ArrayList<KnapsackItem>(results));
		}
		
	}
	
	private int getItemsPrice(List<KnapsackItem> items){
		int price = 0;
		for (KnapsackItem item : items){
			price += item.getPrice();
		}
		return price;
	}
	
	private int getItemsWeight(List<KnapsackItem> items){
		int weight = 0;
		for (KnapsackItem item : items){
			weight += item.getWeight();
		}
		return weight;
	}
	
	
}
