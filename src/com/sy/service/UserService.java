package com.sy.service;

import com.sy.bean.User;

public interface UserService {
    public void doRegister(User user) throws Exception;
    User doLogin(User parameterUser) throws Exception;
}
