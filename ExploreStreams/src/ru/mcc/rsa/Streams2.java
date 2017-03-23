package ru.mcc.rsa;

import java.util.List;
import java.util.stream.Collectors;

import ru.rsa.mcc.DemoData;
import ru.rsa.mcc.Invoice;

public class Streams2 {

	public static void main(String[] args) {
		List<Invoice> invoices = DemoData.populateDemoData();
		DemoData.printDemoData(invoices);
		
		/*
		 * Stream filtering
		 * 
		 * filter - takes a predicate object and returns a stream including all elements that match the predicate
		 * distinct - returns a stream with unique elements (according to the implementation of equals for a stream element)
		 * limit - returns a stream that is no longer than a certain size
		 * skip - returns a stream with the first n number of elements discarded
		 */
		List<Invoice> someInvoices = invoices.stream()
										.filter(inv -> inv.getAmount() > 160)
										.limit(3)
										.skip(2)
										.collect(Collectors.toList());
				
		DemoData.printDemoData(someInvoices);
	}		
}