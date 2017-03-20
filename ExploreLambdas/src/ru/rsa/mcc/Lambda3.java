package ru.rsa.mcc;

import java.util.List;

public class Lambda3 extends Lambda2 {

	public Lambda3(List<Invoice> invoices) {
		super(invoices);
	}

	public static void main(String[] args) {
		Lambda3 ld = new Lambda3(DemoData.populateDemoData());
		DemoData.printDemoData(ld.getInvoices());

		List<Invoice> findResult = ld.findInvoices(inv ->
				inv.getAmount() > 1900 && inv.getCustomerId() == Customer.IBM // implemented as a lambda expression
		);

		DemoData.printDemoData(findResult);
	}
}
