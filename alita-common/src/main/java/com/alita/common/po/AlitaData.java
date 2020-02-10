package com.alita.common.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-11-18 16:34:18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlitaData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 城市ID
     */
    private Long cityId;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

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
     * 出发城市ID
     */
    private Long toCityId;

    /**
     * 出发地中心经度
     */
    private Double toLongitude;

    /**
     * 出发地中心纬度
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
    private LocalDateTime gmtCreated;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

}
