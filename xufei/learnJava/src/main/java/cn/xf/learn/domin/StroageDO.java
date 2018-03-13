package cn.xf.learn.domin;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StroageDO {
    /**
     * 无用序列
     */
    private Long id;

    /**
     * 具体位置
     */
    private String sLocation;

    /**
     * 是否存在
     */
    private Byte sExist;

    /**
     * 书名
     */
    private String sName;

    /**
     * 购买时间
     */
    private Date sDate;
}