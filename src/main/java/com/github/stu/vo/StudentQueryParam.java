package com.github.stu.vo;

import java.util.Date;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:19:45
 * Desc:描述该类的作用
 */
public class StudentQueryParam {

    private String stuNo;
    private String stuName;
    private Integer stuSex;
    private String stuNation;
    private Integer gradeId;
    private Integer classId;
    private Date startBirthday;
    private Date endBirthday;
    private Date startRxsj;
    private Date endRxsj;

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

    public Integer getStuSex() {
        return stuSex;
    }

    public void setStuSex(Integer stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuNation() {
        return stuNation;
    }

    public void setStuNation(String stuNation) {
        this.stuNation = stuNation;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Date getStartBirthday() {
        return startBirthday;
    }

    public void setStartBirthday(Date startBirthday) {
        this.startBirthday = startBirthday;
    }

    public Date getEndBirthday() {
        return endBirthday;
    }

    public void setEndBirthday(Date endBirthday) {
        this.endBirthday = endBirthday;
    }

    public Date getStartRxsj() {
        return startRxsj;
    }

    public void setStartRxsj(Date startRxsj) {
        this.startRxsj = startRxsj;
    }

    public Date getEndRxsj() {
        return endRxsj;
    }

    public void setEndRxsj(Date endRxsj) {
        this.endRxsj = endRxsj;
    }
}
