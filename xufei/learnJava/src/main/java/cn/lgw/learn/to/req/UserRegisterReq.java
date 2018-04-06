package cn.lgw.learn.to.req;

import lombok.Data;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Data
public class UserRegisterReq {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Content-type","text/html;charset=GBk");
        response.setCharacterEncoding("GBk");
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password=request.getParameter("password");
        String password2 = request.getParameter("password2");
        String stuId = request.getParameter("stuId");//学号
        String sex=request.getParameter("sex");
        String school=request.getParameter("school");//学院
        String phone = request.getParameter("phone"); //电话号
    }

}
