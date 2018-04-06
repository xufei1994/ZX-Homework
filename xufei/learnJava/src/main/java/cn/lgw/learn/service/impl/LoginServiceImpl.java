package cn.lgw.learn.service.impl;

import cn.lgw.learn.domain.UserDO;
import cn.lgw.learn.domain.condition.UserCondition;
import cn.lgw.learn.mapper.UserMapper;
import cn.lgw.learn.service.LoginService;
import cn.lgw.learn.vo.LoginUser;
import cn.lgw.learn.util.WebContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;

    @Override
    public LoginUser login(String username, String passport) {
        UserCondition condition = new UserCondition();
        condition.createCriteria()
                .andUsernameEqualTo(username)
                .andPasswordEqualTo(passport);

        List<UserDO> userDOList = userMapper.selectByExample(condition);

        if (userDOList.size() == 0) {
            return null;
        }

        LoginUser loginUser = LoginUser.fromUserDO(userDOList.get(0));

        HttpSession session = WebContext.request.get().getSession();
        session.setAttribute("isLoggedIn", "true");

        session.setAttribute("name", loginUser.getName());
        session.setAttribute("username", loginUser.getUsername());
        session.setAttribute("userId", loginUser.getUserId());

        return loginUser;
    }

    @Override
    public void logout() {
        HttpSession session = WebContext.request.get().getSession();
        session.removeAttribute("isLoggedIn");
    }
}
