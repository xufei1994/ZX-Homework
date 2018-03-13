package cn.xf.learn.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecorderDO {
    /**
     * 无用序列
     */
    private Integer id;

    /**
     * 学生学号
     */
    private Integer rNumber;

    /**
     * 学生姓名
     */
    private Integer rName;

    /**
     * 书名
     */
    private String rBookname;

    /**
     * 借书日期
     */
    private Integer rBorrow;

    /**
     * 还书日期
     */
    private Integer rReturn;

    /**
     * 应还日期
     */
    private Integer rShouldreturn;

    /**
     * 书的唯一码
     */
    private Integer rMac;
}