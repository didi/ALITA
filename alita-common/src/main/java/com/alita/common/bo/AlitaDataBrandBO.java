package com.alita.common.bo;

import com.alita.common.annotation.MapConfig;
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
public class AlitaDataBrandBO implements Serializable {

    @MapConfig(value = "覆盖率", status = 1, order = 1)
    private String goodStationCoverRate;

    @MapConfig(value = "分子/分母", status = 1, order = 2)
    private String currentGoodStationProportion;

    @MapConfig(value = "渗透率", status = 1, order = 3)
    private String provGoodStationCoverRate;

    @MapConfig(value = "分子/分母", status = 1, order = 4)
    private String futureGoodStationProportion;

    @MapConfig(value = "市场份额")
    private String currentHeatCount;

    @MapConfig(value = "分子/分母")
    private String futureHeatCount;

    @MapConfig(value = "转化率")
    private String currentCoverCount;

    @MapConfig(value = "分子/分母")
    private String futureCoverCount;

}
