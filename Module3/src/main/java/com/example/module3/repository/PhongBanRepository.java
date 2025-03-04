package com.example.module3.repository;

import com.example.module3.entity.PhongBan;
import com.example.module3.repository.imp.IPhongBanRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongBanRepository implements IPhongBanRepository {
    private final String SELECT_PHONGBAN = "SELECT * FROM phongban";
    private final String SELECT_TENPHONGBAN = "SELECT * FROM PhongBan WHERE TenPhongBan = ?";

    @Override
    public List<PhongBan> findAll() {
        Connection connection = BaseRepository.getConnection();
        List<PhongBan> phongBans = new ArrayList<PhongBan>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_PHONGBAN);
            while (resultSet.next()) {
                int MaPhongBan = resultSet.getInt("MaPhongBan");
                String TenPhongBan = resultSet.getString("TenPhongBan");
                PhongBan phongBan = new PhongBan(MaPhongBan, TenPhongBan);
                phongBans.add(phongBan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongBans;
    }

    @Override
    public PhongBan findByTenPhongBan(String TenPhongBan) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TENPHONGBAN);
        ) {
            preparedStatement.setString(1, TenPhongBan);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String NamePhongBan = resultSet.getString("tenphongban");
                int MaPhongBan = resultSet.getInt("maphongban");
                PhongBan phongBan = new PhongBan(MaPhongBan, TenPhongBan);
                return phongBan;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
