package ru.mcc.rsa;

import java.util.List;
import java.util.Optional;

import ru.rsa.mcc.Customer;
import ru.rsa.mcc.DemoData;
import ru.rsa.mcc.Invoice;

public class Streams4 {

	public static void main(String[] args) {
		List<Invoice> invoices = DemoData.populateDemoData();
		DemoData.printDemoData(invoices);

		/*
		 * Stream finding - retrieving arbitrary elements from a stream
		 * 
		 * findFirst - retrieve first element from a stream
		 * findAny - retrieve any element from a stream
		 * 
		 * Be careful!
		 * It is important to note that Stream.findAny() method can literally give you 
		 * any element from the stream on which it is called. 
		 * I.e. you should not code with an expectation that a particular value will always be returned. 
		 * This non-deterministic nature of the findAny() method is very useful 
		 * when executing parallel operations on a stream as it helps in performance 
		 * optimization without worrying about which element will be returned.
		 */
		Optional<Invoice> oracleInvoices = invoices.stream()
										.filter(inv -> inv.getCustomerId() == Customer.ORACLE)
										.findFirst();
		
		Invoice oracleInvoice = oracleInvoices.get();
		
		invoices.clear();
		invoices.add(oracleInvoice);
		
		DemoData.printDemoData(invoices);
	}

}
