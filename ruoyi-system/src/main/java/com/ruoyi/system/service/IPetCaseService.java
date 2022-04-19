package com.ruoyi.system.service;

import com.ruoyi.system.domain.PetCase;

import java.util.List;

/**
 * caseService接口
 * 
 * @author cc
 * @date 2022-04-01
 */
public interface IPetCaseService 
{
    /**
     * 查询case
     * 
     * @param id case主键
     * @return case
     */
    public PetCase selectPetCaseById(Long id);

    /**
     * 查询case列表
     * 
     * @param petCase case
     * @return case集合
     */
    public List<PetCase> selectPetCaseList(PetCase petCase);

    /**
     * 新增case
     * 
     * @param petCase case
     * @return 结果
     */
    public int insertPetCase(PetCase petCase);

    /**
     * 修改case
     * 
     * @param petCase case
     * @return 结果
     */
    public int updatePetCase(PetCase petCase);

    /**
     * 批量删除case
     * 
     * @param ids 需要删除的case主键集合
     * @return 结果
     */
    public int deletePetCaseByIds(Long[] ids);

    /**
     * 删除case信息
     * 
     * @param id case主键
     * @return 结果
     */
    public int deletePetCaseById(Long id);


    public List<Integer> selectCaseCount();
}
