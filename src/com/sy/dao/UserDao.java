package com.sy.dao;

import com.sy.bean.User;

import java.sql.SQLException;

public interface UserDao {
    User findByUsername(String username) throws SQLException;

    void addUser(User user) throws Exception;
}
