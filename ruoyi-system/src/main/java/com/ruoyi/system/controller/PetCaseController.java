package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.PetCase;
import com.ruoyi.system.service.IPetCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * caseController
 *
 * @author cc
 * @date 2022-04-01
 */
@RestController
@RequestMapping("/system/case")
public class PetCaseController extends BaseController {
    @Autowired
    private IPetCaseService petCaseService;

    /**
     * 查询case列表
     */
    @PreAuthorize("@ss.hasPermi('system:case:list')")
    @GetMapping("/list")
    public TableDataInfo list(PetCase petCase) {
        startPage();
        List<PetCase> list = petCaseService.selectPetCaseList(petCase);
        return getDataTable(list);
    }

    /**
     * 导出case列表
     */
    @PreAuthorize("@ss.hasPermi('system:case:export')")
    @Log(title = "case", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PetCase petCase) {
        List<PetCase> list = petCaseService.selectPetCaseList(petCase);
        ExcelUtil<PetCase> util = new ExcelUtil<PetCase>(PetCase.class);
        util.exportExcel(response, list, "case数据");
    }

    /**
     * 获取case详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:case:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(petCaseService.selectPetCaseById(id));
    }

    /**
     * 新增case
     */
    @PreAuthorize("@ss.hasPermi('system:case:add')")
    @Log(title = "case", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PetCase petCase) {
        return toAjax(petCaseService.insertPetCase(petCase));
    }

    /**
     * 修改case
     */
    @PreAuthorize("@ss.hasPermi('system:case:edit')")
    @Log(title = "case", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PetCase petCase) {
        return toAjax(petCaseService.updatePetCase(petCase));
    }

    /**
     * 删除case
     */
    @PreAuthorize("@ss.hasPermi('system:case:remove')")
    @Log(title = "case", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(petCaseService.deletePetCaseByIds(ids));
    }
}
