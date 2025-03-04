package com.example.module3.entity;


import jdk.vm.ci.meta.Local;

import java.time.LocalDate;

public class NhanVien {
    private int MaNV;
    private String HoTen;
    private LocalDate NgaySinh;
    private String GioiTinh;
    private String ChucVu;
    private String Email;
    private String CCCD;
    private PhongBan phongBan;

    private String ngayFormatted;

    public NhanVien(int maNV, String HoTen) {
        this.MaNV = maNV;
        this.HoTen = HoTen;
    }

    public NhanVien(int MaNV, String HoTen, LocalDate NgaySinh, String GioiTinh, String ChucVu, String Email, String CCCD, PhongBan phongBan) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.ChucVu = ChucVu;
        this.Email = Email;
        this.CCCD = CCCD;
        this.phongBan = phongBan;
    }

    public NhanVien(String HoTen, LocalDate NgaySinh, String GioiTinh, String ChucVu, String Email, String CCCD, PhongBan phongBan) {
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.ChucVu = ChucVu;
        this.Email = Email;
        this.CCCD = CCCD;
        this.phongBan = phongBan;
    }

    public NhanVien(int MaNV, String HoTen, LocalDate NgaySinh, String GioiTinh, String ChucVu, String Email, String CCCD) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.ChucVu = ChucVu;
        this.Email = Email;
        this.CCCD = CCCD;
    }


    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongban) {
        phongBan = phongban;
    }

    public String getNgayFormatted() {
        return ngayFormatted;
    }

    public void setNgayFormatted(String ngayFormatted) {
        this.ngayFormatted = ngayFormatted;
    }
}
