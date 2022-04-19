package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.PetCase;
import com.ruoyi.system.mapper.PetCaseMapper;
import com.ruoyi.system.service.IPetCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * caseService业务层处理
 * 
 * @author cc
 * @date 2022-04-01
 */
@Service
public class PetCaseServiceImpl implements IPetCaseService 
{
    @Autowired
    private PetCaseMapper petCaseMapper;

    /**
     * 查询case
     * 
     * @param id case主键
     * @return case
     */
    @Override
    public PetCase selectPetCaseById(Long id)
    {
        return petCaseMapper.selectPetCaseById(id);
    }

    /**
     * 查询case列表
     * 
     * @param petCase case
     * @return case
     */
    @Override
    public List<PetCase> selectPetCaseList(PetCase petCase)
    {
        return petCaseMapper.selectPetCaseList(petCase);
    }

    /**
     * 新增case
     * 
     * @param petCase case
     * @return 结果
     */
    @Override
    public int insertPetCase(PetCase petCase)
    {
        return petCaseMapper.insertPetCase(petCase);
    }

    /**
     * 修改case
     * 
     * @param petCase case
     * @return 结果
     */
    @Override
    public int updatePetCase(PetCase petCase)
    {
        return petCaseMapper.updatePetCase(petCase);
    }

    /**
     * 批量删除case
     * 
     * @param ids 需要删除的case主键
     * @return 结果
     */
    @Override
    public int deletePetCaseByIds(Long[] ids)
    {
        return petCaseMapper.deletePetCaseByIds(ids);
    }

    /**
     * 删除case信息
     * 
     * @param id case主键
     * @return 结果
     */
    @Override
    public int deletePetCaseById(Long id)
    {
        return petCaseMapper.deletePetCaseById(id);
    }

    @Override
    public List<Integer> selectCaseCount() {
       return petCaseMapper.selectCaseCount();
    }
}
