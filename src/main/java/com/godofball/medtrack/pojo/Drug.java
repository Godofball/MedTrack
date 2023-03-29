package com.godofball.medtrack.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Drug {
    private Long id;
    private String name;
    private String efficacy;
    private String unit;
    private Long type;

    private Integer shelfLife;
    private Date createTime;
    private Date updateTime;
    private Long createUser;
    private Long updateUser;
}
