package com.cj.guli.service.base.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Jinmunan
 * 2022/6/22
 * 11:39
 */

// 公共字段自动填充功能 mybatis-plus提供
@Component // ==service controller mapper 添加为spring容器中
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入自动填充字段
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert...]");
        log.info(metaObject.toString());
        // 外卖项目使用的方式
        // metaObject.setValue("createTime", LocalDateTime.now());
        // metaObject.setValue("updateTime", LocalDateTime.now());

        // 官网说有bug
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);


//        this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class); // 起始版本 3.3.3(推荐)
//        this.strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class); // 起始版本 3.3.3(推荐)


    }

    /**
     * 更新自动填充字段
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充[update...]");
        log.info(metaObject.toString());
        this.setFieldValByName("gmtModified", new Date(), metaObject);
//        this.strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class); // 起始版本 3.3.3(推荐)

    }
}
