package com.sy.dao;

import org.apache.commons.dbutils.QueryRunner;
import com.sy.utils.JDBCUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BaseDao<T>{
    private QueryRunner queryRunner=new QueryRunner();
    public int update(String sql,Object... params){
        try{
            return queryRunner.update(JDBCUtil.getConnection(),sql,params);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
    public T getBean(Class<T> clazz,String sql,Object... params){
        try{
            return queryRunner.query(JDBCUtil.getConnection(),sql,new BeanHandler<>(clazz),params);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public List<T> getBeanList(Class<T> clazz, String sql, Object... params){
        try {
            return queryRunner.query(JDBCUtil.getConnection(),sql,new BeanListHandler<>(clazz),params);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    }

