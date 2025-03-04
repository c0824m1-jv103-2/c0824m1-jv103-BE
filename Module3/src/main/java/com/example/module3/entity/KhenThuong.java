package com.example.module3.entity;

import java.time.LocalDate;

public class KhenThuong {
    private Integer Ma;
    private String Loai;
    private float SoTien;
    private String LyDo;
    private LocalDate Ngay;

    private String soTienFormatted;
    private String ngayFormatted;

    public KhenThuong() {
    }

    public KhenThuong(Integer ma, String loai, float soTien, String lyDo, LocalDate ngay) {
        this.Ma = ma;
        this.Loai = loai;
        this.SoTien = soTien;
        this.LyDo = lyDo;
        this.Ngay = ngay;
    }

    public Integer getMa() {
        return Ma;
    }

    public void setMa(Integer ma) {
        Ma = ma;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    public float getSoTien() {
        return SoTien;
    }

    public void setSoTien(float soTien) {
        SoTien = soTien;
    }

    public String getLyDo() {
        return LyDo;
    }

    public void setLyDo(String lyDo) {
        LyDo = lyDo;
    }

    public LocalDate getNgay() {
        return Ngay;
    }

    public void setNgay(LocalDate ngay) {
        Ngay = ngay;
    }
    public String getSoTienFormatted() {
        return soTienFormatted;
    }

    public void setSoTienFormatted(String soTienFormatted) {
        this.soTienFormatted = soTienFormatted;
    }

    public String getNgayFormatted() {
        return ngayFormatted;
    }

    public void setNgayFormatted(String ngayFormatted) {
        this.ngayFormatted = ngayFormatted;
    }
}