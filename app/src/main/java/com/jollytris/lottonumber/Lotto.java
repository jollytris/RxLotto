package com.jollytris.lottonumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zic325 on 2017. 4. 10..
 */

public class Lotto {

    /**
     * bnusNo : 41
     * firstWinamnt : 1350104395
     * totSellamnt : 72252889000
     * returnValue : success
     * drwtNo3 : 24
     * drwtNo2 : 14
     * drwtNo1 : 12
     * drwtNo6 : 45
     * drwtNo5 : 34
     * drwtNo4 : 26
     * drwNoDate : 2017-04-08
     * drwNo : 749
     * firstPrzwnerCo : 13
     */

    private int bnusNo;
    private long firstWinamnt;
    private long totSellamnt;
    private String returnValue;
    private int drwtNo3;
    private int drwtNo2;
    private int drwtNo1;
    private int drwtNo6;
    private int drwtNo5;
    private int drwtNo4;
    private String drwNoDate;
    private int drwNo;
    private int firstPrzwnerCo;

    public List<Integer> getDrwtNos() {
        List<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(drwtNo1));
        list.add(Integer.valueOf(drwtNo2));
        list.add(Integer.valueOf(drwtNo3));
        list.add(Integer.valueOf(drwtNo4));
        list.add(Integer.valueOf(drwtNo5));
        list.add(Integer.valueOf(drwtNo6));
        return list;
    }

    public int getBnusNo() {
        return bnusNo;
    }

    public void setBnusNo(int bnusNo) {
        this.bnusNo = bnusNo;
    }

    public long getFirstWinamnt() {
        return firstWinamnt;
    }

    public void setFirstWinamnt(long firstWinamnt) {
        this.firstWinamnt = firstWinamnt;
    }

    public long getTotSellamnt() {
        return totSellamnt;
    }

    public void setTotSellamnt(long totSellamnt) {
        this.totSellamnt = totSellamnt;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public int getDrwtNo3() {
        return drwtNo3;
    }

    public void setDrwtNo3(int drwtNo3) {
        this.drwtNo3 = drwtNo3;
    }

    public int getDrwtNo2() {
        return drwtNo2;
    }

    public void setDrwtNo2(int drwtNo2) {
        this.drwtNo2 = drwtNo2;
    }

    public int getDrwtNo1() {
        return drwtNo1;
    }

    public void setDrwtNo1(int drwtNo1) {
        this.drwtNo1 = drwtNo1;
    }

    public int getDrwtNo6() {
        return drwtNo6;
    }

    public void setDrwtNo6(int drwtNo6) {
        this.drwtNo6 = drwtNo6;
    }

    public int getDrwtNo5() {
        return drwtNo5;
    }

    public void setDrwtNo5(int drwtNo5) {
        this.drwtNo5 = drwtNo5;
    }

    public int getDrwtNo4() {
        return drwtNo4;
    }

    public void setDrwtNo4(int drwtNo4) {
        this.drwtNo4 = drwtNo4;
    }

    public String getDrwNoDate() {
        return drwNoDate;
    }

    public void setDrwNoDate(String drwNoDate) {
        this.drwNoDate = drwNoDate;
    }

    public int getDrwNo() {
        return drwNo;
    }

    public void setDrwNo(int drwNo) {
        this.drwNo = drwNo;
    }

    public int getFirstPrzwnerCo() {
        return firstPrzwnerCo;
    }

    public void setFirstPrzwnerCo(int firstPrzwnerCo) {
        this.firstPrzwnerCo = firstPrzwnerCo;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "drwNo=" + drwNo +
                ", drwtNo1=" + drwtNo1 +
                ", drwtNo2=" + drwtNo2 +
                ", drwtNo3=" + drwtNo3 +
                ", drwtNo4=" + drwtNo4 +
                ", drwtNo5=" + drwtNo5 +
                ", drwtNo6=" + drwtNo6 +
                ", bnusNo=" + bnusNo +
                ", drwNoDate='" + drwNoDate + '\'' +
                '}';
    }
}
