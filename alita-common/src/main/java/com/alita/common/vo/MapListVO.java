package com.alita.common.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-07-30 14:34:44
 */
@Data
@Builder
public class MapListVO<T> {

    private MapListConfigVO config;

    private List<T> payload;

}
