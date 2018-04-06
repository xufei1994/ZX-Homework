package cn.lgw.learn.service;

import cn.lgw.learn.domain.UserDO;
import cn.lgw.learn.exception.CommonException;
import cn.lgw.learn.to.req.UserRegisterReq;
import cn.lgw.learn.to.resp.GeneralUserTO;
import com.google.common.base.Strings;

import java.util.List;

public interface UserService {

    UserDO register(UserDO userDO) throws CommonException;

    List<GeneralUserTO> listUsers(int pageNum, int pageSize);

    UserDO updateUserInfo(UserDO userDO);

    UserDO manageUserInfo(List<UserDO> userList);

    UserDO getUserByUsername(String username);

    UserDO getUserByUserId(Long userId);

    UserDO getCurrentUserInfo();

    UserDO getUserInfoByUsername(String username);

    UserDO getUserInfoByUserId(String userId);
}