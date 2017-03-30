package ru.mcc.rsa;

import java.util.ArrayList;
import java.util.List;

import ru.rsa.mcc.Invoice;

/*
 * Here is the demo data for estimate performance of streams
 */
public class VeryBigData {
	public static final List<Invoice> populateDemoData() {
		List<Invoice> lst = new ArrayList<>();
		
		for (int i = 1; i < 5000000; i++) {
		 lst.add(new Invoice(new Integer(i), new Integer(10), "Oracle", new Double(Math.random()*100 + 1.0)));
		}
		
		for (int i = 5000001; i < 10000000; i++) {
		 lst.add(new Invoice(new Integer(i), new Integer(20), "Microsoft", new Double(Math.random()*100 + 1.0)));
		}
		return lst;
	}
}
