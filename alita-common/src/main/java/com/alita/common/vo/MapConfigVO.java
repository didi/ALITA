package com.alita.common.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-07-30 14:34:55
 */
@Data
@Builder
public class MapConfigVO {

    private String key;
    private String value;
    private Integer status;
    private int[] view;
    private MapConfigVO[] config;

}
