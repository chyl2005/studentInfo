package com.github.stu.model;

import javax.persistence.*;

@Entity
@Table(name = "t_datadictype")
public class DataDicType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ddTypeId")
    private int ddTypeId;
    @Column(name = "ddTypeName")
    private String ddTypeName;
    @Column(name = "ddTypeDesc")
    private String ddTypeDesc;

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

    public String getDdTypeDesc() {
        return ddTypeDesc;
    }

    public void setDdTypeDesc(String ddTypeDesc) {
        this.ddTypeDesc = ddTypeDesc;
    }

}
