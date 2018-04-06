package cn.lgw.learn.service.impl;

import cn.lgw.learn.domain.BookDO;
import cn.lgw.learn.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public List<BookDO> getAllBooks(int pageSize, int maxPageCount) {
        return null;
    }
}
