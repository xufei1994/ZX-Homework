package cn.xf.learn.controller;

import cn.xf.learn.domin.BookDO;
import cn.xf.learn.domin.condition.BookCondition;
import cn.xf.learn.mapper.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by xufei on 18-1-26
 */

@RestController
@Slf4j
public class IndexController {

    @Resource
    BookMapper bookMapper;

    @RequestMapping(value = "/select")   //Rest = http
    public String showIndex(@RequestParam int id) {
        BookDO bookDO = bookMapper.selectByPrimaryKey(id);
        return bookDO+"                                      "
         +"查找成功";

    }


    @RequestMapping(value = "/delete")   //Rest = http
    public String deleteIndex(@RequestParam int id){
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
}


