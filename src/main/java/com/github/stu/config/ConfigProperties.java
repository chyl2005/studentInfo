package com.github.stu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Author:chyl2005
 * Date:17/2/4
 * Time:15:29
 * Desc:描述该类的作用
 */
@Component
public class ConfigProperties {


    @Value("${basePath}")
    private String basePath;

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}
