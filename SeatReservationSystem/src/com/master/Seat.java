package com.master;

public class Seat {
    private int seatId;
    private String property;
    private boolean available;
    private String clientName;

    public Seat(int seatId, String property) {
        this.seatId = seatId;
        this.property = property;
        this.available = true;
        this.clientName = "Empty" ;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
