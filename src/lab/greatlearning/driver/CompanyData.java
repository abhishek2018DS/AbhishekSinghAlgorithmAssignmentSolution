package com.greatlearning.driver;
import com.greatlearning.mergesort.MergeSortImplementation;
import com.greatlearning.mergesort.descend.MergeSortDescending;
import com.greatlearning.stocksearching.StockSearching;
import java.util.Scanner;
import java.util.Arrays;

public class CompanyData{
	public static void main(String [] args){
		MergeSortImplementation ob = new MergeSortImplementation();
		MergeSortDescending ob2 = new MergeSortDescending();
		StockSearching ob3 = new StockSearching();
		System.out.println("Enter the number of companies: ");
		Scanner sc= new Scanner(System.in);
		int size= sc.nextInt();

		int count =0;
                int decline= 0; 

		//System.out.println("size of the company entered: "+size);
		Boolean compArray[]= new Boolean[size];
		double myArray []= new double[size];
		for (int i= 0; i <size; i++){
			System.out.println("Enter the current stock price of the company: "+(i+1) );
			myArray[i]= sc.nextDouble();
			System.out.println("Whether company's stock price rose today comparison to yesterday: ");
			compArray[i]= sc.nextBoolean();
		}
		//System.out.println("the company Stock price: "+Arrays.toString(myArray));
		//System.out.println("the company Stock price: "+Arrays.toString(compArray));

		System.out.println("Enter the operation that you want to perform ");
		System.out.println("1. Display the companies stock in ascending order");
		System.out.println("2. Display the companies stock in descending order");
		System.out.println("3. Display the total number of companies for which stock price rose today");
		System.out.println("4. Display the total number of companies for which stock price declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. Press 0 for exit");
		int query= sc.nextInt();
		switch(query){
			case 0:
				System.out.println("Exited Successfully ");
				break;
			case 1:
				System.out.println("stock prices in ascending order");
				ob.sort(myArray, 0, myArray.length-1);
				//System.out.println("\nSorted array");
				ob.printArray(myArray);
				break;
			case 2:
				System.out.println("Stock prices in descending order are: ");
				ob2.sort(myArray, 0, myArray.length-1);
				//System.out.println("\nSorted array");
				ob2.printArray(myArray);
				break;

			case 3:
				System.out.println("Total no of companies whose stock price rose today: ");
				for(int i =0; i < size; i++){
					if (compArray[i]== true){
						count++;
						}
					}
				System.out.println(count);
				break;
			case 4:
				System.out.println("Total no of companies whose stock price declined today: ");
				for(int i =0; i < size; i++){
					if (compArray[i]== false){
						decline++;
						}
					}
				System.out.println(decline);
				break;
			case 5:
				System.out.println("enter the key value: ");
				double x = sc.nextDouble();
				int n = myArray.length;
				int result = ob3.stockSearch(myArray,0,n-1,x);
				if (result == -1){
					System.out.println("Stock of value "+x +" not found");
					}
				else
					System.out.println("Stock of Value "+x +"found");

				break;
			default:
				System.out.println("You have selected wrong option");
				break; 

		}

	}
}
