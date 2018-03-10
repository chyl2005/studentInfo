package com.github.stu.aop;

import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Author:chyl2005
 * Date:17/2/20
 * Time:12:47
 * Desc:接口jsonp支持
 */
//@Order(2)
//@ControllerAdvice(basePackages = "com.github.stu.controller")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonpAdvice() {
        super("callback", "jsonp"); //指定jsonpParameterNames
    }
}