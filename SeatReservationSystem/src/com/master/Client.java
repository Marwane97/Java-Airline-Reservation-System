package com.master;

public class Client {
    private int seatId;
    private String fullName;
    private String phone;


    public  Client(){ }
    public Client(String fullName, String phone, int id,int seatId) {
        this.fullName = fullName;
        this.phone = phone;
        this.seatId = seatId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
