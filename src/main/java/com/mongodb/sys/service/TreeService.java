package com.mongodb.sys.service;

import com.mongodb.common.base.dao.MongodbBaseDao;
import com.mongodb.common.base.service.MongodbBaseService;
import com.mongodb.sys.dao.TreeDao;
import com.mongodb.sys.entity.QueryTree;
import com.mongodb.sys.entity.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeService extends MongodbBaseService<Tree,QueryTree> {

    @Autowired
    private TreeDao treeDao;

    @Override
    protected MongodbBaseDao<Tree, QueryTree> getDao() {
        return treeDao;
    }
}
