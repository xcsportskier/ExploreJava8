package ru.rsa.mcc;

import java.util.Comparator;
import java.util.List;

public class Lambda13 extends Lambda3 {

	public Lambda13(List<Invoice> invoices) {
		super(invoices);
	}
	
	public static void main(String[] args) {
		Lambda13 ld = new Lambda13(DemoData.populateDemoData());
		List<Invoice> invoices = ld.getInvoices();
		DemoData.printDemoData(invoices);
		
		/*
		 * invoices.sort((inv1, inv2) -> Double.compare(inv2.getAmount(), inv1.getAmount()));
		 */
		
		/*
		 *  Java 8 introduces a static helper, Comparator.comparing
		 *  which takes as argument a lambda to extract a comparable key.
		 *  It also generates a Comparator object for you.
		 *  For example:
		 *  
		 *  Comparator<Invoice> byAmount = Comparator.comparing((Invoice inv) -> inv.getAmount());
         *  invoices.sort(byAmount);
		 *  
		 *  Or, even better more concise form:
		 */
		invoices.sort(Comparator.comparing(Invoice::getAmount));
		

		DemoData.printDemoData(invoices);
	}
}