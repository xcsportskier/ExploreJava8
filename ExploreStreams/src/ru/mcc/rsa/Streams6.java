package ru.mcc.rsa;

import java.util.List;

import ru.rsa.mcc.DemoData;
import ru.rsa.mcc.Invoice;

public class Streams6 {
	
	public static void main(String[] args) {
		List<Invoice> invoices = DemoData.populateDemoData();
		DemoData.printDemoData(invoices);
		
		/*
		 * Reducing
		 * 
		 * A common pattern is that of combining elements from a source
		 * to provide a single value.
		 * For example "calculate the sum of all invoices" or
		 * "calculate the average of all invoices"
		 * 
		 * As an example of a  reduce pattern, it helps to first look at how you
		 * could calculate the sum of a list using a for loop:
		 * 
		 * int sum = 0;
		 * for (int x : numbers) {
		 * sum += x;
		 * }
		 * 
		 * average - returns an OptionalDouble describing the arithmetic mean of elements of this stream, 
		 * or an empty optional if this stream is empty.
		 */
		Double invAvg = invoices.stream()
							 .mapToDouble(Invoice::getAmount)
							 .average().getAsDouble();
		System.out.println("Average value of all invoices, method average = " + invAvg);
		
		Double invSum = invoices.stream()
								.mapToDouble(Invoice::getAmount)
								.sum();
		System.out.println("Sum value of all invoices, method sum = " + invSum);
	}
}
