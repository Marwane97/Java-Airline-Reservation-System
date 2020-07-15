package com.master;

public interface Process {
    public void queryReservation(Seat[] seats);

    public void makeReservation(Client client, Seat[] seats);

    public void cancelReservation(Seat[] seats, int seatId);

    public void listSeat(Seat[] seats);

    public void setFlight(Flight flight);

    public Flight getFlight();
}
