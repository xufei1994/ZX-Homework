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
public class BorrowRecordDO {
    /**
     * 借阅信息的ID
     */
    private Long id;

    /**
     * 借阅人的用户ID
     */
    private String userId;

    /**
     * 书籍的仓储ID
     */
    private String bookRepoId;

    /**
     * 借阅时间
     */
    private Date borrowTime;

    /**
     * 应还时间
     */
    private Date needReturnTime;

    /**
     * 归还时间
     */
    private Date returnTime;
}