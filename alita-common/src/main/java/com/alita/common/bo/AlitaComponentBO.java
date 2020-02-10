package com.alita.common.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 组件配置表
 *
 * @author Lydia
 * @since 2020-01-05
 */
@Data
public class AlitaComponentBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 组件配置数据
     */
    private String componentProps;

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
        return "AlitaComponent{" +
                "id=" + id +
                ", name=" + name +
                ", componentProps=" + componentProps +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
