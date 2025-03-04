package com.example.module3.service.imp;

import com.example.module3.entity.PhongBan;

import java.util.List;

public interface IPhongBanService {
    List<PhongBan> getPhongBanList();

    PhongBan getPhongBan(String TenPhongBan);

}
