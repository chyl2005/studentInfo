package com.github.stu.dao;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import com.github.stu.model.Student;
import com.github.stu.vo.StudentQueryParam;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:19:41
 * Desc:描述该类的作用
 */
@Repository
public class StudentDao extends BaseDaoImpl<Student> {

    /**
     *
     * @param query
     * @return
     */
    public AoData findStudentPage(StudentQueryParam query) {
        Map<String, Object> params = new HashMap<>();
        StringBuilder hql = new StringBuilder("from Student ");
        if (query.getClassId() != null) {
            hql.append(" classId=:classId");
            params.put("classId", query.getClassId());
        }
        if (query.getGradeId() != null) {
            hql.append(" gradeId=:gradeId");
            params.put("gradeId", query.getGradeId());
        }
        if (StringUtils.isNotBlank(query.getStuName())) {
            hql.append(" and stuName   like '%" + query.getStuName() + "%'");
        }
        if (StringUtils.isNotBlank(query.getStuNation())) {
            hql.append(" stuNation=:stuNation");
            params.put("stuNation", query.getStuNation());
        }
        if (query.getStuSex() != null) {
            hql.append(" stuSex=:stuSex");
            params.put("stuSex", query.getStuSex());
        }
        if (query.getStartBirthday() != null && query.getEndBirthday() != null) {
            hql.append(" stuBirthday between " + query.getStartBirthday() + " and " + query.getEndBirthday());
        }
        if (query.getStartRxsj() != null && query.getEndRxsj() != null) {
            hql.append(" stuRxsj between " + query.getStartRxsj() + " and " + query.getEndRxsj());
        }
        return this.findPage(null, hql.toString(), params);
    }



    public Student findById(Integer studentId) {
        Student student = this.get(Student.class, studentId);
        return student;
    }



    public Student saveEntity(Student student) {
        this.save(student);
        return student;
    }

    public Student updateEntity(Student student) {
        this.update(student);
        return student;
    }

    public Student  deleteEntity(Integer studentId){
        Student student = this.get(Student.class, studentId);
        this.delete(student);
        return student;
    }

}
