package ru.mcc.rsa;

import java.util.List;
import java.util.stream.Collectors;

import ru.rsa.mcc.Customer;
import ru.rsa.mcc.DemoData;
import ru.rsa.mcc.Invoice;
import static java.util.Comparator.comparingDouble;

public class Streams1 {

	public static void main(String[] args) {
		List<Invoice> invoices = DemoData.populateDemoData();
		DemoData.printDemoData(invoices);
		
		/*
		 * For example we need to filter a list of invoices
		 * to find those related to a specific customer
		 * and sort then by amount of the invoice
		 */

		// get only oracle invoices sorted by amount ascending 
		List<Invoice> oracleInvoices = invoices.stream()
				.filter(inv -> inv.getCustomerId() == Customer.ORACLE)
				.sorted(comparingDouble(Invoice::getAmount))
				.collect(Collectors.toList());
		DemoData.printDemoData(oracleInvoices);
		
		/*
		 * ... additionally we can extract Ids of the founded invoices 
		 */
		
		// get only oracle invoices ids sorted by amount ascending 
		List<Integer> oracleInvoiceIds = invoices.stream()
		 .filter(inv -> inv.getCustomerId() == Customer.ORACLE)
		 .sorted(comparingDouble(Invoice::getAmount))
		 .map(Invoice::getId)
		 .collect(Collectors.toList());
		// and print it
		for (Integer id : oracleInvoiceIds) {
			System.out.println("Invoice Id:" + id);
		}
	}

}
