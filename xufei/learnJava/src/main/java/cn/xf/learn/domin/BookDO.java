package cn.xf.learn.domin;

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
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String author;

    /**
     * 
     */
    private String catalogue;

    /**
     * 
     */
    private String introduction;

    /**
     * 
     */
    private Integer mac;
}