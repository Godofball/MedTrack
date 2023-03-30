package com.godofball.medtrack.pojo;



import java.io.Serializable;

import java.util.Date;
import lombok.Data;

/**
* 
* @TableName admin
*/
@Data
public class Admin implements Serializable {

    private Long id;

    private String name;

    private String username;

    private String password;

    private String phone;

    private Long authority;

    private Date createTime;

    private Date updateTime;

    private Long createUser;

    private Long updateUser;


}
