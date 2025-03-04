package com.example.module3.repository.imp;

import com.example.module3.entity.KhenThuong;

import java.util.List;

public interface IKhenThuongRepository {
    List<KhenThuong> findAllKhenThuong();

    void reomve(int Ma);

    void save(KhenThuong khenThuong);

    List<KhenThuong> findByLoai(String loai);

}