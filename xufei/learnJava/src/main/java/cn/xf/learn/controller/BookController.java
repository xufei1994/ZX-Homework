package cn.xf.learn.controller;

import cn.xf.learn.domin.BookDO;
import cn.xf.learn.srevice.BookService;
import cn.xf.learn.vo.GetAllBookReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.util.Collections;
import java.util.List;

/**
 * Created by xufei on 18-1-26
 */
@RestController
@Slf4j
public class BookController {
    @Resource
    private BookService bookService;

    @RequestMapping(value = "/book/get/all", method = RequestMethod.POST)
    public List<BookDO> getAllBooks(@RequestBody GetAllBookReq req) {
        log.info("req size={} pageCount={}", req.getPageSize(), req.getMaxPageCount());
        return bookService.getAllBooks(req.getPageSize(), req.getMaxPageCount());
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public List<BookDO> getAllBooksForNet(@RequestParam String name,
                                          @RequestBody String bpody,
                                          HttpServletRequest httpServletRequest,
                                          HttpServletResponse httpServletResponse) {
        return Collections.emptyList();
    }

}