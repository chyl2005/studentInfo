package com.github.stu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.stu.dao.GradeDao;
import com.github.stu.model.Grade;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:16:48
 * Desc:描述该类的作用
 */

@Service
public class GradeService {

    @Autowired
    private GradeDao gradeDao;

    public Grade findById(Integer gradeId) {
        return gradeDao.findById(gradeId);
    }

    public List<Grade> findAllGrades() {
        return this.gradeDao.findAllGrades();
    }

    @Transactional
    public Grade saveEntity(Grade grade) {
        return gradeDao.saveEntity(grade);
    }

    @Transactional
    public Grade updateEntity(Grade grade) {
        return gradeDao.updateEntity(grade);
    }

    @Transactional
    public Grade deleteEntity(Integer gradeId) {
        return gradeDao.deleteEntity(gradeId);
    }

}
