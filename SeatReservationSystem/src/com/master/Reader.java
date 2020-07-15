package com.master;

public class Reader implements Runnable {

    private final Process process;
    private final Seat[] seats;

    public Reader(Process process, Seat[] seats) {
        this.process = process;
        this.seats = seats;

    }

    @Override
    public void run() {
        queryReservation();
    }

    public void queryReservation(){
        this.process.queryReservation(this.seats);
    }

}
