package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.PetModel;
import com.ruoyi.system.mapper.PetModelMapper;
import com.ruoyi.system.service.IPetModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 美容造型Service业务层处理
 * 
 * @author cc
 * @date 2022-04-05
 */
@Service
public class PetModelServiceImpl implements IPetModelService 
{
    @Autowired
    private PetModelMapper petModelMapper;

    /**
     * 查询美容造型
     * 
     * @param id 美容造型主键
     * @return 美容造型
     */
    @Override
    public PetModel selectPetModelById(Long id)
    {
        return petModelMapper.selectPetModelById(id);
    }

    /**
     * 查询美容造型列表
     * 
     * @param petModel 美容造型
     * @return 美容造型
     */
    @Override
    public List<PetModel> selectPetModelList(PetModel petModel)
    {
        return petModelMapper.selectPetModelList(petModel);
    }

    /**
     * 新增美容造型
     * 
     * @param petModel 美容造型
     * @return 结果
     */
    @Override
    public int insertPetModel(PetModel petModel)
    {
        return petModelMapper.insertPetModel(petModel);
    }

    /**
     * 修改美容造型
     * 
     * @param petModel 美容造型
     * @return 结果
     */
    @Override
    public int updatePetModel(PetModel petModel)
    {
        return petModelMapper.updatePetModel(petModel);
    }

    /**
     * 批量删除美容造型
     * 
     * @param ids 需要删除的美容造型主键
     * @return 结果
     */
    @Override
    public int deletePetModelByIds(Long[] ids)
    {
        return petModelMapper.deletePetModelByIds(ids);
    }

    /**
     * 删除美容造型信息
     * 
     * @param id 美容造型主键
     * @return 结果
     */
    @Override
    public int deletePetModelById(Long id)
    {
        return petModelMapper.deletePetModelById(id);
    }
}
