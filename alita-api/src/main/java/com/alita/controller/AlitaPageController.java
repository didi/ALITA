package com.alita.controller;


import com.alita.common.ServiceResponse;
import com.alita.common.bo.AlitaPageBO;
import com.alita.common.vo.AlitaPageVO;
import com.alita.service.AlitaPageService;
import com.google.common.base.Preconditions;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 页面表 前端控制器
 *
 * @author Lydia
 * @since 2020-01-05
 */
@Controller
@RequestMapping("/alita/page")
@ResponseBody
public class AlitaPageController {

    @Autowired
    private AlitaPageService alitaPageService;

    @GetMapping("/search")
    @ApiOperation(value = "查询", notes = "")
    public ServiceResponse<AlitaPageVO> detailPage(@RequestParam("id") Long id) {
        AlitaPageBO alitaPageBO = alitaPageService.getById(id);
        AlitaPageVO alitaPageVO = new AlitaPageVO();
        BeanUtils.copyProperties(alitaPageBO, alitaPageVO);
        return ServiceResponse.successOf("ok", alitaPageVO);
    }

    @PostMapping("/create")
    @ApiOperation(value = "创建", notes = "")
    public ServiceResponse<Long> addPage(@RequestBody AlitaPageVO alitaPageVO) {
        AlitaPageBO alitaPageBO = new AlitaPageBO();
        BeanUtils.copyProperties(alitaPageVO, alitaPageBO);
        Long result = alitaPageService.add(alitaPageBO);
        return ServiceResponse.successOf("ok", result);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除", notes = "")
    public ServiceResponse<String> deleteEventDictionary(@RequestBody Long pageId) {
        Boolean delete = alitaPageService.delete(pageId);
        String result = String.valueOf(delete);
        return ServiceResponse.successOf("ok", result);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "")
    public ServiceResponse<String> updateEventDictionary(@RequestBody AlitaPageVO alitaPageVO) {
        Preconditions.checkArgument(alitaPageVO != null && alitaPageVO.getId() != null, "主键不能为空");
        AlitaPageBO alitaPageBO = new AlitaPageBO();
        BeanUtils.copyProperties(alitaPageVO, alitaPageBO);
        Boolean update = alitaPageService.update(alitaPageBO);
        String result = String.valueOf(update);
        return ServiceResponse.successOf("ok", result);
    }

}
