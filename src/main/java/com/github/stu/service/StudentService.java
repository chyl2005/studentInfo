package com.github.stu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.stu.dao.AoData;
import com.github.stu.dao.StudentDao;
import com.github.stu.model.Student;
import com.github.stu.vo.StudentQueryParam;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:20:13
 * Desc:描述该类的作用
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public AoData findStudentPage(StudentQueryParam query) {
        return this.studentDao.findStudentPage(query);
    }

    public Student findById(Integer studentId) {
        Student student = this.studentDao.findById(studentId);
        return student;
    }

    @Transactional
    public Student saveEntity(Student student) {
        this.studentDao.saveEntity(student);
        return student;
    }

    @Transactional
    public Student updateEntity(Student student) {
        this.studentDao.updateEntity(student);
        return student;
    }

    @Transactional
    public Student deleteEntity(Integer studentId) {
        Student student = this.studentDao.deleteEntity(studentId);
        return student;
    }
}
