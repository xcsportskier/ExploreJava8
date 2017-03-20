package ru.rsa.mcc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda7 extends Lambda3 {

	public Lambda7(List<Invoice> invoices) {
		super(invoices);
	}	
	
	public static void main(String[] args) {
		Lambda7 ld = new Lambda7(DemoData.populateDemoData());
		DemoData.printDemoData(ld.getInvoices());
			
		List<Invoice> invoices = ld.getInvoices();
		
		// old-style code
		class InvoiceAmountComparator implements Comparator<Invoice> {
		    public int compare(Invoice i1, Invoice i2) {
		        return i1.getAmount().compareTo(i2.getAmount());
		    }
		}
		
		Collections.sort(invoices, new InvoiceAmountComparator());
		// end of old-style code
		
		// comparator is a functional interface, so...
		Collections.sort(invoices, (i1, i2) -> i1.getAmount().compareTo(i2.getAmount()));
		// end of comparator is a functional interface, so...
		
		// method to compare the amounts of two Invoices already exists in Invoice class, so...
		Collections.sort(invoices, (i1, i2) -> Invoice.compareByAmount(i1, i2));
		// end of method to compare the amounts of two Invoices already exists in Invoice class, so...
		
		// because this lambda expression invokes an existing method, you can use a method reference instead of a lambda expression
		Collections.sort(invoices, Invoice::compareByAmount);
		// end of because this lambda expression invokes an existing method, you can use a method reference instead of a lambda expression
		
		// what if compareByAmount method is not declared by static?
		ComparisonProvider myComparisonProvider = new ComparisonProvider();
		Collections.sort(invoices, myComparisonProvider::compareByAmount);
		// end of what if compareByAmount method is not declared by static?

		DemoData.printDemoData(invoices);
	}
}
