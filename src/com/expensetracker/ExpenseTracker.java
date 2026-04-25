package com.expensetracker;

import java.util.*;
import java.io.*;

class Expense{
	String category;
	double amount;
	
	Expense(String category, double amount){
		this.category = category;
		this.amount = amount;
	}
}

public class ExpenseTracker {
	
	static final String File_Name = "expenses.txt";
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n---- Expense Tracker ----");
			System.out.println("1. Add Expense");
			System.out.println("2. View Expenses");
			System.out.println("3. Exit");
			System.out.println("Enter your choice: ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				addExpense(sc);
				break;
			case 2:
				viewExpenses();
				break;
			case 3:
				System.out.println("Exiting....");
				break;
			default:
				System.out.println("Invalid choice!");
				
			}
		}
	}


	static void addExpense(Scanner sc) throws IOException {
		sc.nextLine();
		
		System.out.println("Enter category: ");
		String category = sc.nextLine();
		
		System.out.println("enter amount: ");
		double amount = sc.nextDouble();
		
		FileWriter fw = new FileWriter(File_Name, true);
		fw.write(category + " " + amount + "\n");
		fw.close();
		
		System.out.println("Expense added!");
	}
	
	
	static void viewExpenses() throws FileNotFoundException {
		File file = new File(File_Name);
		
		if(!file.exists()) {
			System.out.println("No expenses found!");
			return;
		}
		
		Scanner sc = new Scanner(file);
		double total = 0;
		
		System.out.println("\n---- All Expenses ----");
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(line);
			
			String[] parts = line.split(" ");
			total += Double.parseDouble(parts[1]);
		}
		
		System.out.println("Total Expenses: "+total);
		sc.close();
	}
	
	
}
