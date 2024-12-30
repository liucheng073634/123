package com.heima.domain.po;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 团队信息表
 * </p>
 *
 * @author author
 * @since 2024-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 团队ID
     */

    private Long teamId;

    /**
     * 团队名称
     */
    private String teamName;

    /**
     * 团队负责人
     */
    private String leader;

    /**
     * 团队简介
     */
    private String description;

    /**
     * 成员数量
     */
    private Integer memberCount;

    /**
     * 项目数量
     */
    private Integer projectCount;

    /**
     * 团队状态：active-活跃，inactive-非活跃
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
