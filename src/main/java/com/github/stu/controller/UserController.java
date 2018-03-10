package com.github.stu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.stu.constants.UserConstants;
import com.github.stu.model.User;
import com.github.stu.service.UserService;

/**
 * Author:chyl2005
 * Date:17/1/23
 * Time:17:47
 * Desc:描述该类的作用
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/mPage")
    public String mPage(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        model.addAttribute("currentUser",user);
        model.addAttribute("mainPage", "student/studentShow");
        return "main";
    }

    /**
     * 修改密码
     *
     * @param user
     * @return
     */
    @RequestMapping("/modifyPassword")
    @ResponseBody
    public Integer modifyPassword(User user) {
        return this.userService.modifyPassword(user);
    }

    /**
     * 修改密码
     *
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(UserConstants.LOGIN_KEY);
        return "login";
    }


}
