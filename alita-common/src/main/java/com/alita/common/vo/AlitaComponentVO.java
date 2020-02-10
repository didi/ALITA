package com.alita.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 组件配置表
 *
 * @author Lydia
 * @since 2020-01-05
 */
@Data
public class AlitaComponentVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
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
