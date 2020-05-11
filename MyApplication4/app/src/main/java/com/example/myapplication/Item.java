package com.example.myapplication;

public class Item {
        int id,gia;
        int time;
        String thongtin;

    public Item(int id, int gia, int time, String thongtin) {
        this.id = id;
        this.gia = gia;
        this.time = time;
        this.thongtin = thongtin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }
}
