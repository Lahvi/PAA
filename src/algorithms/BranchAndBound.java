package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.Knapsack;
import model.KnapsackConfiguration;
import model.KnapsackItem;

public class BranchAndBound {
	private Knapsack problemInstance;
	private int capacity;
	private KnapsackConfiguration bestConfig;
	
	public BranchAndBound(Knapsack intance){
		this.problemInstance = intance;
		capacity = problemInstance.getCapacity();
	}
	
	public void exectue(){
		KnapsackConfiguration startConfig = new KnapsackConfiguration(capacity, problemInstance.getItems());
                while(startConfig.hasAvailableItems()){
                    solve(startConfig.getNextAvailableItem(), startConfig.);
                }
	}
	
	private void solve(KnapsackItem item, KnapsackConfiguration config){
		if(getItemsPrice(items) + getItemsPrice(config) <= bestPrice){
			return;
		}
		if(getItemsWeight(config) + item.getWeight() > capacity){
			return;
		}
		config.add(item);
		int price = getItemsPrice(config);
		if(price > bestPrice){
			bestPrice = price;
			bestConfig = config;
		}
		for (int i = 1; i < items.size(); i++){
			List<KnapsackItem> newItems = new ArrayList<KnapsackItem>(items);
			KnapsackItem newItem = newItems.remove(i);
			solve(newItem, newItems, new ArrayList<KnapsackItem>(config));
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
	
	public void getBestConfiguration(){
		
	}
	
	
}
