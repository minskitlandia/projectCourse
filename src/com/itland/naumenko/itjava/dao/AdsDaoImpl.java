package com.itland.naumenko.itjava.dao;

import com.itland.naumenko.itjava.model.Ads;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdsDaoImpl implements AdsDao {

    private static final String SELECT_ALL_ADS = "SELECT * FROM Ads";

    @Override
    public void insert(Ads user) {

    }

    @Override
    public boolean update(Ads user) {
        return false;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Ads> getAllAds() {
        List<Ads> list = new ArrayList<>();
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADS)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(Ads.builder()
                        .id(resultSet.getInt(1))
                        .title(resultSet.getString(2))
                        .subtitle(resultSet.getString(3))
                        .description(resultSet.getString(4))
                        .price(resultSet.getDouble(5))
                        .userId(resultSet.getInt(6))
                        .build());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Ads getAds(int id) {
        return null;
    }
}
