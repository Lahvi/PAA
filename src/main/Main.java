package main;

import java.io.IOException;

import algorithms.BranchAndBound;

import model.Knapsack;

import parser.DataParser;

public class Main {
	public static void main(String[] args) throws IOException{
		DataParser parser = new DataParser("data\\knap_4.inst.dat");
		parser.initParsing();
		while(parser.hasNextLine()){
			Knapsack currentInstance = parser.parseNextLine();
			BranchAndBound algorithm = new BranchAndBound(currentInstance);
			algorithm.exectue();
		}
	}
}
