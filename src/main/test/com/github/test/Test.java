package com.github.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.github.stu.config.ConfigProperties;

/**
 * Author:chyl2005
 * Date:17/2/4
 * Time:15:41
 * Desc:描述该类的作用
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mvc.xml","classpath:applicationcontext.xml"})
public class Test {

    @Autowired
    private ConfigProperties config;

    @org.junit.Test
    public void test(){
        System.out.println(config.getBasePath());

    }
}
