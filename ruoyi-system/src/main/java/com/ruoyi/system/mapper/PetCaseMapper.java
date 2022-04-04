package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PetCase;

/**
 * caseMapper接口
 * 
 * @author cc
 * @date 2022-04-01
 */
public interface PetCaseMapper 
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
     * 删除case
     * 
     * @param id case主键
     * @return 结果
     */
    public int deletePetCaseById(Long id);

    /**
     * 批量删除case
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePetCaseByIds(Long[] ids);
}
