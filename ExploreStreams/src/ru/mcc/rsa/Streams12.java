package ru.mcc.rsa;

import static java.util.Comparator.comparingDouble;

import java.util.List;
import java.util.stream.Collectors;

import ru.rsa.mcc.Customer;
import ru.rsa.mcc.Invoice;

public class Streams12 {
	public static void main(String[] args) {
		
		/*
		 * Stream vs parallel stream performance estimation 
		 */
		
		int processors = Runtime.getRuntime().availableProcessors();
	    System.out.println("CPU cores: " + processors);
	    
		List<Invoice> invoices = VeryBigData.populateDemoData();
		System.out.println("Populating demo data has been done!");
		
		long startTime = System.currentTimeMillis();
		List<Integer> first20Ids = invoices.stream()
											.filter(inv -> inv.getCustomerId() == Customer.ORACLE)
											.sorted(comparingDouble(Invoice::getAmount))
											.map(Invoice::getId)
											.limit(20)
											.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		
		long totalTime = endTime - startTime;
		System.out.println("Total time/sequenced stream: " + totalTime);
		
		first20Ids.stream().forEach(g -> System.out.println("Invoice Id: " + g));
		
		
		long startTimePs = System.currentTimeMillis();
		List<Integer> first20IdsPs = invoices.parallelStream()
											.filter(inv -> inv.getCustomerId() == Customer.ORACLE)
											.sorted(comparingDouble(Invoice::getAmount))
											.map(Invoice::getId)
											.limit(20)
											.collect(Collectors.toList());
		long endTimePs = System.currentTimeMillis();
		
		long totalTimePs = endTimePs - startTimePs;
		System.out.println("Total time/parallel stream: " + totalTimePs);

		first20IdsPs.stream().forEach(g -> System.out.println("Invoice Id: " + g));
		
		/*
		 * Sequenced stream - 3 sec.
		 * Parallel stream - 1.5 sec.
		 * 
		 * Nonetheless, it’s not always a good idea to use parallel streams.
		 * There are several factors you need to take into consideration to
		 * manage performance benefits, like, for example, splittability or size of a collection.
		 */
	}
}
