package com.alita.service;

import com.alita.common.bo.MapDetailBO;
import com.alita.common.bo.MapListBO;
import com.alita.common.dto.MapBaseDTO;

/**
 * @author Lydia
 * @version V1.0
 * @since Thu Dec 05 17:53:14 CST 2019
 */
public interface AlitaDataService {

    MapListBO listPoint(MapBaseDTO mapBaseDTO);

    MapListBO listLine(MapBaseDTO mapBaseDTO);

    MapListBO listPlane(MapBaseDTO mapBaseDTO);

    MapDetailBO getBrand();

    MapListBO listSelect();

}
