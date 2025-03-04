package com.example.module3.entity;

public class PhongBan {
    private int MaPhongBan;
    private String TenPhongBan;

    public PhongBan() {

    }

    public PhongBan(int MaPhongBan, String TenPhongBan) {
        this.MaPhongBan = MaPhongBan;
        this.TenPhongBan = TenPhongBan;
    }

    public PhongBan(String TenPhongBan) {
        this.TenPhongBan = TenPhongBan;
    }

    public int getMaPhongBan() {
        return MaPhongBan;
    }

    public void setMaPhongBan(int maPhongBan) {
        MaPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return TenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        TenPhongBan = tenPhongBan;
    }
}
