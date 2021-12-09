package com.sy.dao.impl;
import com.sy.bean.User;
import com.sy.dao.BaseDao;
import com.sy.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.sy.utils.JDBCUtil;

import java.sql.SQLException;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User findByUsername(String username) throws SQLException {
        String sql = "select user_id userId,user_name username,user_pwd userPwd,email from t_user where user_name=?";
        return (User) getBean(User.class,sql,username);

    }
    @Override
    public void addUser(User user) throws SQLException {
        String sql = "insert into t_user (user_name,user_pwd,email) values (?,?,?)";
        update(sql,user.getUserName(),user.getUserPwd(),user.getEmail());
    }

}
