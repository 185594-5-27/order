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


}
