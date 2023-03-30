package com.godofball.medtrack.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class CommonMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert公共字段填充");
        Date date = new Date();
        if (metaObject.hasSetter("createTime")) metaObject.setValue("createTime",date);
        if (metaObject.hasSetter("updateTime")) metaObject.setValue("updateTime",date);
        if (metaObject.hasSetter("createUser")) metaObject.setValue("createUser",CurrentUser.getCurrentUser());
        if (metaObject.hasSetter("updateUser")) metaObject.setValue("updateUser",CurrentUser.getCurrentUser());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("update公共字段填充");
        if (metaObject.hasSetter("updateTime")) metaObject.setValue("updateTime",new Date());
        if (metaObject.hasSetter("updateUser")) metaObject.setValue("updateUser",CurrentUser.getCurrentUser());
    }
}
