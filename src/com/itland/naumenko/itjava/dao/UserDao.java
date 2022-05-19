package com.itland.naumenko.itjava.dao;

import com.itland.naumenko.itjava.model.User;

import java.util.List;

public interface UserDao {
    void insert(User user);
    boolean update(User user);
    void delete(int id);
    List<User> getUsers();
    User read(int id);
}
