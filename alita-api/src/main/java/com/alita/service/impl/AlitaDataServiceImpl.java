package com.alita.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alita.common.annotation.MapMethodConfig;
import com.alita.common.bo.*;
import com.alita.common.dto.MapBaseDTO;
import com.alita.common.po.AlitaData;
import com.alita.common.util.ConverterUtil;
import com.alita.common.util.LatLngUtil;
import com.alita.mysql.mapper.AlitaDataMapper;
import com.alita.service.AlitaDataService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Lydia
 * @version V1.0
 * @since Thu Dec 05 17:53:14 CST 2019
 */
@Service
@Slf4j
public class AlitaDataServiceImpl implements AlitaDataService {

    @Autowired
    private AlitaDataMapper alitaDataMapper;

    @Override
    @MapMethodConfig(view = {1, 1, 1}, clazz = AlitaDataPointBO.class)
    public MapListBO listPoint(MapBaseDTO mapBaseDTO) {
        AlitaData alitaData = ConverterUtil.converter(mapBaseDTO, AlitaData.builder().build());
        QueryWrapper<AlitaData> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(alitaData);
        queryWrapper.lambda().eq(AlitaData::getIsDeleted, 0);
        List<AlitaData> alitaDataList = alitaDataMapper.selectList(queryWrapper);
        List<AlitaDataPointBO> alitaDataBOList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(alitaDataList)) {
            alitaDataBOList = alitaDataList.stream().map(po -> {
                AlitaDataPointBO bo = new AlitaDataPointBO();
                BeanUtils.copyProperties(po, bo);
                return bo;
            }).collect(Collectors.toList());
        }
        MapListBO<AlitaDataPointBO> mapListBO = new MapListBO<>();
        mapListBO.setList(alitaDataBOList);
        return mapListBO;
    }

    @Override
    @MapMethodConfig(view = {1, 2, 2}, clazz = AlitaDataLineBO.class)
    public MapListBO listLine(MapBaseDTO mapBaseDTO) {
        AlitaData alitaData = ConverterUtil.converter(mapBaseDTO, AlitaData.builder().build());
        QueryWrapper<AlitaData> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(alitaData);
        queryWrapper.lambda().eq(AlitaData::getIsDeleted, 0);
        List<AlitaData> alitaDataList = alitaDataMapper.selectList(queryWrapper);
        List<AlitaDataLineBO> alitaDataBOList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(alitaDataList)) {
            alitaDataBOList = alitaDataList.stream().map(po -> {
                AlitaDataLineBO bo = new AlitaDataLineBO();
                BeanUtils.copyProperties(po, bo);
                LatLngBO latLng = LatLngUtil.getControl(po.getFromLatitude(),
                        po.getFromLongitude(), po.getToLatitude(),
                        po.getToLongitude(), (po.getTravelDistance() * 1000) / 2);
                bo.setControlLatitude(latLng.getLat());
                bo.setControlLongitude(latLng.getLng());
                return bo;
            }).collect(Collectors.toList());
        }
        MapListBO<AlitaDataLineBO> mapListBO = new MapListBO<>();
        mapListBO.setList(alitaDataBOList);
        return mapListBO;
    }

    @Override
    @MapMethodConfig(view = {1, 3, 1}, clazz = AlitaDataPlaneBO.class)
    public MapListBO listPlane(MapBaseDTO mapBaseDTO) {
        AlitaData alitaData = ConverterUtil.converter(mapBaseDTO, AlitaData.builder().build());
        QueryWrapper<AlitaData> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(alitaData);
        queryWrapper.lambda().eq(AlitaData::getIsDeleted, 0);
        List<AlitaData> alitaDataList = alitaDataMapper.selectList(queryWrapper);
        List<AlitaDataPlaneBO> alitaDataBOList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(alitaDataList)) {
            alitaDataBOList = alitaDataList.stream().map(po -> {
                AlitaDataPlaneBO bo = new AlitaDataPlaneBO();
                BeanUtils.copyProperties(po, bo);
                String content = po.getPlaneJson();
                List<LatLngBO> latLngBOList = JSONObject.parseArray(content, LatLngBO.class);
                int size = latLngBOList.size();
                Double[][] plane = new Double[size][2];
                for (int i = 0; i < size; i++) {
                    LatLngBO latLngBO = latLngBOList.get(i);
                    plane[i][0] = latLngBO.getLng();
                    plane[i][1] = latLngBO.getLat();
                }
                bo.setPlane(plane);
                return bo;
            }).collect(Collectors.toList());
        }
        MapListBO<AlitaDataPlaneBO> mapListBO = new MapListBO<>();
        mapListBO.setList(alitaDataBOList);
        return mapListBO;
    }

    @Override
    @MapMethodConfig(view = {2, 3}, clazz = AlitaDataBrandBO.class, isDetail = true, detailkey = "brand")
    public MapDetailBO getBrand() {
        AlitaDataBrandBO alitaDataBrandBO = AlitaDataBrandBO.builder()
                .goodStationCoverRate("100%")
                .currentGoodStationProportion("103/103")
                .provGoodStationCoverRate("50%")
                .futureGoodStationProportion("50/100")
                .currentHeatCount("130")
                .futureHeatCount("130")
                .currentCoverCount("130")
                .futureCoverCount("130")
                .build();
        MapDetailBO mapDetailBO = new MapDetailBO();
        Map<String, AlitaDataBrandBO> resultMap = Maps.newHashMap();
        resultMap.put("brand", alitaDataBrandBO);
        mapDetailBO.setPayload(resultMap);
        return mapDetailBO;
    }

    @Override
    @MapMethodConfig(clazz = AlitaDataSelectBO.class)
    public MapListBO listSelect() {
        AlitaDataSelectBO one = AlitaDataSelectBO.builder().key("0").value("未知").build();
        AlitaDataSelectBO two = AlitaDataSelectBO.builder().key("1").value("竞品").build();
        List<AlitaDataSelectBO> alitaDataSelectBOList = Lists.newArrayList(one, two);
        MapListBO<AlitaDataSelectBO> mapListBO = new MapListBO<>();
        mapListBO.setList(alitaDataSelectBOList);
        return mapListBO;
    }
}
