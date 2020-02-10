package com.alita.controller;

import com.alita.common.ServiceResponse;
import com.alita.common.bo.MapDetailBO;
import com.alita.common.bo.MapListBO;
import com.alita.common.dto.MapBaseDTO;
import com.alita.common.util.ConverterUtil;
import com.alita.common.vo.MapDetailVO;
import com.alita.common.vo.MapListVO;
import com.alita.service.AlitaDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lydia
 * @version V1.0
 * @since Thu Dec 05 17:53:14 CST 2019
 */
@Controller
@RequestMapping("/alita/data")
@ResponseBody
public class AlitaDataController {

    @Autowired
    private AlitaDataService alitaDataService;

    @GetMapping("/brands")
    @ApiOperation(value = "brand", notes = "")
    public ServiceResponse<MapDetailVO> listBrand() {
        MapDetailBO mapDetailBO = alitaDataService.getBrand();
        MapDetailVO result = ConverterUtil.converter(mapDetailBO);
        return ServiceResponse.successOf("ok", result);
    }

    @GetMapping("/select")
    @ApiOperation(value = "列表", notes = "")
    public ServiceResponse<MapListVO> listSelect() {
        MapListBO mapListBO = alitaDataService.listSelect();
        MapListVO result = ConverterUtil.converter(mapListBO);
        return ServiceResponse.successOf("ok", result);
    }

    @PostMapping("/point/list")
    @ApiOperation(value = "列表", notes = "")
    public ServiceResponse<MapListVO> listPoint(@RequestBody MapBaseDTO request) {
        MapListBO mapListBO = alitaDataService.listPoint(request);
        MapListVO result = ConverterUtil.converter(mapListBO);
        return ServiceResponse.successOf("ok", result);
    }

    @PostMapping("/line/list")
    @ApiOperation(value = "列表", notes = "")
    public ServiceResponse<MapListVO> listLine(@RequestBody MapBaseDTO request) {
        MapListBO mapListBO = alitaDataService.listLine(request);
        MapListVO result = ConverterUtil.converter(mapListBO);
        return ServiceResponse.successOf("ok", result);
    }

    @PostMapping("/plane/list")
    @ApiOperation(value = "列表", notes = "")
    public ServiceResponse<MapListVO> listPlane(@RequestBody MapBaseDTO request) {
        MapListBO mapListBO = alitaDataService.listPlane(request);
        MapListVO result = ConverterUtil.converter(mapListBO);
        return ServiceResponse.successOf("ok", result);
    }

}
