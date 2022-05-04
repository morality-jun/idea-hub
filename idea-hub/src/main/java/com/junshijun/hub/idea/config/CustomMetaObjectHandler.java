package com.junshijun.hub.idea.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "version", 1);
        this.fillStrategy(metaObject, "createdTime", LocalDateTime.now());
        this.fillStrategy(metaObject, "createdBy", -1L);
        this.fillStrategy(metaObject, "isDeleted", 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "modifiedTime", LocalDateTime.now());
        this.fillStrategy(metaObject, "modifiedBy", -1L);
    }
}
