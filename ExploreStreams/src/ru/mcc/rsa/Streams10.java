package ru.mcc.rsa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Comparator.comparingDouble;

import ru.rsa.mcc.Customer;
import ru.rsa.mcc.DemoData;
import ru.rsa.mcc.Invoice;

public class Streams10 {
	public static void main(String[] args) {
		/*
		 * Here is the final code has been refactored
		 */
		List<Invoice> invoices = DemoData.populateDemoData();
		DemoData.printDemoData(invoices);
		
		List<Integer> firstTwoIds = invoices.stream()
											.filter(inv -> inv.getCustomerId() == Customer.ORACLE)
											.sorted(comparingDouble(Invoice::getAmount))
											.map(Invoice::getId)
											.limit(2)
											.collect(Collectors.toList());
		
		firstTwoIds.stream().forEach(g -> System.out.println("Invoice Id: " + g));
		
		System.out.println("====================================================");
		
		// or even better
		invoices.stream()
				.filter(inv -> inv.getCustomerId() == Customer.ORACLE)
				.sorted(comparingDouble(Invoice::getAmount))
				.map(Invoice::getId)
				.limit(2)
				.forEach(g -> System.out.println("Invoice Id: " + g));
	}
		
}
