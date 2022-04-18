package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.domain.vo.BarDateVo;
import com.ruoyi.system.domain.vo.BarVo;
import com.ruoyi.system.mapper.SysPostMapper;
import com.ruoyi.system.service.BarVoService;
import com.ruoyi.system.util.ColorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cc
 * @create 2022-04-18 17:36
 */
@Service
public class BarVoServiceImpl implements BarVoService {

    @Autowired
    private SysPostMapper sysPostMapper;


    @Override
    public BarVo findVoList() {

        BarVo barVo = new BarVo();
        List<BarDateVo> barDateVoList = new ArrayList<BarDateVo>();

        List<SysPost> sysPosts = sysPostMapper.selectPostAll();

        ArrayList<String> names = new ArrayList<>();
        for (SysPost sysPost : sysPosts) {
           names.add( sysPost.getPostName());
        }

        barVo.setNames(names);

        List<Integer> postCounts = sysPostMapper.selectPostCount();
        for (Integer postCount : postCounts) {
            BarDateVo barDateVo = new BarDateVo();
            barDateVo.setValue(postCount);
            barDateVo.setItemStyle(ColorUtils.insertColor(postCount));
            barDateVoList.add(barDateVo);
        }

        barVo.setValues(barDateVoList);

        return barVo;
    }
}
