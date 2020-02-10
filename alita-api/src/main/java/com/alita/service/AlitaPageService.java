package com.alita.service;

import com.alita.common.bo.AlitaPageBO;

import java.util.List;

/**
 * 页面表 服务类
 *
 * @author Lydia
 * @since 2020-01-05
 */
public interface AlitaPageService {

    AlitaPageBO getById(Long id);

    Long add(AlitaPageBO alitaPageBO);

    Boolean update(AlitaPageBO alitaPageBO);

    Boolean delete(Long id);

    List<AlitaPageBO> list(AlitaPageBO alitaPageBO);

}
