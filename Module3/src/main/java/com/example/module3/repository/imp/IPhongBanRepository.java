package com.example.module3.repository.imp;

import com.example.module3.entity.PhongBan;

import java.util.List;

public interface IPhongBanRepository {
    List<PhongBan> findAll();

    PhongBan findByTenPhongBan(String TenPhongBan);
}
