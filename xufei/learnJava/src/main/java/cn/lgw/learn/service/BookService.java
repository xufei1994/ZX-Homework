package cn.lgw.learn.service;

import cn.lgw.learn.domain.BookDO;

import java.util.List;

/**
 * 
 * Created by leiguowei on 2018/1/26
 */
public interface BookService {

    List<BookDO> getAllBooks(int pageSize, int maxPageCount);
}