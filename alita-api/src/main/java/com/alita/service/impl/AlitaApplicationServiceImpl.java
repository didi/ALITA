package com.alita.service.impl;

import com.alita.common.bo.AlitaApplicationBO;
import com.alita.common.po.AlitaApplication;
import com.alita.mysql.mapper.AlitaApplicationMapper;
import com.alita.mysql.mapper.AlitaPageMapper;
import com.alita.service.AlitaApplicationService;
import com.google.common.base.Preconditions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 应用表 服务实现类
 *
 * @author Lydia
 * @since 2020-01-05
 */
@Service
public class AlitaApplicationServiceImpl implements AlitaApplicationService {

    @Autowired
    private AlitaApplicationMapper alitaApplicationMapper;

    @Autowired
    private AlitaPageMapper alitaPageMapper;

    @Override
    public AlitaApplicationBO getById(Long id) {
        AlitaApplication alitaApplication = alitaApplicationMapper.selectById(id);
        if (alitaApplication != null && alitaApplication.getStatus() == 1) {
            AlitaApplicationBO alitaApplicationBO = AlitaApplicationBO.builder().build();
            BeanUtils.copyProperties(alitaApplication, alitaApplicationBO);
            return alitaApplicationBO;
        }
        return null;
    }

    @Override
    public Long add(AlitaApplicationBO alitaApplicationBO) {
        AlitaApplication alitaApplication = new AlitaApplication();
        BeanUtils.copyProperties(alitaApplicationBO, alitaApplication);
        alitaApplicationMapper.insert(alitaApplication);
        return alitaApplication.getId();
    }

    @Override
    public Boolean update(AlitaApplicationBO alitaApplicationBO) {
        AlitaApplication alitaApplication = new AlitaApplication();
        BeanUtils.copyProperties(alitaApplicationBO, alitaApplication);
        return alitaApplicationMapper.updateById(alitaApplication) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        AlitaApplication alitaApplication = alitaApplicationMapper.selectById(id);
        Preconditions.checkArgument(alitaApplication != null, "页面不存在");
        alitaApplication.setStatus(0);
        alitaApplicationMapper.updateById(alitaApplication);
        return alitaApplicationMapper.updateById(alitaApplication) > 0;
    }
}
