package com.github.stu.model;

import javax.persistence.*;

@Entity
@Table(name = "t_datadic")
public class DataDic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ddId")
    private int ddId;
    @Column(name = "ddTypeId")
    private int ddTypeId = -1;
    @Column(name = "ddTypeName")
    private String ddTypeName;
    @Column(name = "ddValue")
    private String ddValue;
    @Column(name = "ddDesc")
    private String ddDesc;

    public int getDdId() {
        return ddId;
    }

    public void setDdId(int ddId) {
        this.ddId = ddId;
    }

    public int getDdTypeId() {
        return ddTypeId;
    }

    public void setDdTypeId(int ddTypeId) {
        this.ddTypeId = ddTypeId;
    }

    public String getDdTypeName() {
        return ddTypeName;
    }

    public void setDdTypeName(String ddTypeName) {
        this.ddTypeName = ddTypeName;
    }

    public String getDdValue() {
        return ddValue;
    }

    public void setDdValue(String ddValue) {
        this.ddValue = ddValue;
    }

    public String getDdDesc() {
        return ddDesc;
    }

    public void setDdDesc(String ddDesc) {
        this.ddDesc = ddDesc;
    }

}
