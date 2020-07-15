package com.master;

import java.util.Random;

public class Writer implements Runnable {
    private final Process process;
    private final Client client;
    private final Seat[] seats;

    public Writer(Process process, Client client, Seat[] seats) {
        this.process = process;
        this.client = client;
        this.seats = seats;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int randChoice = rand.nextInt(2);
        if (randChoice == 0) {
            makeReservation();
        } else {
            cancelReservation();
        }
    }

    public void makeReservation(){
        this.process.makeReservation(this.client, this.seats);
    }

    public void cancelReservation(){
        this.process.cancelReservation(this.seats,this.client.getSeatId());
    }

}

