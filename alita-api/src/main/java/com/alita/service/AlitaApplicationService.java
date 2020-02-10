package com.alita.service;

import com.alita.common.bo.AlitaApplicationBO;

/**
 * 应用表 服务类
 *
 * @author Lydia
 * @since 2020-01-05
 */
public interface AlitaApplicationService {

    AlitaApplicationBO getById(Long id);

    Long add(AlitaApplicationBO alitaApplicationBO);

    Boolean update(AlitaApplicationBO alitaApplicationBO);

    Boolean delete(Long id);

}
