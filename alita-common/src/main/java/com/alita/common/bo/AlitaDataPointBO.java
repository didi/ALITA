package com.alita.common.bo;

import com.alita.common.annotation.MapConfig;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Lydia
 * @version V1.0
 * @since Thu Dec 05 17:53:14 CST 2019
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlitaDataPointBO implements Serializable {

    /**
     * 主键ID
     */
    @MapConfig(key = "id", value = "主键ID", status = 1)
    private Long id;

    /**
     * 城市ID
     */
    @MapConfig(key = "id", value = "城市ID", status = 1)
    private Long cityId;

    /**
     * 经度
     */
    @MapConfig(key = "longitude", value = "点经度")
    private Double longitude;

    /**
     * 纬度
     */
    @MapConfig(key = "latitude", value = "点纬度")
    private Double latitude;

    /**
     * 出发城市ID
     */
    private Long fromCityId;

    /**
     * 出发地中心经度
     */
    private Double fromCenterLongitude;

    /**
     * 出发地中心纬度
     */
    private Double fromCenterLatitude;

    /**
     * 出发城市ID
     */
    private Long toCityId;

    /**
     * 出发地中心经度
     */
    private Double toCenterLongitude;

    /**
     * 出发地中心纬度
     */
    private Double toCenterLatitude;

    /**
     * 线单量
     */
    private Long lineCount;

    /**
     * 区块名称
     */
    private String planeName;

    /**
     * 经纬度键值对json
     */
    private String planeJson;

    /**
     * 1-已删除 0-未删除
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @MapConfig(value = "创建时间", status = 1)
    private LocalDateTime gmtCreated;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime gmtModified;

}
