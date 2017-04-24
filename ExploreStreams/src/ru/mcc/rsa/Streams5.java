package ru.mcc.rsa;

import java.util.List;
import java.util.stream.Collectors;

import ru.rsa.mcc.DemoData;
import ru.rsa.mcc.Invoice;

public class Streams5 {

	public static void main(String[] args) {
		List<Invoice> invoices = DemoData.populateDemoData();
		DemoData.printDemoData(invoices);

		/*
		 * Stream mapping
		 * 
		 * Streams support the method map, which takes Function object as an
		 * argument to turn the elements of a stream into another type. The
		 * function is applied to each element, mapping it into a new one.
		 */

		List<Integer> ids = invoices.stream()
									.map(Invoice::getId)
									.collect(Collectors.toList());
		// and print it
		for (Integer id : ids) {
			System.out.println("Invoice Id:" + id);
		}
		/*
		 * More complex map example
		 * We want to get unique names of customers from invoices
		 * 
		 * distinct is a filtering operation which returns a stream with unique elements
		 * (according to the implementation of equals for a stream element)
		 */
		List<String> customerNames = invoices.stream()
				.map(Invoice::getCustomerName)
				.distinct()
				.collect(Collectors.toList());
		// and print it
		for (String name : customerNames) {
			System.out.println("Customer Name:" + name);

		}
	}
}
