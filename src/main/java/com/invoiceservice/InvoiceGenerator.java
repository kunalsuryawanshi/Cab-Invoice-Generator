package com.invoiceservice;

public class InvoiceGenerator {

    private static RideRepository rideRepository = new RideRepository();

    /**
     * Purpose : To Calculate Fare
     *
     * @param category : Ride Type
     * @param distance
     * @param time
     * @return Total Fare
     */
    public static double calculateFare(RideCategories category, double distance, int time) {
        if (category == RideCategories.NORMAL_RIDES)
            return RideCategories.NORMAL_RIDES.calculateFare(distance, time);
        return RideCategories.PREMIUM_RIDES.calculateFare(distance, time);
    }

    /**
     * Purpose : To Calculate Multiple Fare
     *
     * @param rides
     * @return Total Fare
     */
    public double calculateFare(RideCategories category, Ride[] rides) {
        double totalFare = 0;
        if (category == RideCategories.NORMAL_RIDES) {
            for (Ride ride : rides) totalFare += RideCategories.NORMAL_RIDES.calculateFare(ride.distance, ride.time);
        } else for (Ride ride : rides) totalFare += RideCategories.PREMIUM_RIDES.calculateFare(ride.distance, ride.time);
        return totalFare;
    }

    /**
     * Purpose To Calculate Multiple Fare And Invoice Summary
     *
     * @param rides
     * @return Total Fare With Summary
     */
    public InvoiceSummary calculateFareSummary(RideCategories category, Ride[] rides) {
        double totalFare = 0;
        if (category == RideCategories.NORMAL_RIDES) {
            for (Ride ride : rides) {
                totalFare += RideCategories.NORMAL_RIDES.calculateFare(ride.distance, ride.time);
            }
            return new InvoiceSummary(rides.length, totalFare);
        } else {
            for (Ride ride : rides) {
                totalFare += RideCategories.PREMIUM_RIDES.calculateFare(ride.distance, ride.time);
            }
            return new InvoiceSummary(rides.length, totalFare);
        }
    }

    /**
     * Purpose : To Get Rides and Calculate Fare
     *
     * @param userId
     * @return Calculate Fare Summary
     */
    public InvoiceSummary getInvoiceSummary(RideCategories category, String userId) {
        if (category == RideCategories.NORMAL_RIDES)
            return this.calculateFareSummary(RideCategories.NORMAL_RIDES, rideRepository.getRides(userId));
        return this.calculateFareSummary(RideCategories.PREMIUM_RIDES, rideRepository.getRides(userId));

    }

    /**
     * Purpose : To add Rides in
     *
     * @param userId
     * @param rides
     */
    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }
}
