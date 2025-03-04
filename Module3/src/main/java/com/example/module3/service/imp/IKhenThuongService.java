package com.example.module3.service.imp;

import com.example.module3.entity.KhenThuong;

import java.util.List;

public interface IKhenThuongService {
    List<KhenThuong> getKhenThuongList();

    void remove(int Ma);

    void save(KhenThuong khenThuong);

    List<KhenThuong> findByLoai(String loai);

}