package com.alita.controller;


import com.alita.common.ServiceResponse;
import com.alita.common.bo.AlitaApplicationBO;
import com.alita.common.bo.AlitaPageBO;
import com.alita.common.vo.AlitaApplicationVO;
import com.alita.common.vo.AlitaPageVO;
import com.alita.service.AlitaApplicationService;
import com.alita.service.AlitaPageService;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 应用表 前端控制器
 *
 * @author Lydia
 * @since 2020-01-05
 */
@Controller
@RequestMapping("/alita/app")
@ResponseBody
public class AlitaApplicationController {

    @Autowired
    private AlitaApplicationService alitaApplicationService;

    @Autowired
    private AlitaPageService alitaPageService;

    @GetMapping("/search")
    @ApiOperation(value = "查询", notes = "")
    public ServiceResponse<AlitaApplicationVO> detailApplication(@RequestParam("id") Long id) {
        AlitaApplicationVO alitaApplicationVO = new AlitaApplicationVO();
        List<AlitaPageVO> pages = Lists.newArrayList();
        AlitaApplicationBO alitaApplicationBO = alitaApplicationService.getById(id);
        if (alitaApplicationBO != null) {
            BeanUtils.copyProperties(alitaApplicationBO, alitaApplicationVO);
            List<AlitaPageBO> alitaPageBOList = alitaPageService.list(AlitaPageBO.builder().appId(alitaApplicationBO.getId()).build());
            if (!CollectionUtils.isEmpty(alitaPageBOList)) {
                pages = alitaPageBOList.stream().map(bo -> {
                    AlitaPageVO vo = new AlitaPageVO();
                    BeanUtils.copyProperties(bo, vo);
                    return vo;
                }).collect(Collectors.toList());
            }
        }
        alitaApplicationVO.setPages(pages);
        return ServiceResponse.successOf("ok", alitaApplicationVO);
    }

    @PostMapping("/create")
    @ApiOperation(value = "创建", notes = "")
    public ServiceResponse<Long> addApplication(@RequestBody AlitaApplicationVO alitaApplicationVO) {
        AlitaApplicationBO alitaApplicationBO = new AlitaApplicationBO();
        BeanUtils.copyProperties(alitaApplicationVO, alitaApplicationBO);
        Long result = alitaApplicationService.add(alitaApplicationBO);
        return ServiceResponse.successOf("ok", result);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除", notes = "")
    public ServiceResponse<String> deleteApplication(@RequestBody Long pageId) {
        Boolean delete = alitaApplicationService.delete(pageId);
        String result = String.valueOf(delete);
        return ServiceResponse.successOf("ok", result);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "")
    public ServiceResponse<String> updateApplication(@RequestBody AlitaApplicationVO alitaApplicationVO) {
        Preconditions.checkArgument(alitaApplicationVO != null && alitaApplicationVO.getId() != null, "主键不能为空");
        AlitaApplicationBO alitaApplicationBO = new AlitaApplicationBO();
        BeanUtils.copyProperties(alitaApplicationVO, alitaApplicationBO);
        Boolean update = alitaApplicationService.update(alitaApplicationBO);
        String result = String.valueOf(update);
        return ServiceResponse.successOf("ok", result);
    }

}
