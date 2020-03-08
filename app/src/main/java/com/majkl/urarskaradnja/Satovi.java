package com.majkl.urarskaradnja;

public class Satovi {

    private int satID;
    private String nazivSata;

    public Satovi() {
    }

    public Satovi(int satID, String nazivSata) {
        this.satID = satID;
        this.nazivSata = nazivSata;
    }

    public int getSatID() {
        return satID;
    }

    public void setSatID(int satID) {
        this.satID = satID;
    }

    public String getNazivSata() {
        return nazivSata;
    }

    public void setNazivSata(String nazivSata) {
        this.nazivSata = nazivSata;
    }
}
