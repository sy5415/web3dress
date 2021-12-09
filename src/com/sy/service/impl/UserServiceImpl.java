package com.sy.service.impl;

import com.sy.bean.User;
import com.sy.dao.UserDao;
import com.sy.dao.impl.UserDaoImpl;
import com.sy.service.UserService;
import com.sy.utils.MD5Util;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public void doRegister(User user) throws Exception{
        //注册前需要验证数据库
        User exisUser=userDao.findByUsername(user.getUserName());
        if(exisUser!=null){
            throw new RuntimeException("已经存在");
        }
        //MD5加密密码
        String oldUserPwd= user.getUserPwd();
        String encodePwd= MD5Util.encode(oldUserPwd);
        user.setUserPwd(encodePwd);
        userDao.addUser(user);
    }

    @Override
    public User doLogin(User parameterUser) throws Exception {
       User loginUser= userDao.findByUsername(parameterUser.getUserName());
        if (loginUser !=null) {
            //parameterUser是用户输入的密码,我们对其进行MD5加密完后跟loginUser中的密码进行比对
            String oldpwdparameterUser=parameterUser.getUserPwd();
            String newpwd=MD5Util.encode(oldpwdparameterUser);
            if(newpwd.equals(loginUser.getUserPwd())){
                return loginUser;
            }else {
                throw new RuntimeException("密码错误");
            }
        }else {
            throw new RuntimeException("用户名错误");
        }
    }
}
