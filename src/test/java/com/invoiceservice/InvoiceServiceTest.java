package com.invoiceservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(2.0, 5);
        Assertions.assertEquals(25.0, fare);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(0.1, 1);
        Assertions.assertEquals(5, fare);
    }
}
