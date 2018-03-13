package cn.xf.learn.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDO {
    /**
     * 无用序列号
     */
    private Integer id;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 学生学号
     */
    private Integer stuNumber;

    /**
     * 学生年龄
     */
    private Integer stuAge;

    /**
     * 学生性别
     */
    private String stuSex;

    /**
     * 学生类别
     */
    private Byte stuType;

    /**
     * 联系电话
     */
    private Integer stuTel;

    /**
     * 借书数量
     */
    private Byte stuBook;

    /**
     * 不良记录
     */
    private String stuFine;
}