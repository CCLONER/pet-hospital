package com.ruoyi.system.service;

import com.ruoyi.system.domain.vo.BarVo;
import com.ruoyi.system.domain.vo.BingVo;

import java.util.List;

/**
 * @author cc
 * @create 2022-04-18 17:35
 */
public interface BarVoService {

    public BarVo findVoList();

    public List<BingVo> findVoList1();

    public BingVo findVoList2();

}
