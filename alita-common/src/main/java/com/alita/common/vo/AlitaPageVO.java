package com.alita.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 页面表
 *
 * @author Lydia
 * @since 2020-01-05
 */
@Data
public class AlitaPageVO implements Serializable {

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
     * 应用ID
     */
    private Long appId;

    /**
     * 应用唯一作用域
     */
    private String appScope;

    /**
     * 页面路由地址
     */
    private String routeUrl;

    /**
     * 页面配置数据
     */
    private String pageProps;

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
        return "AlitaPage{" +
                "id=" + id +
                ", name=" + name +
                ", appId=" + appId +
                ", appScope=" + appScope +
                ", routeUrl=" + routeUrl +
                ", pageProps=" + pageProps +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
