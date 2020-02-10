package com.alita.common.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-08-09 10:44:36
 */
@Data
@Builder
public class MapDetailVO<T> {

    private MapConfigVO[] config;

    private T payload;

}
