package cn.lgw.learn.service;

import cn.lgw.learn.vo.LoginUser;

public interface LoginService {

    LoginUser login(String username, String passport);

    void logout();
}
