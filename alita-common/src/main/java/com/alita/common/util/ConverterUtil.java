package com.alita.common.util;

import com.alibaba.fastjson.JSONObject;
import com.alita.common.bo.MapConfigBO;
import com.alita.common.bo.MapDetailBO;
import com.alita.common.bo.MapListBO;
import com.alita.common.bo.MapListConfigBO;
import com.alita.common.dto.MapBaseDTO;
import com.alita.common.vo.MapConfigVO;
import com.alita.common.vo.MapDetailVO;
import com.alita.common.vo.MapListConfigVO;
import com.alita.common.vo.MapListVO;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author Lydia
 * @version V1.0
 * @since 2020-01-10 10:01:50
 */
public class ConverterUtil {

    public static <T> T converter(MapBaseDTO mapBaseDTO, T target) {
        Class clazz = target.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String typeName = field.getGenericType().getTypeName();
            try {
                if (field.getName().equals("cityId") && mapBaseDTO.getCityId() != null) {
                    field.set(target, mapBaseDTO.getCityId());
                } else if (field.getName().equals("staffCreated") && mapBaseDTO.getStaffCreated() != null) {
                    field.set(target, mapBaseDTO.getStaffCreated());
                } else if (field.getName().equals("staffModified") && mapBaseDTO.getStaffModified() != null) {
                    field.set(target, mapBaseDTO.getStaffModified());
                } else {
                    if (mapBaseDTO.getParams() != null && mapBaseDTO.getParams().length > 0) {
                        for (MapBaseDTO.KeyValue param : mapBaseDTO.getParams()) {
                            if (param.getKey().equals(field.getName()) && param.getValue() != null && !param.getValue().equals("")) {
                                if (typeName.contains("List") && typeName.contains("String")) {
                                    List<String> stringList = (List<String>) param.getValue();
                                    field.set(target, stringList);
                                    continue;
                                }
                                if (typeName.contains("List") && typeName.contains("Integer")) {
                                    List<Integer> stringList = (List<Integer>) param.getValue();
                                    field.set(target, stringList);
                                    continue;
                                }
                                if (typeName.contains("List") && typeName.contains("Long")) {
                                    List<Long> stringList = (List<Long>) param.getValue();
                                    field.set(target, stringList);
                                    continue;
                                }
                                if (field.getType().equals(String.class)) {
                                    field.set(target, param.getValue());
                                    continue;
                                }
                                if (field.getType().equals(Long.class)) {
                                    field.set(target, Long.valueOf(param.getValue().toString()));
                                    continue;
                                }
                                if (field.getType().equals(Integer.class)) {
                                    field.set(target, Integer.valueOf(param.getValue().toString()));
                                    continue;
                                }
                                if (field.getType().equals(Double[][].class)) {
                                    Double[][] array = JSONObject.parseObject(param.getValue().toString(), Double[][].class);
                                    field.set(target, array);
                                    continue;
                                }
                                if (field.getType().equals(Double.class)) {
                                    field.set(target, Double.valueOf(param.getValue().toString()));
                                    continue;
                                }
                                if (field.getType().equals(Date.class)) {
                                    Timestamp timestamp = new Timestamp((Long) param.getValue());
                                    field.set(target, new Date(timestamp.getTime()));
                                    continue;
                                }
                                continue;
                            }
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("入参字段映射异常");
            }
        }
        return target;
    }

    public static MapDetailVO converter(MapDetailBO mapDetailBO) {
        if (mapDetailBO == null) {
            return null;
        }
        return MapDetailVO.builder().config(converter(mapDetailBO.getConfig())).payload(mapDetailBO.getPayload()).build();
    }

    public static MapListVO converter(MapListBO mapListBO) {
        if (mapListBO == null) {
            return null;
        }
        return MapListVO.builder().config(converter(mapListBO.getConfig())).payload(mapListBO.getList()).build();
    }

    private static MapListConfigVO converter(MapListConfigBO mapListConfigBO) {
        if (mapListConfigBO == null) {
            return null;
        }
        return MapListConfigVO.builder().view(mapListConfigBO.getView()).config(converter(mapListConfigBO.getConfig())).build();
    }

    private static MapConfigVO[] converter(MapConfigBO[] mapConfigBOS) {
        if (mapConfigBOS == null || mapConfigBOS.length <= 0) {
            return null;
        }
        MapConfigVO[] mapConfigVOS = new MapConfigVO[mapConfigBOS.length];
        for (int i = 0; i < mapConfigBOS.length; i++) {
            mapConfigVOS[i] = converter(mapConfigBOS[i]);
        }
        return mapConfigVOS;
    }

    private static MapConfigVO converter(MapConfigBO mapConfigBO) {
        if (mapConfigBO == null) {
            return null;
        }
        MapConfigVO mapConfigVO = MapConfigVO.builder()
                .key(mapConfigBO.getKey())
                .value(mapConfigBO.getValue())
                .status(mapConfigBO.getStatus())
                .view(mapConfigBO.getView())
                .build();
        if (mapConfigBO.getConfig() != null && mapConfigBO.getConfig().length > 0) {
            MapConfigVO[] voConfig = new MapConfigVO[mapConfigBO.getConfig() == null ? 0 : mapConfigBO.getConfig().length];
            MapConfigBO[] boConfig = mapConfigBO.getConfig();
            for (int i = 0; i < boConfig.length; i++) {
                voConfig[i] = converter(boConfig[i]);
            }
            mapConfigVO.setConfig(voConfig);
        }
        return mapConfigVO;
    }

}
