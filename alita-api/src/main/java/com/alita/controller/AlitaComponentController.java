package com.alita.controller;


import com.alita.common.ServiceResponse;
import com.alita.common.bo.AlitaComponentBO;
import com.alita.common.vo.AlitaComponentVO;
import com.alita.service.AlitaComponentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 组件配置表 前端控制器
 *
 * @author Lydia
 * @since 2020-01-05
 */
@Controller
@RequestMapping("/alita/component")
@ResponseBody
public class AlitaComponentController {

    @Autowired
    private AlitaComponentService alitaComponentService;

    @GetMapping("/search")
    @ApiOperation(value = "查询", notes = "")
    public ServiceResponse<AlitaComponentVO> detailPage(@RequestParam("id") Long id) {
        AlitaComponentBO alitaComponentBO = alitaComponentService.getById(id);
        AlitaComponentVO alitaComponentVO = new AlitaComponentVO();
        BeanUtils.copyProperties(alitaComponentBO, alitaComponentVO);
        return ServiceResponse.successOf("ok", alitaComponentVO);
    }

}
