package com.master;

public class Flight {
    private String flightName;
    private Seat [] seats;
    private int size;

    public Flight(String flightName, int size){
        this.flightName = flightName;
        this.size = size;
        this.seats = new Seat[size];
        int business = (int) (size*0.3);
        for (int i = 0; i < this.size ; i++){
            if (i < business){
                this.seats[i] = new Seat(i,"Business");
            }else{
                this.seats[i] = new Seat(i,"Economy\t");
            }
        }
    }


    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
