package com.github.stu.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.github.stu.model.Class;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:15:56
 * Desc:描述该类的作用
 */
@Repository
public class ClassDao extends BaseDaoImpl<Class> {

    public Class findById(Integer classId) {
        return this.get(Class.class, classId);
    }

    /**
     * 分页查询
     *
     * @return
     */
    public AoData findPage() {
        String hql = "from Class ";
        return this.findPage(null, hql);
    }

    public List<Class> getClassListByGrdeId(Integer gradeId) {
        return this.find("from Class where gradeId=?", gradeId);
    }

    public Class saveEntity(Class cls) {
        this.save(cls);
        return cls;
    }

    public Class updateEntity(Class cls) {
        this.update(cls);
        return cls;
    }

}
