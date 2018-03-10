package com.github.stu.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.github.stu.model.DataDicType;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:17:26
 * Desc:描述该类的作用
 */
@Repository
public class DataDicTypeDao extends BaseDaoImpl<DataDicType> {

    public DataDicType findById(Integer ddTypeId) {
        return this.get(DataDicType.class, ddTypeId);

    }


    public List<DataDicType> findDataDicTypes(String ddTypeName){
        return this.find("from DataDicType ddTypeName like '%" + ddTypeName + "%'");
    }


    public List<DataDicType> findAllDataDicTypes(){
       return this.find("from DataDicType");
    }


    public DataDicType saveEntity(DataDicType dataDicType) {
        this.save(dataDicType);
        return dataDicType;
    }

    public DataDicType updateEntity(DataDicType dataDicType) {
        this.update(dataDicType);
        return dataDicType;
    }

    public DataDicType deleteEntity(Integer ddTypeId) {
        DataDicType dataDicType = this.get(DataDicType.class, ddTypeId);
        this.delete(dataDicType);
        return dataDicType;
    }
}
