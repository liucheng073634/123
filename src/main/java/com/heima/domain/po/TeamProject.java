package com.heima.domain.po;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 团队项目关联表
 * </p>
 *
 * @author author
 * @since 2024-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class TeamProject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关联ID
     */

    private Long id;

    /**
     * 团队ID
     */
    private Long teamId;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 开始日期
     */
    private LocalDate startDate;

    /**
     * 结束日期
     */
    private LocalDate endDate;

    /**
     * 状态：pending-未开始，ongoing-进行中，completed-已完成
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
