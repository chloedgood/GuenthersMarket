package guenthersmarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GuenthersLab {
	
	private static Scanner scan;
	private static Map<String, Double> items = new TreeMap<>(); 
	private static List<String> orderNames = new ArrayList<>();
	private static List<Double> orderPrices = new ArrayList<>();

	public static void main(String[] args) {
		String orderContinue = "";
		do { 
			
		scan = new Scanner(System.in);
		fillItemsMap();
		
		printMenu();
		System.out.println("What would you like to order?");
		String itemName = scan.nextLine();
		Double itemPrice = items.get(itemName);
	
		if (itemExist(itemName)) {
			  System.out.println("Adding " + itemName + " to cart as $" + itemPrice);
			  addToArrays(itemName, itemPrice);
        System.out.println("Would you like to order anything else (y/n)");
        orderContinue = scan.nextLine();
		}
		
		}while  (orderContinue.equals("y"));
		
		checkOut();
		}
	
	private static void fillItemsMap() {
			items.put("apple", .99);
			items.put("potato", 1.29);
			items.put("kiwi", 1.49);
			items.put("watermelon", 3.59);
			items.put("broccoli", 2.99);
			items.put("banana", .79);
			items.put("cucumber", 1.39);
			items.put("squash", 2.89);
	}
	 private static void printMenu() {
	        System.out.println("Item\tPrice"); 

	        for (Map.Entry<String, Double> entry : items.entrySet()) {
	            System.out.println(entry.getKey() + "\t"
	                    + entry.getValue());
	        }
	    }
	private static void averageCost() {  //average cost of all ordered items
        double averageValue = 0;
        double sum = 0;
        for (int i = 0; i < orderPrices.size(); i++) {
            sum += orderPrices.get(i);
            averageValue = sum / orderPrices.size();
        }
        System.out.println("Average price per item in order was " + averageValue);
    }

    private static void highestCost() { //looking for highest priced item in arraylist
        double highestCost = orderPrices.get(0);
        for (int i = 1; i < orderPrices.size(); i++) {
            double curValue = orderPrices.get(i);
            if (curValue > highestCost) {
                highestCost = curValue;
            }
        }
        System.out.println("Your highest cost item is " + highestCost);
    }
    private static void lowestCost(){
        double lowestCost = orderPrices.get(0);
        for (int i = 1; i < orderPrices.size(); i++) {
            double curValue = orderPrices.get(i);
            if (curValue < lowestCost) {
                lowestCost = curValue;
            }
        }
        System.out.println("Your lowest cost item is " + lowestCost);
    }
	 
	 private static boolean itemExist(String itemName) { 
	            if (items.get(itemName) == null) {
	                System.out.println("Sorry, we don't have those. Please try again.");
	                return false;
	            } else {
	                return true;
	            }
	            
	 }
	 
	 private static void addToArrays (String addItemName, Double addItemPrice) {
		 orderNames.add(addItemName);
		 orderPrices.add(addItemPrice);
	 }
	 
	 private static void checkOut() {
		 System.out.println("Here's what you ordered:");
		 printOrder();
	 }
	 
	 private static void printOrder() {
	 System.out.println("Item\tPrice"); 

     for (int i = 0; i < orderNames.size(); i++) {
         System.out.println(orderNames.get(i) + "\t" + orderPrices.get(i));
}
			
	 }
	 }		
