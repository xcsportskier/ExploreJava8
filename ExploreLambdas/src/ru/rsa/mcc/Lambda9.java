package ru.rsa.mcc;

import java.util.List;
import java.util.function.Function;

public class Lambda9 extends Lambda3 {

	public Lambda9(List<Invoice> invoices) {
		super(invoices);
	}

	public static void main(String[] args) {
		Lambda9 ld = new Lambda9(DemoData.populateDemoData());
		DemoData.printDemoData(ld.getInvoices());

		/*
		 * @FunctionalInterface
		 * public interface Function<T, R> { 
		 * R apply(T t);
		 * }
		 */

		// Functional interface demonstration
		Function<List<Invoice>, Double> agregatedQuantity = invoices -> {
			Double aggregatedAmount = 0.0;
			for (Invoice inv : invoices) {
				aggregatedAmount += inv.getAmount();
			}
			return aggregatedAmount;
		};

		Double totalAmount = agregatedQuantity.apply(ld.getInvoices());

		System.out.println("Total amount is: " + totalAmount);
	}
}
