package com.invoiceservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<Ride>> userRides;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    /**
     * Purpose : To Add UserId and Ride in Hashmap
     *
     * @param userId
     * @param rides
     */
    public void addRides(String userId, Ride[] rides) {
        this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
    }

    /**
     * Purpose : To Get Ride Details
     *
     * @param userId
     * @return ride
     */
    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
