package com.mongodb.sys.service;

import com.mongodb.common.base.dao.MongodbBaseDao;
import com.mongodb.common.base.entity.Pagination;
import com.mongodb.common.base.service.MongodbBaseService;
import com.mongodb.sys.dao.DictDao;
import com.mongodb.sys.entity.Dict;
import com.mongodb.sys.entity.QueryDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class DictService extends MongodbBaseService<Dict,QueryDict> {

    @Autowired
    private DictDao dictDao;

    @Override
    protected MongodbBaseDao<Dict, QueryDict> getDao() {
        return dictDao;
    }

    /**
     * 功能描述：实现数据字典的分页逻辑
     * @param entity
     * @return
     */
    public Pagination<Dict> findByPage(QueryDict entity){
        Query query = new Query();
        if(entity.getCode()!=null&&!entity.getCode().equals("")){
            query.addCriteria(Criteria.where("code").regex(".*?"+entity.getCode()+".*"));
        }
        if(entity.getText()!=null&&!entity.getText().equals("")){
            query.addCriteria(Criteria.where("text").regex(".*?"+entity.getText()+".*"));
        }
        if(entity.getType()!=null&&!entity.getType().equals("")){
            query.addCriteria(Criteria.where("type").regex(".*?"+entity.getType()+".*"));
        }
        if(entity.getValue()!=null&&!entity.getValue().equals("")){
            query.addCriteria(Criteria.where("value").regex(".*?"+entity.getValue()+".*"));
        }
        return dictDao.findByPage(entity,query);
    }

}
