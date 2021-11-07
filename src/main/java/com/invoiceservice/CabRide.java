package com.invoiceservice;

public enum CabRide {
    NORMAL_RIDES(10.0, 1, 5.0), PREMIUM_RIDES(15.0, 2, 20.0);

    private final double costPreKm;
    private final double minFarePerRide;
    private final int costPerMin;

    CabRide(double costPreKm, int costPerMin, double minFare) {
        this.costPreKm = costPreKm;
        this.costPerMin = costPerMin;
        this.minFarePerRide = minFare;
    }

    /**
     * Purpose : To Calculate Fare For Given Ride
     *
     * @param ride
     * @return Total Fare
     */
    public double calcCostOfCabFare(Ride ride) {
        double totalFare = ride.distance * costPreKm + ride.time * costPerMin;
        return Math.max(totalFare, minFarePerRide);
    }
}

