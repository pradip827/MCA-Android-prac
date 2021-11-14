package com.imcostmca.wmtpracticals;

public class Employee {

    int nID;
    String sEmployeeName;

    public int getnID() {
        return nID;
    }

    public void setnID(int nID) {
        this.nID = nID;
    }

    public String getsEmployeeName() {
        return sEmployeeName;
    }

    public void setsEmployeeName(String sEmployeeName) {
        this.sEmployeeName = sEmployeeName;
    }

    public Employee(int nID, String sEmployeeName) {
        this.nID = nID;
        this.sEmployeeName = sEmployeeName;
    }

    public Employee(String sEmployeeName) {
        this.sEmployeeName = sEmployeeName;
    }

    public Employee(){

    }
}
