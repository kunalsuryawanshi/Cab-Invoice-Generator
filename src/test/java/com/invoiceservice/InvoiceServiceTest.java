package com.invoiceservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    Ride[] rides = null;
    InvoiceService invoiceService = null;
    InvoiceSummary expectedInvoiceSummary = null;
    private RideRepository rideRepository = null;

    @BeforeEach
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
        rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
        rides = new Ride[]{
                new Ride(CabRide.NORMAL_RIDES, 2.0, 5),
                new Ride(CabRide.PREMIUM_RIDES, 0.1, 1)
        };
        expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        Assertions.assertEquals(summary, expectedInvoiceSummary);
    }

    @Test
    public void givenUserIdAndRide_ShouldReturnInvoiceSummary() {
        String userId = "abc101";
        invoiceService.addRides(userId, rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary("abc101");
        Assertions.assertEquals(invoiceSummary, expectedInvoiceSummary);
    }
}
