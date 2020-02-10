package com.alita.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Lydia
 * @version V1.0
 * @since Thu Dec 05 17:53:14 CST 2019
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlitaDataVO implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;
    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Double longitude;
    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double latitude;

}
