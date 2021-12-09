package com.sy.test;

import com.sy.bean.User;
import com.sy.dao.impl.UserDaoImpl;
import org.junit.Test;

import java.sql.SQLException;

public class TestDao {
    @Test
    public void testAddUser() throws SQLException{
//        User user = new User(null,"aobama55","654321", "654321@qq.com");
//        new UserDao().addUser(user);
        UserDaoImpl userDao=new UserDaoImpl();
        User user= userDao.findByUsername("aobama55");
        System.out.println(user);
    }
}
