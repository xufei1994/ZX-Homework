package cn.lgw.learn.controller;

import cn.lgw.learn.exception.CommonException;
import cn.lgw.learn.mapper.UserMapper;
import cn.lgw.learn.service.LoginService;
import cn.lgw.learn.to.req.LoginReq;
import cn.lgw.learn.to.resp.RestResponse;
import lombok.extern.log4j.Log4j;
import org.eclipse.jetty.server.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Log4j
public class LoginController {

    @Resource
    private LoginService loginService;
    UserMapper userMapper;

    @RequestMapping("/login")
    public RestResponse login(LoginReq req) throws CommonException{
        return RestResponse.ok(loginService.login(req.getUsername(), req.getPassport()));
    }

    @RequestMapping("/logout")
    public RestResponse logout() {
        loginService.logout();
        return RestResponse.ok();
    }
}
