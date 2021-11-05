package com.invoiceservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;

    @BeforeEach
    void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double fare = invoiceGenerator.calculateFare(RideCategories.NORMAL_RIDES, 2.0, 5);
        Assertions.assertEquals(25.0, fare);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        double fare = invoiceGenerator.calculateFare(RideCategories.NORMAL_RIDES, 0.1, 1);
        Assertions.assertEquals(5, fare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        double fare = invoiceGenerator.calculateFare(RideCategories.NORMAL_RIDES, rides);
        Assertions.assertEquals(30, fare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFareSummary(RideCategories.NORMAL_RIDES, rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRide_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceGenerator.addRides("abc101", rides);
        InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(RideCategories.NORMAL_RIDES, "abc101");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenDistanceAndTime_ForPremiumRides_ReturnTotalFare() {
        double fare = invoiceGenerator.calculateFare(RideCategories.PREMIUM_RIDES, 2.0, 5);
        Assertions.assertEquals(40, fare);
    }

    @Test
    public void givenLessDistanceOrTime_ForPremiumRides_ShouldReturnMinFare() {
        double fare = invoiceGenerator.calculateFare(RideCategories.PREMIUM_RIDES, 0.1, 1);
        Assertions.assertEquals(20, fare);
    }

    @Test
    public void givenMultipleRides_ForPremiumRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        double fare = invoiceGenerator.calculateFare(RideCategories.PREMIUM_RIDES, rides);
        Assertions.assertEquals(60, fare);
    }

    @Test
    public void givenUserIdAndRide_ForPremiumRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceGenerator.addRides("abc102", rides);
        InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(RideCategories.PREMIUM_RIDES, "abc102");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60.0);
        Assertions.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}
