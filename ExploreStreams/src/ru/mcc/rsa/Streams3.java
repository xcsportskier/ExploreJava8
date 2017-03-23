package ru.mcc.rsa;

import java.util.List;

import ru.rsa.mcc.DemoData;
import ru.rsa.mcc.Invoice;

public class Streams3 {
	
	public static void main(String[] args) {
		List<Invoice> invoices = DemoData.populateDemoData();
		DemoData.printDemoData(invoices);

		/*
		 * Stream matching - a common data processing pattern is determining 
		 * whether some elements match a given property.
		 * 
		 * anyMatch - some elements are matched
		 * allMatch - all elements are matched
		 * noneMatch - no one element is matched
		 */
		boolean cheapInvoice = invoices.stream().anyMatch(inv -> inv.getAmount() < 100);

		System.out.println(cheapInvoice);
	}
	
}
