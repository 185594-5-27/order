package com.mongodb.sys.dao;

import com.mongodb.common.base.dao.MongodbBaseDao;
import com.mongodb.sys.entity.Dict;
import com.mongodb.sys.entity.QueryDict;
import org.springframework.stereotype.Component;

@Component
public class DictDao extends MongodbBaseDao<Dict,QueryDict> {

}
