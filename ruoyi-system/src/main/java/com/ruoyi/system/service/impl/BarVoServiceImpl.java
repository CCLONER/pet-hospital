package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.PetCase;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.domain.vo.BarDateVo;
import com.ruoyi.system.domain.vo.BarVo;
import com.ruoyi.system.domain.vo.BingVo;
import com.ruoyi.system.mapper.PetCaseMapper;
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

    @Autowired
    private PetCaseMapper petCaseMapper;


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


    @Override
    public List<BingVo> findVoList1() {
        List<PetCase> petCases = petCaseMapper.selectPetCaseList(null);
        ArrayList<BingVo> bingVos = new ArrayList<>();

        int dog=0,cat=0,others=0;
        for (PetCase petCase : petCases) {
            switch (petCase.getPetType()){
                case "dog":
                    dog++;
                    break;
                case "cat":
                    cat++;
                    break;
                case "others":
                    others++;
                    break;
            }
        }

        BingVo bingVo1 = new BingVo();
        bingVo1.setName("宠物狗");
        bingVo1.setValue(dog);
        bingVo1.setItemStyle(ColorUtils.insertColor(dog));
        bingVos.add(bingVo1);

        BingVo bingVo2 = new BingVo();
        bingVo2.setName("宠物猫");
        bingVo2.setValue(cat);
        bingVo2.setItemStyle(ColorUtils.insertColor(cat));
        bingVos.add(bingVo2);

        BingVo bingVo3 = new BingVo();
        bingVo3.setName("其他宠物");
        bingVo3.setValue(others);
        bingVo3.setItemStyle(ColorUtils.insertColor(others));
        bingVos.add(bingVo3);

        return bingVos;
    }

    @Override
    public BingVo findVoList2() {
        return null;
    }
}
