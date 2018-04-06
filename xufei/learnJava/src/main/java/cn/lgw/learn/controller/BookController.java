package cn.lgw.learn.controller;

import cn.lgw.learn.to.resp.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 
 * Created by leiguowei on 2018/1/26
 */
@RestController
@Slf4j
public class BookController {
    public static ThreadLocal<StringBuilder> a=new ThreadLocal<StringBuilder>();

    public static int count =0;
    public static StringBuilder stringBuilder = new StringBuilder();

    @RequestMapping("/aaa")
    public String aaa(HttpSession session, HttpServletRequest request) {
        count++;
        if(session.getAttribute("name")==null){
            session.setAttribute("name","用户名字"+count);
        }

        return (String)session.getAttribute("name")+"</br>当前线程"+Thread.currentThread().getName()+
                "</br>cookie   "+ count;

//        a.set(new StringBuilder());
//        count++;
//        a.get().append(count).append("  ");
//        stringBuilder.append(count).append(" ");
//        return "threadlocal: "+a.get().toString()+"</br>Common:"+stringBuilder.toString()
//                +"</br>当前线程："+Thread.currentThread().getName();

    }
}