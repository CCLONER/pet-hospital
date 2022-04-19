package com.ruoyi.system.controller;

import com.ruoyi.system.domain.vo.BarVo;
import com.ruoyi.system.domain.vo.BingVo;
import com.ruoyi.system.service.BarVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cc
 * @create 2022-04-18 18:05
 */
@RestController
@RequestMapping("/system/echarts")
public class EchartsController {

    @Autowired
    private BarVoService barVoService;

    @GetMapping("/bar")
    public BarVo selectBar(){

        return barVoService.findVoList();

    }

    @GetMapping("/bing1")
    public List<BingVo> selectBingVo1(){
        return barVoService.findVoList1();
    }


}
