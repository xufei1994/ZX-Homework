package cn.lgw.learn.controller;

import cn.lgw.learn.domain.BookDO;
import cn.lgw.learn.mapper.BookMapper;
import cn.lgw.learn.to.resp.RestResponse;
import cn.lgw.learn.util.WebContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by leiguowei on 2018/1/26
 */
@RestController
@Slf4j
public class IndexController {

    @Resource
    BookMapper bookMapper;

    @RequestMapping(value = "/select")   //Rest = http
    public String showIndex(@RequestParam long id) {
        BookDO bookDO = bookMapper.selectByPrimaryKey(id);
        return bookDO+"                                      "
                +"查找成功";

    }


    @RequestMapping(value = "/delete")   //Rest = http
    public String deleteIndex(@RequestParam long id){
        bookMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)   //Rest = http
    public String updateIndex(@RequestBody BookDO bookDO){
        bookMapper.updateByPrimaryKeySelective(bookDO);
        return "修改成功";

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)   //Rest = http
    public String insertIndex(@RequestBody BookDO bookDO){
        log.info("bookDo={}", bookDO.toString());
        bookMapper.insert(bookDO);
        return "插入成功";
    }

    @RequestMapping(value = "/")
    public RestResponse showIndex(HttpSession session,HttpServletResponse response) {
        response.setHeader("refresh", "3;url='http://www.baidu.com'");
        try {
            response.getWriter().write("succes"+ "\n" +"this is index!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return RestResponse.ok("</br>+this is index!");

    }


}