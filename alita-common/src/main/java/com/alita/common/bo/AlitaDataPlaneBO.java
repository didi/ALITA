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
public class AlitaDataPlaneBO implements Serializable {

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

    @MapConfig(key = "planeName", value = "区块名称", status = 1)
    private String planeName;

    @MapConfig(key = "plane")
    private Double[][] plane;

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
