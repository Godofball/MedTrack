package com.godofball.medtrack.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class Drug {
    private Long id;
    private String name;
    private String image;
    private String efficacy;
    private String unit;
    private Long type;

    private Integer shelfLife;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;

    @TableField(fill=FieldFill.UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long createUser;

    @TableField(fill=FieldFill.UPDATE)
    private Long updateUser;
}
