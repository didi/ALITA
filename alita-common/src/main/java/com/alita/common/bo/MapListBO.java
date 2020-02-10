package com.alita.common.bo;

import lombok.Data;

import java.util.List;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-07-30 11:01:55
 */
@Data
public class MapListBO<T> {

    private MapListConfigBO config;

    private List<T> list;

}
