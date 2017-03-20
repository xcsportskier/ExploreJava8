package ru.rsa.mcc;

import java.util.List;

public class Lambda12 extends Lambda3 {

	public Lambda12(List<Invoice> invoices) {
		super(invoices);
	}
	
	public static void main(String[] args) {
		Lambda12 ld = new Lambda12(DemoData.populateDemoData());
		List<Invoice> invoices = ld.getInvoices();
		DemoData.printDemoData(invoices);
		
		/*
		 * Collections.sort(invoices,(Invoice inv1, Invoice inv2) -> Double.compare(inv2.getAmount(), inv1.getAmount()));
		 */
		
		/*
		 *  In Java 8 the List interface supports the sort method,
		 *  so you can use it instead of Collections.sort
		 *  Also all declarations in the list of parameters are omitted
		 */
		invoices.sort((inv1, inv2) -> Double.compare(inv1.getAmount(), inv2.getAmount()));
		

		DemoData.printDemoData(invoices);
	}
}
