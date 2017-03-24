package ru.mcc.rsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ru.rsa.mcc.DemoData;
import ru.rsa.mcc.Invoice;

public class Streams7 {
	public static void main(String[] args) {
		List<Invoice> invoices = DemoData.populateDemoData();
		DemoData.printDemoData(invoices);
		/*
		 * The operations you have seen so far were either returning another
		 * stream (i.e., intermediate operations) or returning a value, such as a
		 * Double, or an  Optional object (i.e., terminal operations).
		 * By contrast, the  collect method is a terminal operation. It lets you
		 * accumulate the elements of a stream into a summary result.
		 * The argument passed to  collect is an object of type
		 * java.util.stream.Collector. A  Collector  object essentially
		 * describes a recipe for accumulating the elements of a stream into a
		 * final result. The factory method  Collectors.toList()used earlier
		 * returns a  Collector object describing how to accumulate a stream
		 * into a  List. However, there are many similar built-in collectors
		 * available, which you can see in the class  Collectors. For example,
		 * you can group invoices by customers using Collectors.groupingBy
		 * as shown here
		 */
		Map<String, List<Invoice>> customerToInvoices = invoices.stream()
																.collect(
																	Collectors.groupingBy(Invoice::getCustomerName)
																);
		
		// print this information out
		List<Map.Entry<String, List<Invoice>>> totalAmountByCustomerList = new ArrayList<>(customerToInvoices.entrySet());
		
		totalAmountByCustomerList.stream()
		 						 .forEach(g -> { 
		 							 System.out.printf("Orders for customer %s:\n", g.getKey());
		 							 DemoData.printDemoData(g.getValue());
		 						 });
	}
}
