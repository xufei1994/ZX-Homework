package cn.lgw.learn.vo;

import cn.lgw.learn.domain.UserDO;
import lombok.Data;

@Data
public class LoginUser {
    private String username;
    private String name;
    private Long userId;

    public static LoginUser fromUserDO(UserDO userDO) {
        if (userDO == null) {
            return null;
        }

        LoginUser loginUser = new LoginUser();
        loginUser.setName(userDO.getName());
        loginUser.setUserId(userDO.getUserId());
        loginUser.setUsername(userDO.getUsername());
        return loginUser;
    }
}
