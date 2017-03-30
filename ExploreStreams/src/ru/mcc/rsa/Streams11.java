package ru.mcc.rsa;

import static java.util.Comparator.comparingDouble;

import java.util.List;
import java.util.stream.Collectors;

import ru.rsa.mcc.Customer;
import ru.rsa.mcc.DemoData;
import ru.rsa.mcc.Invoice;

public class Streams11 {
	public static void main(String[] args) {
		/*
		 * Here is the final code has been refactored
		 * also, the parallel stream are being used in this demo.
		 * 
		 * The Streams API supports easy data parallelism. In other words, you
		 * can explicitly ask for a stream pipeline to be performed in parallel
		 * without thinking about low-level implementation details. Behind
		 * the scenes, the Streams API will use the Fork/Join framework, which
		 * will leverage the multiple cores of your machine.
		 * All you need to do is exchange  stream()with  parallelStream()
		 */
		List<Invoice> invoices = DemoData.populateDemoData();
		DemoData.printDemoData(invoices);
		
		List<Integer> firstTwoIds = invoices.parallelStream()
											.filter(inv -> inv.getCustomerId() == Customer.ORACLE)
											.sorted(comparingDouble(Invoice::getAmount))
											.map(Invoice::getId)
											.limit(2)
											.collect(Collectors.toList());
		
		firstTwoIds.stream().forEach(g -> System.out.println("Invoice Id: " + g));

	}
}
