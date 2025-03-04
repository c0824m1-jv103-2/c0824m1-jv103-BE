package com.example.module3.service;

import com.example.module3.entity.NhanVien;
import com.example.module3.repository.NhanVienRepository;
import com.example.module3.repository.imp.INhanVienRepository;
import com.example.module3.service.imp.INhanVienService;

import java.util.List;

public class NhanVienService implements INhanVienService {
    private final NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVien> getNhanVien(String TenPhongBan) {
        return nhanVienRepository.findAllNhanVien(TenPhongBan);
    }

    @Override
    public void deleteNhanVien(int MaNV) {
        nhanVienRepository.deleteNhanVien(MaNV);
    }

    @Override
    public void createNhanVien(NhanVien nhanVien) {
        nhanVienRepository.createNhanVien(nhanVien);
    }

    @Override
    public NhanVien updateNhanVien(int MaNV) {
        return nhanVienRepository.updateNhanVien(MaNV);
    }

    @Override
    public void update(NhanVien NhanVien) {
        nhanVienRepository.update(NhanVien);
    }

    @Override
    public List<NhanVien> findAllMaNV() {
        return nhanVienRepository.findAllMaNV();
    }
}
