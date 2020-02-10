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
public class AlitaDataLineBO implements Serializable {

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
     * 出发城市ID
     */
    private Long fromCityId;

    /**
     * 出发地中心经度
     */
    private Double fromLongitude;

    /**
     * 出发地中心纬度
     */
    private Double fromLatitude;

    /**
     * 目的城市ID
     */
    private Long toCityId;

    /**
     * 目的地中心经度
     */
    private Double toLongitude;

    /**
     * 目的地中心纬度
     */
    private Double toLatitude;

    /**
     * 出行距离
     */
    private Double travelDistance;

    /**
     * 线单量
     */
    private Long lineCount;

    /**
     * 控制点经度
     */
    private Double controlLongitude;

    /**
     * 控制点纬度
     */
    private Double controlLatitude;

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
    @MapConfig(value = "修改时间", status = 1)
    private LocalDateTime gmtModified;

}
