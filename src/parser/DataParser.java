package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

import model.Knapsack;
import model.KnapsackItem;

public class DataParser {
	
	private File dataFile;
	private Stack<String> fileLines;
	
	public DataParser(String filePath){
		dataFile = new File(filePath);
		if(!dataFile.exists()){
			throw new IllegalArgumentException("File path " + filePath + " does not exists.");
		}
		System.out.println("Succesfully loaded file: " + filePath);
		fileLines = new Stack<String>();
	}
	
	public void initParsing() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(dataFile));
		String line = null;
		while((line = reader.readLine()) != null){
			fileLines.add(line);
		}
		System.out.println("Succesfully readed " + fileLines.size() + " lines.");
	}
	
	public boolean hasNextLine(){
		if(!fileLines.empty()){
			return true;
		}
		return false;
	}
	
	public Knapsack parseNextLine(){
		String line = fileLines.pop();
		StringTokenizer tokenizer = new StringTokenizer(line);
		int id, instanceSize, capacity;
		int itemID = 0, weight, price;
		List<KnapsackItem> items = new ArrayList<KnapsackItem>();
		id = getNextInt(tokenizer.nextToken());
		instanceSize = getNextInt(tokenizer.nextToken());
		capacity = getNextInt(tokenizer.nextToken());
		for (int i = 0; i < instanceSize; i++){
			weight = getNextInt(tokenizer.nextToken());
			price = getNextInt(tokenizer.nextToken());
			items.add(new KnapsackItem(itemID++, weight, price));
		}
		return new Knapsack(id, instanceSize, capacity, items);
	}
	
	private Integer getNextInt(String token){
		return Integer.valueOf(token);
	}
}
