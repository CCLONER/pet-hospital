package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.PetModel;
import com.ruoyi.system.service.IPetModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 美容造型Controller
 * 
 * @author cc
 * @date 2022-04-05
 */
@RestController
@RequestMapping("/system/model")
public class PetModelController extends BaseController
{
    @Autowired
    private IPetModelService petModelService;

    /**
     * 查询美容造型列表
     */
    @PreAuthorize("@ss.hasPermi('system:model:list')")
    @GetMapping("/list")
    public TableDataInfo list(PetModel petModel)
    {
        startPage();
        List<PetModel> list = petModelService.selectPetModelList(petModel);
        return getDataTable(list);
    }

    /**
     * 导出美容造型列表
     */
    @PreAuthorize("@ss.hasPermi('system:model:export')")
    @Log(title = "美容造型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PetModel petModel)
    {
        List<PetModel> list = petModelService.selectPetModelList(petModel);
        ExcelUtil<PetModel> util = new ExcelUtil<PetModel>(PetModel.class);
        util.exportExcel(response, list, "美容造型数据");
    }

    /**
     * 获取美容造型详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:model:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(petModelService.selectPetModelById(id));
    }

    /**
     * 新增美容造型
     */
    @PreAuthorize("@ss.hasPermi('system:model:add')")
    @Log(title = "美容造型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PetModel petModel)
    {
        return toAjax(petModelService.insertPetModel(petModel));
    }

    /**
     * 修改美容造型
     */
    @PreAuthorize("@ss.hasPermi('system:model:edit')")
    @Log(title = "美容造型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PetModel petModel)
    {
        return toAjax(petModelService.updatePetModel(petModel));
    }

    /**
     * 删除美容造型
     */
    @PreAuthorize("@ss.hasPermi('system:model:remove')")
    @Log(title = "美容造型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(petModelService.deletePetModelByIds(ids));
    }
}
