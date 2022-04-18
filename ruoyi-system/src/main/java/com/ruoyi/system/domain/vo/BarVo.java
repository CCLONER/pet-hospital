package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * @author cc
 * @create 2022-04-18 17:30
 */
@Data
public class BarVo {

    private List<String> names;

    private List<BarDateVo> values;

}
