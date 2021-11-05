package com.invoiceservice;

public class InvoiceGenerator {

    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;

    /**
     * Purpose : To Calculate Fare
     *
     * @param distance
     * @param time
     * @return Total Fare
     */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /**
     * Purpose : To Calculate Multiple Fare
     *
     * @param rides
     * @return Total Fare
     */
    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    /**
     * Purpose To Calculate Multiple Fare And Invoice Summary
     *
     * @param rides
     * @return Total Fare With Summary
     */
    public InvoiceSummary calculateFareSummary(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
