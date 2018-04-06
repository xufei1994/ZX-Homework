package cn.lgw.learn.converter;

import cn.lgw.learn.domain.UserDO;
import cn.lgw.learn.to.req.RegisterFormBean;
import cn.lgw.learn.to.req.UserRegisterReq;
import cn.lgw.learn.to.resp.GeneralUserTO;

public class UserConverter {
    public static UserDO registerReq2do(RegisterFormBean from) {
        UserDO to = new UserDO();

        to.setName(from.getName());
        to.setUsername(from.getUsername());
        to.setPassword(from.getPassword());
        to.setStuId(from.getStuId());
        to.setPhone(from.getPhone());
        if (from.getSex() != null) {
            if (from.getSex().equals("男")){
                to.setSex((byte)0);
            }else {
                to.setSex((byte)1);
            }
        }

        return to;
    }

    public static GeneralUserTO do2generalTo(UserDO from) {
        GeneralUserTO to = new GeneralUserTO();

        to.setUserId(from.getUserId());
        to.setName(from.getName());

        to.setSchool(from.getSchool());
        to.setSex(from.getSex());

        return to;
    }
}
