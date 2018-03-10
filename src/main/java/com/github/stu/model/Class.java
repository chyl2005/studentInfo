package com.github.stu.model;

import javax.persistence.*;

@Entity
@Table(name = "t_class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "classId")
    private int classId;
    @Column(name = "className")
    private String className;
    @Column(name = "gradeId")
    private int gradeId = -1;
    @Column(name = "gradeName")
    private String gradeName;
    @Column(name = "classDesc")
    private String classDesc;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

}
