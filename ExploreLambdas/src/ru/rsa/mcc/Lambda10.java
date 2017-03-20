package ru.rsa.mcc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda10 extends Lambda3 {

	public Lambda10(List<Invoice> invoices) {
		super(invoices);
	}
	
	public static void main(String[] args) {
		Lambda10 ld = new Lambda10(DemoData.populateDemoData());
		List<Invoice> invoices = ld.getInvoices();
		DemoData.printDemoData(invoices);
		
        /*
         * Here is the quite verbose code
         * for sorting invoices
         * Is to be refactoring
         */
		Collections.sort(invoices, new Comparator<Invoice>() {
			public int compare(Invoice inv1, Invoice inv2) {
				return Double.compare(inv1.getAmount(), inv2.getAmount());
			}
		});

		DemoData.printDemoData(invoices);
	}
}

