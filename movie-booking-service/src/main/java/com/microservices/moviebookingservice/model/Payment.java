package com.microservices.moviebookingservice.model;

public class Payment {

    private long id;

    private long amount;

    public Payment() {
    }

    public Payment(long amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public long getAmount() {
        return amount;
    }
}
