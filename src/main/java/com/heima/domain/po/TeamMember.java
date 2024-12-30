package com.heima.domain.po;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 团队成员表
 * </p>
 *
 * @author author
 * @since 2024-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class TeamMember implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成员ID
     */

    private Long memberId;

    /**
     * 团队ID
     */
    private Long teamId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 成员姓名
     */
    private String memberName;

    /**
     * 角色：leader-负责人，member-成员
     */
    private String role;

    /**
     * 加入时间
     */
    private LocalDateTime joinTime;

    /**
     * 状态：active-在职，inactive-离职
     */
    private String status;


}
