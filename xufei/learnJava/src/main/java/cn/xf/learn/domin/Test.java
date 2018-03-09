package cn.xf.learn.domin;

import cn.xf.learn.domin.newHomework.SpringTest;
import cn.xf.learn.domin.newHomework.TotalDataMethod;

import java.io.IOException;
import java.sql.*;

/**
 * Created by xufei on 18-1-24
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String URL = "jdbc:mysql://127.0.0.1:3306/library?" +
                "useUnicode=true&useSSL=false";
        String USER = "root";
        String PASSWORD = "1";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *FROM book ");
        //4.处理数据库的返回结果（使用ResultSet类）
        System.out.println("id" + "\t" + "   " +
                "  " + "name" + "\t" +
                " " + "author" + "\t" +
                " " + "catalogue" + "\t" +
                " " + "introduction" + "\t");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + "\t" + "" +
                    " " + resultSet.getString("name") + "\t" +
                    " " + resultSet.getString("author") + "\t" +
                    " " + resultSet.getString("catalogue") + "\t" +
                    " " + resultSet.getString("introduction") + "\t");

        }
        TotalDataMethod totalDataMethod= new TotalDataMethod();
        System.out.println("我已执行");


        //关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }


}

