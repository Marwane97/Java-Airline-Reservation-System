package com.master;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SynchronizedMain {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock myReaderWriterLock = new ReentrantReadWriteLock();
        final SynchronizedProses process = new SynchronizedProses(myReaderWriterLock);
        Seat[] seats;
        Flight flight = new Flight(" Samsun - Istambul ", 10);

        System.out.println("\n--> The seat state (1 to 10) : Available");
        System.out.println("\t'true' ---> The seat is not yet reserved \n\t'false' ---> The seat is reserved");
        System.out.println("--> Name");
        System.out.println("\tThe person who reserve the seat\n\tIf seat available is 'true' that means that the name value will be 'Empty' ");

        System.out.println("*****************************************************************************\n");

        process.setFlight(flight);

        seats = flight.getSeats();


        Reader[] readers = new Reader[3];
        Writer[] writers = new Writer[7];
        Thread[] readerThreads = new Thread[readers.length];
        Thread[] writerThreads = new Thread[writers.length];
        /****/
        Client[] clients = new Client[writerThreads.length];
        Random rand = new Random();
        int seat = 3;
        for (int i = 0; i < clients.length; i++) {
            if (i > 3) { // Make sure that 3 client trie to reserve the same seat (3)
                seat = rand.nextInt(flight.getSize());
            }
            clients[i] = new Client();
            clients[i].setSeatId(seat);
        }
        clients[0].setFullName("Marwane Tchassama");
        clients[1].setFullName("Master Big");
        clients[2].setFullName("Tro Gil");
        clients[3].setFullName("Kitien Yam");
        clients[4].setFullName("Mah Nad");
        clients[5].setFullName("Esra Al");
        clients[6].setFullName("Kaplan Dem");

        //
        for (int i = 0; i < readerThreads.length; i++) {
            readers[i] = new Reader(process,seats);
            readerThreads[i] = new Thread(readers[i]);
        }
        for (int i = 0; i < writerThreads.length; i++) {
            writers[i] = new Writer(process,clients[i],seats);
            writerThreads[i] = new Thread(writers[i]);
        }

        for (int i = 0; i < readerThreads.length-1; i++) {
            readerThreads[i].start();
        }
        for (int i = 0; i < writerThreads.length; i++) {
            writerThreads[i].start();
        }
        for (int i = 0; i < readerThreads.length-1; i++) {
            readerThreads[i].join();
        }
        for (int i = 0; i < writerThreads.length; i++) {
            writerThreads[i].join();
        }

        // Make one queryReservation to see the seats's states
        for (int i = readerThreads.length-1; i < readerThreads.length; i++) {
            readerThreads[i].start();
        }
        for (int i = readerThreads.length-1; i < readerThreads.length; i++) {
            readerThreads[i].join();
        }
    }
}
