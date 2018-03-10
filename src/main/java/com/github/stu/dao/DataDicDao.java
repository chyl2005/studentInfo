package com.github.stu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;
import com.github.stu.model.DataDic;

/**
 * Author:chyl2005
 * Date:17/2/3
 * Time:17:17
 * Desc:描述该类的作用
 */
@Repository
public class DataDicDao extends BaseDaoImpl<DataDic> {

    public DataDic findById(Integer ddId) {
        DataDic dataDic = this.get(DataDic.class, ddId);
        return dataDic;
    }

    public AoData list(Set<Integer> ddTypeIds) {
        Map<String, Object> params = new HashMap<>();
        StringBuilder hql = new StringBuilder("from DataDic  ");
        if (CollectionUtils.isNotEmpty(ddTypeIds)) {
            hql.append("ddTypeId in(:ddTypeId)");
            params.put("ddTypeId", ddTypeIds);
        }
        return this.findPage(null, hql.toString(), params);
    }

    public List<DataDic> getDataDicList(Integer ddTypeId) {
        return this.find("from DataDic where ddTypeId=?", ddTypeId);
    }

    public List<DataDic> findAllDataDics() {

        return this.find("from DataDic");
    }

    public DataDic saveEntity(DataDic dataDic) {
        this.save(dataDic);
        return dataDic;
    }

    public DataDic updateEntity(DataDic dataDic) {

        this.update(dataDic);
        return dataDic;
    }

    public DataDic deleteEntity(Integer ddId) {
        DataDic dataDic = this.get(DataDic.class, ddId);
        this.delete(dataDic);
        return dataDic;
    }

}
