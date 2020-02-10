package com.alita.common.bo;

import lombok.Data;

import java.util.Map;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-07-30 11:01:48
 */
@Data
public class MapDetailBO<T> {

    private MapConfigBO[] config;

    private Map<String, T> payload;

}
