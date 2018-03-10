package com.github.stu.model;

import javax.persistence.*;

@Entity
@Table(name = "t_grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gradeId")
    private int gradeId;
    @Column(name = "gradeName")
    private String gradeName;
    @Column(name = "gradeDesc")
    private String gradeDesc;

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

    public String getGradeDesc() {
        return gradeDesc;
    }

    public void setGradeDesc(String gradeDesc) {
        this.gradeDesc = gradeDesc;
    }

}
