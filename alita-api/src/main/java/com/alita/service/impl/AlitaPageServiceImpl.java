package com.alita.service.impl;

import com.alita.common.bo.AlitaPageBO;
import com.alita.common.po.AlitaPage;
import com.alita.mysql.mapper.AlitaPageMapper;
import com.alita.service.AlitaPageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.Preconditions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 页面表 服务实现类
 *
 * @author Lydia
 * @since 2020-01-05
 */
@Service
public class AlitaPageServiceImpl implements AlitaPageService {

    @Autowired
    private AlitaPageMapper alitaPageMapper;

    @Override
    public AlitaPageBO getById(Long id) {
        AlitaPage alitaPage = alitaPageMapper.selectById(id);
        if (alitaPage != null && alitaPage.getStatus() == 1) {
            AlitaPageBO alitaPageBO = AlitaPageBO.builder().build();
            BeanUtils.copyProperties(alitaPage, alitaPageBO);
            return alitaPageBO;
        }
        return null;
    }

    @Override
    public Long add(AlitaPageBO alitaPageBO) {
        AlitaPage alitaPage = new AlitaPage();
        BeanUtils.copyProperties(alitaPageBO, alitaPage);
        alitaPageMapper.insert(alitaPage);
        return alitaPage.getId();
    }

    @Override
    public Boolean update(AlitaPageBO alitaPageBO) {
        AlitaPage alitaPage = new AlitaPage();
        BeanUtils.copyProperties(alitaPageBO, alitaPage);
        return alitaPageMapper.updateById(alitaPage) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        AlitaPage alitaPage = alitaPageMapper.selectById(id);
        Preconditions.checkArgument(alitaPage != null, "页面不存在");
        alitaPage.setStatus(0);
        alitaPageMapper.updateById(alitaPage);
        return alitaPageMapper.updateById(alitaPage) > 0;
    }

    @Override
    public List<AlitaPageBO> list(AlitaPageBO alitaPageBO) {
        AlitaPage alitaPage = new AlitaPage();
        BeanUtils.copyProperties(alitaPageBO, alitaPage);
        QueryWrapper<AlitaPage> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(alitaPage);
        queryWrapper.lambda().eq(AlitaPage::getStatus, 1);
        List<AlitaPage> alitaPageList = alitaPageMapper.selectList(queryWrapper);
        if (!CollectionUtils.isEmpty(alitaPageList)) {
            return alitaPageList.stream().map(po->{
                AlitaPageBO bo = new AlitaPageBO();
                BeanUtils.copyProperties(po, bo);
                return bo;
            }).collect(Collectors.toList());
        }
        return null;
    }
}
