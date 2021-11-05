package com.invoiceservice;

public enum RideCategories {
    NORMAL_RIDES(10.0, 1, 5.0), PREMIUM_RIDES(15.0, 2, 20.0);

    private final double MINIMUM_COST_PER_KILOMETER;
    private final double MINIMUM_FARE;
    private final int COST_PER_TIME;

    RideCategories(double MINIMUM_COST_PER_KILOMETER, int COST_PER_TIME, double MINIMUM_FARE) {
        this.MINIMUM_COST_PER_KILOMETER = MINIMUM_COST_PER_KILOMETER;
        this.COST_PER_TIME = COST_PER_TIME;
        this.MINIMUM_FARE = MINIMUM_FARE;
    }

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
}

