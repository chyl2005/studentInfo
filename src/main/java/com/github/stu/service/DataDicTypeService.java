package com.github.stu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.stu.dao.DataDicTypeDao;
import com.github.stu.model.DataDicType;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:17:26
 * Desc:描述该类的作用
 */
@Service
public class DataDicTypeService {

    @Autowired
    private DataDicTypeDao dataDicTypeDao;

    public DataDicType findById(Integer ddTypeId) {
        return this.dataDicTypeDao.findById(ddTypeId);

    }



    public List<DataDicType> findAllDataDicTypes() {
        return this.dataDicTypeDao.findAllDataDicTypes();
    }

    @Transactional
    public DataDicType saveEntity(DataDicType dataDicType) {

        return this.dataDicTypeDao.saveEntity(dataDicType);
    }

    @Transactional
    public DataDicType updateEntity(DataDicType dataDicType) {
        return this.dataDicTypeDao.updateEntity(dataDicType);
    }

    @Transactional
    public DataDicType deleteEntity(Integer ddTypeId) {
        return this.dataDicTypeDao.deleteEntity(ddTypeId);
    }
}
