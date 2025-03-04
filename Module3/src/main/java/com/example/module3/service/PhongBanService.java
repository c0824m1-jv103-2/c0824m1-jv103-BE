package com.example.module3.service;

import com.example.module3.entity.PhongBan;
import com.example.module3.repository.PhongBanRepository;
import com.example.module3.repository.imp.IPhongBanRepository;
import com.example.module3.service.imp.IPhongBanService;

import java.util.List;

public class PhongBanService implements IPhongBanService {
    private final IPhongBanRepository phongBanRepository = new PhongBanRepository();

    @Override
    public List<PhongBan> getPhongBanList() {
        return phongBanRepository.findAll();
    }
    @Override
    public PhongBan getPhongBan (String TenPhongBan) {
        return phongBanRepository.findByTenPhongBan(TenPhongBan);
    }
}
