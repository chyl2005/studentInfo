package com.github.stu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.stu.dao.UserDao;
import com.github.stu.model.User;

/**
 * Author:chyl2005
 * Date:17/1/23
 * Time:17:39
 * Desc:描述该类的作用
 */
@Service
public class UserService {


    @Autowired
    private UserDao userDao;


    @Transactional
    public  User getUser(Integer userId){
       return userDao.getUser(userId);
    }
    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user)  {
       return this.userDao.login(user);
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @Transactional
    public Integer modifyPassword( User user)  {
        return this.userDao.modifyPassword(user);
    }

}
