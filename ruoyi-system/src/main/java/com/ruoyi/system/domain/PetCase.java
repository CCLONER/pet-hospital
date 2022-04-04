package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * case对象 pet_case
 * 
 * @author cc
 * @date 2022-04-01
 */
public class PetCase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 宠物名称 */
    @Excel(name = "宠物名称")
    private String petName;

    /** 宠物类型 */
    @Excel(name = "宠物类型")
    private String petType;

    /** 宠物年龄 */
    @Excel(name = "宠物年龄")
    private Long age;

    /** 病情描述 */
    private String detail;

    /** 主人电话 */
    @Excel(name = "主人电话")
    private Long phone;

    /** 主人姓名 */
    @Excel(name = "主人姓名")
    private String masterName;

    /** 医嘱 */
    private String evaluation;

    /** 主治医生 */
    @Excel(name = "主治医生")
    private String doctor;

    /** 治疗时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "治疗时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cpTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPetName(String petName) 
    {
        this.petName = petName;
    }

    public String getPetName() 
    {
        return petName;
    }
    public void setPetType(String petType) 
    {
        this.petType = petType;
    }

    public String getPetType() 
    {
        return petType;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setDetail(String detail) 
    {
        this.detail = detail;
    }

    public String getDetail() 
    {
        return detail;
    }
    public void setPhone(Long phone) 
    {
        this.phone = phone;
    }

    public Long getPhone() 
    {
        return phone;
    }
    public void setMasterName(String masterName) 
    {
        this.masterName = masterName;
    }

    public String getMasterName() 
    {
        return masterName;
    }
    public void setEvaluation(String evaluation) 
    {
        this.evaluation = evaluation;
    }

    public String getEvaluation() 
    {
        return evaluation;
    }
    public void setdoctor(String doctor) 
    {
        this.doctor = doctor;
    }

    public String getdoctor() 
    {
        return doctor;
    }
    public void setCpTime(Date cpTime) 
    {
        this.cpTime = cpTime;
    }

    public Date getCpTime() 
    {
        return cpTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("petName", getPetName())
            .append("petType", getPetType())
            .append("age", getAge())
            .append("detail", getDetail())
            .append("phone", getPhone())
            .append("masterName", getMasterName())
            .append("evaluation", getEvaluation())
            .append("doctor", getdoctor())
            .append("cpTime", getCpTime())
            .toString();
    }
}
