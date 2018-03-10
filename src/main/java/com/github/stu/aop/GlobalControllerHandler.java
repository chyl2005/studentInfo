package com.github.stu.aop;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.stu.vo.WebResponse;

/**
 * Author:chyl2005
 * Date:17/2/20
 * Time:14:09
 * Desc:描述该类的作用
 */
//@Order(1)
@ControllerAdvice(basePackages = "com.github.stu.controller")
public class GlobalControllerHandler {

    /**
     * 异常处理
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public WebResponse handleException(HttpServletRequest req, Exception ex) {
        WebResponse errorWebResponse = WebResponse.getErrorWebResponse();
        return errorWebResponse;
    }
}
