package com.alita.common.bo;

import lombok.Builder;
import lombok.Data;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-07-30 11:02:58
 */
@Data
@Builder
public class MapConfigBO {

    private String key;
    private String value;
    private Integer status;
    private int[] view;
    private Integer order;
    private MapConfigBO[] config;

}
