package com.github.stu.model;

import java.util.Date;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentId")
    private String studentId;
    @Column(name = "stuNo")
    private String stuNo;
    @Column(name = "stuName")
    private String stuName;
    @Column(name = "stuSex")
    private String stuSex = "-1";

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "stuBirthday")
    private Date stuBirthday;
    @Column(name = "stuRxsj")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date stuRxsj;
    @Column(name = "stuNation")
    private String stuNation = "-1";
    @Column(name = "stuZzmm")
    private String stuZzmm = "-1";
    @Column(name = "classId")
    private int classId = -1;
    @Column(name = "className")
    private String className;
    @Column(name = "gradeId")
    private int gradeId = -1;
    @Column(name = "gradeName")
    private String gradeName;
    @Column(name = "stuDesc")
    private String stuDesc;
    @Column(name = "stuPic")
    private String stuPic;


    private String s_b_stuBirthday;

    private String s_e_stuBirthday;

    private String s_b_stuRxsj;

    private String s_e_stuRxsj;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public Date getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(Date stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public Date getStuRxsj() {
        return stuRxsj;
    }

    public void setStuRxsj(Date stuRxsj) {
        this.stuRxsj = stuRxsj;
    }

    public String getStuNation() {
        return stuNation;
    }

    public void setStuNation(String stuNation) {
        this.stuNation = stuNation;
    }

    public String getStuZzmm() {
        return stuZzmm;
    }

    public void setStuZzmm(String stuZzmm) {
        this.stuZzmm = stuZzmm;
    }

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

    public String getStuDesc() {
        return stuDesc;
    }

    public void setStuDesc(String stuDesc) {
        this.stuDesc = stuDesc;
    }

    public String getStuPic() {
        return stuPic;
    }

    public void setStuPic(String stuPic) {
        this.stuPic = stuPic;
    }

    public String getS_b_stuBirthday() {
        return s_b_stuBirthday;
    }

    public void setS_b_stuBirthday(String s_b_stuBirthday) {
        this.s_b_stuBirthday = s_b_stuBirthday;
    }

    public String getS_e_stuBirthday() {
        return s_e_stuBirthday;
    }

    public void setS_e_stuBirthday(String s_e_stuBirthday) {
        this.s_e_stuBirthday = s_e_stuBirthday;
    }

    public String getS_b_stuRxsj() {
        return s_b_stuRxsj;
    }

    public void setS_b_stuRxsj(String s_b_stuRxsj) {
        this.s_b_stuRxsj = s_b_stuRxsj;
    }

    public String getS_e_stuRxsj() {
        return s_e_stuRxsj;
    }

    public void setS_e_stuRxsj(String s_e_stuRxsj) {
        this.s_e_stuRxsj = s_e_stuRxsj;
    }

}
