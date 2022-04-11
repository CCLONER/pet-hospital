package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PetModel;

/**
 * 美容造型Mapper接口
 * 
 * @author cc
 * @date 2022-04-05
 */
public interface PetModelMapper 
{
    /**
     * 查询美容造型
     * 
     * @param id 美容造型主键
     * @return 美容造型
     */
    public PetModel selectPetModelById(Long id);

    /**
     * 查询美容造型列表
     * 
     * @param petModel 美容造型
     * @return 美容造型集合
     */
    public List<PetModel> selectPetModelList(PetModel petModel);

    /**
     * 新增美容造型
     * 
     * @param petModel 美容造型
     * @return 结果
     */
    public int insertPetModel(PetModel petModel);

    /**
     * 修改美容造型
     * 
     * @param petModel 美容造型
     * @return 结果
     */
    public int updatePetModel(PetModel petModel);

    /**
     * 删除美容造型
     * 
     * @param id 美容造型主键
     * @return 结果
     */
    public int deletePetModelById(Long id);

    /**
     * 批量删除美容造型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePetModelByIds(Long[] ids);
}
