package com.example.myapplication;

public class login {
    int Id ;
    String taikhoan,pass;

    public login(int id, String taikhoan, String pass) {

        Id = id;
        this.taikhoan = taikhoan;
        this.pass = pass;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
