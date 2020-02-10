package com.alita.service.impl;

import com.alita.common.bo.AlitaComponentBO;
import com.alita.common.po.AlitaComponent;
import com.alita.mysql.mapper.AlitaComponentMapper;
import com.alita.service.AlitaComponentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 组件配置表 服务实现类
 *
 * @author Lydia
 * @since 2020-01-05
 */
@Service
public class AlitaComponentServiceImpl implements AlitaComponentService {

    @Autowired
    private AlitaComponentMapper alitaComponentMapper;

    @Override
    public AlitaComponentBO getById(Long id) {
        AlitaComponent alitaComponent = alitaComponentMapper.selectById(id);
        if (alitaComponent != null && alitaComponent.getStatus() == 1) {
            AlitaComponentBO alitaComponentBO = new AlitaComponentBO();
            BeanUtils.copyProperties(alitaComponent, alitaComponentBO);
            return alitaComponentBO;
        }
        return null;
    }
}
