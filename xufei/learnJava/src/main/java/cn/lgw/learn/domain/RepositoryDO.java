package cn.lgw.learn.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryDO {
    /**
     * 自增主键，无意义
     */
    private Long id;

    /**
     * 每本书唯一对应的编号，和书籍编号不同
     */
    private String repoId;

    /**
     * 书籍编号，通过改编号可查询到书籍信息
     */
    private Long bookId;

    /**
     * 书籍状态，0：可被借阅；1：已被借阅；2：丢失；3：损坏；-1：遗弃
     */
    private Byte status;

    /**
     * 位于图书馆的位置，坐标通过“-”进行分割
     */
    private String location;

    /**
     * 购入时间，默认为插入该条记录的时间
     */
    private Date purchaseTime;

    /**
     * 该书购买价格
     */
    private Integer price;
}