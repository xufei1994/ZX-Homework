package cn.lgw.learn.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDO {
    /**
     * 自增ID，无意义
     */
    private Long id;

    /**
     * 书记名称
     */
    private String name;

    /**
     * 书籍编号
     */
    private String sn;

    /**
     * 书籍作者
     */
    private String author;

    /**
     * 书籍简介
     */
    private String intro;

    /**
     * 书籍分类
     */
    private String category;

    /**
     * 可借数量
     */
    private Integer account;
}