package com.alita.common.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-08-07 15:54:51
 */
@Data
@Builder
public class MapListConfigVO {
    private int[] view;
    private MapConfigVO[] config;
}
