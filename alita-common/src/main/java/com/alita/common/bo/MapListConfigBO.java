package com.alita.common.bo;

import lombok.Builder;
import lombok.Data;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-08-07 15:57:12
 */
@Data
@Builder
public class MapListConfigBO {
    private int[] view;
    private String key;
    private MapConfigBO[] config;
}
