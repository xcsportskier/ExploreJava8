package ru.rsa.mcc;

@FunctionalInterface
public interface InvoicePredicate {
 boolean test(Invoice invoice);
}
