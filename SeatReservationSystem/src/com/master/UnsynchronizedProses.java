package com.master;

public class UnsynchronizedProses implements Process {
    private Flight flight;

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public void queryReservation(Seat[] seats) {
        try {
            Thread.sleep(2500);
            System.out.println("\nqueryReservation : Flight " + flight.getFlightName() + "\n");
            listSeat(seats);
            System.out.println("**************************************************************" +
                    "****************************************");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void makeReservation(Client client, Seat[] seats) {
        try {
            String[] myName = client.getFullName().split("\\s");
            if (seats[client.getSeatId()].isAvailable()) {
                Thread.sleep(2000);
                seats[client.getSeatId()].setAvailable(false);
                seats[client.getSeatId()].setClientName(myName[0]);
                printMakeSuccess(client, seats, myName[0]);
            } else {
                printMakeUnSuccess(client, seats, myName[0]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void cancelReservation(Seat[] seats, int seatId) {
        try {
            if (!seats[seatId].isAvailable()) {// if the seat if not empty then return true
                Thread.sleep(3000);
                seats[seatId].setAvailable(true);
                seats[seatId].setClientName("Empty");
                cancelReservationSuccess(seats, seatId);
            } else {
                cancelReservationUnSuccess(seats, seatId);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listSeat(Seat[] seats) {
        System.out.println("Seats\t\tProperty\t\tAvailable\t\tName");
        for (int i = 0; i < seats.length; i++) {
            System.out.println((seats[i].getSeatId() + 1) + "\t\t    " + seats[i].getProperty() + "\t\t" + seats[i].isAvailable() + "\t\t    [" + seats[i].getClientName() + "]");
        }
    }

    public synchronized void printMakeSuccess(Client client, Seat[] seats, String name) {
        System.out.println("\nmakeReservation : Flight " + flight.getFlightName() + " [ " + name + " | " + (client.getSeatId() + 1) + " ]");

        System.out.println("Hi  " + client.getFullName() + " Your reservation for '" + flight.getFlightName() + "' has been completed. Your seat number is " + (client.getSeatId() + 1) + ": [ " + name + " | " + (client.getSeatId() + 1) + " ]");
        System.out.println("Thank you for having chosen us...");
        System.out.println("******************************************************************************************************");
    }

    public synchronized void printMakeUnSuccess(Client client, Seat[] seats, String name) {
        System.out.println("\nmakeReservation : Flight " + flight.getFlightName() + " [ " + name + " | " + (client.getSeatId() + 1) + " ]");
        System.out.println("The Seat " + (client.getSeatId() + 1) + " has already been booked by someone [" + seats[client.getSeatId()].getClientName() + "]...");
        System.out.println("******************************************************************************************************");
    }

    public synchronized void cancelReservationSuccess(Seat[] seats, int seatId) {
        System.out.println("\ncancelReservation : Flight " + flight.getFlightName() + " [ " + seats[seatId].getClientName() + " | " + (seatId + 1) + " ]");
        System.out.println("Your cancellation is complete. We hope you visit us again...");
        System.out.println("******************************************************************************************************");
    }


    public synchronized void cancelReservationUnSuccess(Seat[] seats, int seatId) {
        System.out.println("\ncancelReservation : Flight " + flight.getFlightName() + " [ " + seats[seatId].getClientName() + " | " + (seatId + 1) + " ]");
        System.out.println("Sorry you haven't any reservation ...");
        System.out.println("******************************************************************************************************");
    }

}
