package com.itland.naumenko.itjava.dao;

import com.itland.naumenko.itjava.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String INSERT_USER = "INSERT INTO User(name, password) VALUES (?,?)";
    private static final String SELECT_USER = "SELECT * FROM User WHERE id = ?";
    private static final String UPDATE_USER = "UPDATE User SET name=?, password=? WHERE id = ?";
    private static final String DELETE_USER = "DELETE FROM User WHERE id = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM User";


    @Override
    public void insert(User user) {
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean update(User user) {
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);
                users.add(new User(id, login, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User read(int id) {
        User user = null;
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);
                user = new User(id, login, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
