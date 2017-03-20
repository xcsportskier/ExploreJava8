package ru.rsa.mcc;

import java.util.Comparator;
import java.util.List;

public class Lambda14 extends Lambda3 {

	public Lambda14(List<Invoice> invoices) {
		super(invoices);
	}
	
	public static void main(String[] args) {
		Lambda13 ld = new Lambda13(DemoData.populateDemoData());
		List<Invoice> invoices = ld.getInvoices();
		DemoData.printDemoData(invoices);
		
		/*
		 * invoices.sort(Comparator.comparing(Invoice::getAmount));
		 */
		
		/*
		 *  Since the method getAmount returns a primitive double,
		 *  we can use Comparator.comparingDouble which is a primitive
		 *  specialized version of Comparator.comparing.
		 *  This helps to avoid unnecessary boxing.
		 *  This is the end of refactoring process, just feel the difference:
		 *  
		 *	Collections.sort(invoices, new Comparator<Invoice>() {
		 *  	public int compare(Invoice inv1, Invoice inv2) {
		 *	    	return Double.compare(inv2.getAmount(), inv1.getAmount());
		 *	    }
		 * });
		 */
		invoices.sort(Comparator.comparingDouble(Invoice::getAmount));
		

		DemoData.printDemoData(invoices);
	}
}
