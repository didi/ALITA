package com.alita.common.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 应用表
 *
 * @author Lydia
 * @since 2020-01-05
 */
@Data
public class AlitaApplication implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 应用唯一作用域
     */
    private String scope;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态(1-有效 0-无效)
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "AlitaApplication{" +
                "id=" + id +
                ", scope=" + scope +
                ", name=" + name +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
