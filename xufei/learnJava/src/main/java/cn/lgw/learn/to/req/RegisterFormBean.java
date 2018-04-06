package cn.lgw.learn.to.req;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xufei on 18-4-3
 */
public class RegisterFormBean extends UserRegisterReq {
    private String name;
    private String username;
    private String password;
    private String password2;
    private String stuId;
    private String sex;
    private String school;
    private String phone;
    private Map<String,String>errors=new HashMap<String, String>();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean vaildate(){
        boolean flag = true;
        if(name==null||name.trim().equals(""));{
            errors.put("name","请输入姓名");
            flag = false;
        }

        if(password==null||password.trim().equals(""));{
            errors.put("password","请输入密码");
            flag = false;
        }if (password.length()>16||password.length()<6){
            errors.put("password","请输入6-16个字符");
            flag =false;
        }
        if (password != null && password.equals(password2)){
            errors.put("password","两次输入密码不匹配");
            flag = false;

        }
        if (stuId == null ||stuId.equals("")){
            errors.put("stuId","请输入学号");
            flag = false;
        }else if (!stuId.matches("[0-9]")){
            errors.put("stuId","学号由数字组成");
            flag =false;
        }
        return  flag;
    }

    //向map集合errors中添加错误信息
    public void setErrorsMsg(String err,String errMsg){
        if ((err!=null)&&(errMsg!=null)){
            errors.put(err,errMsg);
        }
    }

    //获取errors集合
    public Map<String,String>getErrors(){
        return errors;
    }

}
