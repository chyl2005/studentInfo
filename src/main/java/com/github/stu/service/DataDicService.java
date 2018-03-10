package com.github.stu.service;

import java.util.List;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.stu.dao.AoData;
import com.github.stu.dao.DataDicDao;
import com.github.stu.dao.DataDicTypeDao;
import com.github.stu.enums.DataDicTypeEnum;
import com.github.stu.model.DataDic;
import com.github.stu.model.DataDicType;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:17:15
 * Desc:描述该类的作用
 */
@Service
public class DataDicService {

    @Autowired
    private DataDicDao dataDicDao;
    @Autowired
    private DataDicTypeDao dataDicTypeDao;

    public DataDic findById(Integer ddId) {
        return dataDicDao.findById(ddId);
    }

    public AoData list(String ddTypeName){
        List<DataDicType> dataDicTypes = dataDicTypeDao.findDataDicTypes(ddTypeName);
        TreeSet<Integer> ddTypeIds = new TreeSet<>();
        for (DataDicType dataDicType : dataDicTypes) {
            ddTypeIds.add(dataDicType.getDdTypeId());
        }
        return  dataDicDao.list(ddTypeIds);
    }

    public List<DataDic> findAllDataDics() {
        return this.dataDicDao.findAllDataDics();
    }

    public List<DataDic> getSexList() {
        return this.dataDicDao.getDataDicList(DataDicTypeEnum.SEX.getCode());
    }

    public List<DataDic> getZzmmDataDicList(){
        return this.dataDicDao.getDataDicList(DataDicTypeEnum.ZZMM.getCode());
    }
    public List<DataDic> getNationList() {
        return this.dataDicDao.getDataDicList(DataDicTypeEnum.NATION.getCode());
    }

    @Transactional
    public DataDic saveEntity(DataDic dataDic) {
        return this.dataDicDao.saveEntity(dataDic);
    }

    @Transactional
    public DataDic updateEntity(DataDic dataDic) {
        return this.dataDicDao.updateEntity(dataDic);
    }

    @Transactional
    public DataDic deleteEntity(Integer ddId) {
        return this.dataDicDao.deleteEntity(ddId);
    }
}
