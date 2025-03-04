package com.example.module3.repository;

import com.example.module3.entity.KhenThuong;
import com.example.module3.repository.imp.IKhenThuongRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KhenThuongRepository implements IKhenThuongRepository {


    @Override
    public List<KhenThuong> findAllKhenThuong() {
        List<KhenThuong> khenThuongs = new ArrayList<>();
        try(Statement statement = BaseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from khenthuongphat"))
        {
            while (resultSet.next()) {
                int MaNV = resultSet.getInt("Ma");
                String Loai = resultSet.getString("Loai");
                float SoTien = resultSet.getFloat("SoTien");
                String LyDo = resultSet.getString("LyDo");
                LocalDate Ngay = resultSet.getDate("Ngay").toLocalDate();
                khenThuongs.add(new KhenThuong(MaNV, Loai, SoTien, LyDo, Ngay));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return khenThuongs;
    }

    @Override
    public void reomve(int Ma) {
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement("delete from khenthuongphat where Ma = ?"))
        {
            statement.setInt(1, Ma);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(KhenThuong khenThuong) {
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement("insert into khenthuongphat(Ma, Loai, SoTien,LyDo,Ngay) values (?,?,?,?,?)"))
        {
            statement.setInt(1, khenThuong.getMa());
            statement.setString(2, khenThuong.getLoai());
            statement.setFloat(3, khenThuong.getSoTien());
            statement.setString(4, khenThuong.getLyDo());
            statement.setDate(5, java.sql.Date.valueOf(khenThuong.getNgay()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<KhenThuong> findByLoai(String loai) {
        List<KhenThuong> khenThuongs = new ArrayList<>();
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement("select  * from khenthuongphat where loai = ?");)
        {
            statement.setString(1, loai);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int MaNV = resultSet.getInt("Ma");
                String Loai = resultSet.getString("Loai");
                float SoTien = resultSet.getFloat("SoTien");
                String LyDo = resultSet.getString("LyDo");
                LocalDate Ngay = resultSet.getDate("Ngay").toLocalDate();
                khenThuongs.add(new KhenThuong(MaNV, Loai, SoTien, LyDo, Ngay));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return khenThuongs;
    }
}