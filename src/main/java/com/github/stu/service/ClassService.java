package com.github.stu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.github.stu.dao.AoData;
import com.github.stu.dao.ClassDao;
import com.github.stu.model.Class;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:15:56
 * Desc:描述该类的作用
 */
//@Service
public class ClassService {


    private String url;
    private String encode;
    private int connectTimeout;
    @Autowired
    private ClassDao classDao;


    public Class findById(Integer classId) {
      return   this.classDao.findById(classId);
    }
    /**
     * 分页查询
     *
     * @return
     */
    public AoData findPage() {
        String hql = "from Class ";
        return this.classDao.findPage();
    }


    public List<Class> getClassListByGrdeId(Integer gradeId){
        return  this.classDao.getClassListByGrdeId(gradeId);
    }

    @Transactional
    public Class saveEntity(Class cls) {
        return this.classDao.saveEntity(cls);

    }

    @Transactional
    public Class updateEntity(Class cls) {
        return this.classDao.updateEntity(cls);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }
}
