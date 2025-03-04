package com.example.module3.service;

import com.example.module3.entity.KhenThuong;
import com.example.module3.repository.KhenThuongRepository;
import com.example.module3.service.imp.IKhenThuongService;

import java.util.List;

public class KhenThuongService implements IKhenThuongService {
    private final KhenThuongRepository khenThuongRepository = new KhenThuongRepository();

    @Override
    public List<KhenThuong> getKhenThuongList() {
        return khenThuongRepository.findAllKhenThuong();
    }

    @Override
    public void remove(int Ma) {
        khenThuongRepository.reomve(Ma);
    }

    @Override
    public void save(KhenThuong khenThuong) {
        khenThuongRepository.save(khenThuong);
    }

    @Override
    public List<KhenThuong> findByLoai(String loai) {
        return khenThuongRepository.findByLoai(loai);
    }
}