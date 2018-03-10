package com.github.stu.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.github.stu.model.Grade;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:16:42
 * Desc:描述该类的作用
 */
@Repository
public class GradeDao extends BaseDaoImpl<Grade> {

    public Grade findById(Integer gradeId) {
        Grade grade = this.get(Grade.class, gradeId);
        return grade;
    }

    public List<Grade> findAllGrades() {
        return this.find("from Grade");
    }

    public Grade saveEntity(Grade grade) {
        this.save(grade);
        return grade;
    }

    public Grade updateEntity(Grade grade) {
        this.update(grade);
        return grade;
    }

    public Grade  deleteEntity(Integer gradeId){
        Grade grade = this.get(Grade.class, gradeId);
        this.delete(grade);
        return grade;
    }

}
