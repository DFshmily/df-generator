package com.df.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

import java.io.File;

public class MetaManager {

    private static volatile  Meta meta;

    public static Meta getMetaObject() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String projectPath = System.getProperty("user.dir");
        String metaJson = ResourceUtil.readUtf8Str(projectPath + File.separator + "src/main/resources/templates/java/meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        //校验配置文件，处理默认值
        MetaValidator.doValidAndFill(newMeta);
        return newMeta;

    }
}
