package com.github.stu.controller;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.stu.model.User;
import com.github.stu.service.UserService;
import com.github.stu.utils.MD5Utils;
import com.github.stu.utils.StringUtil;
import com.github.stu.utils.ValidateCode;
import com.github.stu.vo.WebResponse;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:14:33
 * Desc:描述该类的作用
 */

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("mainPage", "common/default");
        return "main";
    }

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @param code
     * @return
     */
    @RequestMapping("/isLogin")
    @ResponseBody
    public WebResponse login(String userName, String password, String code, HttpServletRequest request, HttpServletResponse res) {
        WebResponse response = WebResponse.getErrorWebResponse();
        String message = "用户名或者密码错误！";
        String host = request.getServerName();
        if (StringUtil.isEmpty(code)) {
            message = "请输入验证码！";
            response.setMessage(message);
            return response;
        }
        // 获取验证码
        Cookie[] cookies = request.getCookies();
        String codeValue = getCookieValue(cookies, "code");
        String md5 = MD5Utils.getMD5(code.toLowerCase());
        if (!md5.equals(codeValue)) {
            message = "请输入正确验证码错误！";
            response.setMessage(message);
            return response;
        }
        //
        if (StringUtils.isNotBlank(password) && StringUtils.isNotBlank(userName)) {
            String pwd = MD5Utils.getMD5(password);
            User user = new User();
            user.setPassword(pwd);
            user.setUserName(userName);
            User login = this.userService.login(user);
            if (login != null) {
                // 密码校验成功 添加cookie
                Cookie ssoid = new Cookie("ssoid", pwd);
                ssoid.setMaxAge(3600 * 24);
                ssoid.setPath("/");
                ssoid.setDomain(host);
                res.addCookie(ssoid);
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                return WebResponse.getSuccessWebResponse();
            }
        }
        response.setMessage(message);
        return response;
    }

    /**
     * 验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/code")
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String host = request.getServerName();
        HttpSession session = request.getSession();
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        ValidateCode vCode = new ValidateCode(106, 52);
        String codeValue = vCode.getCode();
        // 加密过程
        String md5 = MD5Utils.getMD5(codeValue.toLowerCase());
        Cookie cookie = new Cookie("code", md5);
        cookie.setPath("/");
        cookie.setMaxAge(300);
        cookie.setDomain(host);
        response.addCookie(cookie);
        // 将认证码存入SESSION
        session.setAttribute("code", md5);
        vCode.write(response.getOutputStream());

    }

    /**
     * @param cookies
     * @param @param  key
     * @return String 返回类型
     * @Description:
     * @author chenyanlong
     * @date 2015年12月10日 下午6:36:14
     */
    private String getCookieValue(Cookie[] cookies, String key) {
        for (Cookie cookie : cookies) {
            String value = cookie.getValue();
            if (cookie.getName().equals(key) && StringUtils.isNotBlank(value)) {
                return value;
            }
        }
        return null;
    }
}
