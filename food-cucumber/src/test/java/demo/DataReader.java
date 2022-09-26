package demo;

import java.util.List;

import utils.*;
public class DataReader 
{
	public static final String pathCSVFile = "../food-cucumber/datas/usertest.csv"; 
	public static void main(String[] args) {
		readCSV();
	}
	
	public static void readCSV() 
	{
		List<String []> records =  CSV.get(pathCSVFile);
		for ( String [] record : records) 
		{
			for (String field: record ) {
				System.out.println(field);
			}
		}
	}

}
