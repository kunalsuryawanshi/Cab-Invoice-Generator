package com.invoiceservice;

public class InvoiceService {
    private static RideRepository rideRepository;

    public void setRideRepository(RideRepository rideRepository) {
        InvoiceService.rideRepository = rideRepository;
    }

    /**
     * Purpose To Calculate Multiple Fare And Invoice Summary
     *
     * @param rides
     * @return Total Fare With Summary
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += ride.cabRide.calcCostOfCabFare(ride);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * Purpose : To Get Rides and Calculate Fare
     *
     * @param userId
     * @return Calculate Fare Summary
     */
    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }

    /**
     * Purpose : To add Rides in userRides
     *
     * @param userId
     * @param rides
     */
    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }
}