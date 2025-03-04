package com.example.module3.repository.imp;

import com.example.module3.entity.NhanVien;

import java.util.List;

public interface INhanVienRepository {
    List<NhanVien> findAllNhanVien(String TenPhongBan);

    void deleteNhanVien(int MaNV);

    void createNhanVien(NhanVien nhanVien);

    NhanVien updateNhanVien(int MaNV);

    void update(NhanVien nhanVien);

    List<NhanVien> findAllMaNV();
}
