package com.alita.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 应用表
 *
 * @author Lydia
 * @since 2020-01-05
 */
@Data
public class AlitaApplicationVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
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
     * 页面
     */
    private List<AlitaPageVO> pages;

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
