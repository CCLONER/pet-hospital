package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 美容造型对象 pet_model
 * 
 * @author cc
 * @date 2022-04-05
 */
public class PetModel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String petName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long doctor;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String petShape;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date cpTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long phone;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String masterName;

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
    public void setDoctor(Long doctor) 
    {
        this.doctor = doctor;
    }

    public Long getDoctor() 
    {
        return doctor;
    }
    public void setPetShape(String petShape) 
    {
        this.petShape = petShape;
    }

    public String getPetShape() 
    {
        return petShape;
    }
    public void setCpTime(Date cpTime) 
    {
        this.cpTime = cpTime;
    }

    public Date getCpTime() 
    {
        return cpTime;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("petName", getPetName())
            .append("doctor", getDoctor())
            .append("petShape", getPetShape())
            .append("cpTime", getCpTime())
            .append("phone", getPhone())
            .append("masterName", getMasterName())
            .toString();
    }
}
