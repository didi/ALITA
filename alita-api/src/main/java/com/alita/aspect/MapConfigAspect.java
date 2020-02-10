package com.alita.aspect;

import com.alita.common.annotation.MapConfig;
import com.alita.common.annotation.MapMethodConfig;
import com.alita.common.bo.MapConfigBO;
import com.alita.common.bo.MapDetailBO;
import com.alita.common.bo.MapListBO;
import com.alita.common.bo.MapListConfigBO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class MapConfigAspect {

    @Around("@annotation(com.alita.common.annotation.MapMethodConfig) && @annotation(mapMethodConfig)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, MapMethodConfig mapMethodConfig) {
        return mapMethodConfig.isDetail() ? detail(proceedingJoinPoint, mapMethodConfig) : list(proceedingJoinPoint, mapMethodConfig);
    }

    /**
     * 提取子配置
     *
     * @param clazz
     * @return
     */
    private MapConfigBO[] config(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        List<MapConfigBO> mapConfigBOList = Arrays.stream(fields).map(field -> {
            MapConfig mapConfig = field.getAnnotation(MapConfig.class);
            if (mapConfig == null) {
                return MapConfigBO.builder()
                        .key(field.getName())
                        .status(0)
                        .order(0)
                        .build();
            }
            String key = StringUtils.isBlank(mapConfig.key()) ? field.getName() : mapConfig.key();
            Class innerClazz = mapConfig.inner();
            if (innerClazz != void.class) {
                MapConfigBO[] innerConfigList = config(innerClazz);
                return MapConfigBO.builder()
                        .key(key)
                        .value(mapConfig.value())
                        .status(mapConfig.status())
                        .view(mapConfig.view())
                        .order(mapConfig.order())
                        .config(innerConfigList)
                        .build();

            }
            return MapConfigBO.builder()
                    .key(key)
                    .value(mapConfig.value())
                    .status(mapConfig.status())
                    .view(mapConfig.view())
                    .order(mapConfig.order())
                    .build();
        }).collect(Collectors.toList());
        mapConfigBOList.sort(Comparator.comparing(MapConfigBO::getOrder));
        return mapConfigBOList.toArray(new MapConfigBO[mapConfigBOList.size()]);
    }

    /**
     * 处理详情场景
     *
     * @param proceedingJoinPoint
     * @param mapMethodConfig
     * @return
     */
    private MapDetailBO detail(ProceedingJoinPoint proceedingJoinPoint, MapMethodConfig mapMethodConfig) {
        MapDetailBO mapDetailBO = new MapDetailBO();
        try {
            mapDetailBO = (MapDetailBO) proceedingJoinPoint.proceed();
            MapConfigBO[] config = config(mapMethodConfig.clazz());
            if (StringUtils.isNotEmpty(mapMethodConfig.detailkey())) {
                MapConfigBO mapConfigBO = MapConfigBO.builder().key(mapMethodConfig.detailkey()).view(mapMethodConfig.view()).config(config).build();
                mapDetailBO.setConfig(new MapConfigBO[]{mapConfigBO});
            } else {
                mapDetailBO.setConfig(config);
            }
        } catch (Throwable e) {
            log.error("通用配置切面处理发生异常 error={}", ExceptionUtils.getFullStackTrace(e));
        }
        return mapDetailBO;
    }

    /**
     * 处理列表场景
     *
     * @param proceedingJoinPoint
     * @param mapMethodConfig
     * @return
     */
    private MapListBO list(ProceedingJoinPoint proceedingJoinPoint, MapMethodConfig mapMethodConfig) {
        MapConfigBO[] innerConfig = config(mapMethodConfig.clazz());
        MapListBO mapListBO = null;
        try {
            MapListConfigBO mapConfigBO = MapListConfigBO.builder().view(mapMethodConfig.view()).config(innerConfig).build();
            mapListBO = (MapListBO) proceedingJoinPoint.proceed();
            mapListBO.setConfig(mapConfigBO);
        } catch (Throwable e) {
            log.error("通用配置切面处理发生异常 error={}", ExceptionUtils.getFullStackTrace(e));
        }
        return mapListBO;
    }
}
