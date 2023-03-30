package com.godofball.medtrack.pojo;


import java.io.Serializable;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;


/**
* 
* @TableName employee
*/
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 登录名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    private Integer age;

    private Integer sex;

    private String phone;
    /**
    * 身份证号
    */
    private String idNumber;
    /**
    * 地址
    */
    private String address;
    /**
    * 账号状态（1：正常，其他：禁用）
    */
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Long updateUser;
}
