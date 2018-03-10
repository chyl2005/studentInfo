package com.github.stu.dao;

import org.springframework.stereotype.Repository;
import com.github.stu.model.User;




@Repository
public class UserDao extends BaseDaoImpl<User> {



    public  User getUser(Integer userId){
       return this.get(User.class,userId);
    }
    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user)  {
        User user1 = this.get("from User where  userName=? and password=?", user.getUserName(), user.getPassword());
        if (user1 == null) {
            return user;
        }
        return null;
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    public Integer modifyPassword( User user)  {
        User oldUser = this.get("from User where userId=?", user.getUserId());
        oldUser.setPassword(user.getPassword());
        this.update(oldUser);
        return oldUser.getUserId();
    }
}
