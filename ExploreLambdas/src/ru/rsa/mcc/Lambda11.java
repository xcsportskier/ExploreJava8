package ru.rsa.mcc;

import java.util.Collections;
import java.util.List;

public class Lambda11 extends Lambda3 {

	public Lambda11(List<Invoice> invoices) {
		super(invoices);
	}
	
	public static void main(String[] args) {
		Lambda11 ld = new Lambda11(DemoData.populateDemoData());
		List<Invoice> invoices = ld.getInvoices();
		DemoData.printDemoData(invoices);
		
        /*
		Collections.sort(invoices, new Comparator<Invoice>() {
			public int compare(Invoice inv1, Invoice inv2) {
				return Double.compare(inv1.getAmount(), inv2.getAmount());
			}
		});
		*/
		
		/*
		 * Comparator is a functional interface
		 * becouse it only declares a single abstract method called compare
		 * which takes two objects of same type and returns an integer.
		 * Ideal choice for a lambda expression
		 */
		Collections.sort(invoices,(Invoice inv1, Invoice inv2) -> Double.compare(inv1.getAmount(), inv2.getAmount()));

		DemoData.printDemoData(invoices);
	}
}
