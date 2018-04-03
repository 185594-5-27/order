package com.mongodb.sys.service;

import com.mongodb.common.base.dao.MongodbBaseDao;
import com.mongodb.common.base.service.MongodbBaseService;
import com.mongodb.sys.dao.OrgGroupDao;
import com.mongodb.sys.entity.OrgGroup;
import com.mongodb.sys.entity.QueryOrgGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
* 类描述：
* @auther linzf
* @create 2018/4/3 0003 
*/
@Service
public class OrgGroupService extends MongodbBaseService<OrgGroup,QueryOrgGroup> {

    @Autowired
    private OrgGroupDao orgGroupDao;

    @Override
    protected MongodbBaseDao<OrgGroup, QueryOrgGroup> getDao() {
        return orgGroupDao;
    }
}
