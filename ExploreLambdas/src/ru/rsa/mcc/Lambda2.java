package ru.rsa.mcc;

import java.util.ArrayList;
import java.util.List;

public class Lambda2 extends Lambda1 {

	public Lambda2(List<Invoice> invoices) {
		super(invoices);
	}
	
	// implements behavior parametrization pattern
	public List<Invoice> findInvoices(InvoicePredicate p) {
		List<Invoice> result = new ArrayList<>();
		for (Invoice inv : this.getInvoices()) {
			if (p.test(inv)) {
				result.add(inv);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Lambda2 ld = new Lambda2(DemoData.populateDemoData());
		DemoData.printDemoData(ld.getInvoices());
		
		List<Invoice> findResult = ld.findInvoices(new InvoicePredicate() { // implemented as anonymous class
			public boolean test(Invoice inv) {
				return inv.getAmount() > 1900 && inv.getCustomerId() == Customer.ORACLE;
			}
		});
		
		DemoData.printDemoData(findResult);
	}
}
