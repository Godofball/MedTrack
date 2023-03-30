package com.godofball.medtrack.pojo;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

/**
* 产商信息
* @TableName manufacturer
*/
public class Manufacturer implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String phone;

    private String address;

    /**
    * 负责人
    */
    private String person;

    /**
    * 备注信息
    */
    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTiem;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;



}
