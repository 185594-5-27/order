package com.mongodb.sys.dao;

import com.mongodb.common.base.dao.MongodbBaseDao;
import com.mongodb.sys.entity.QueryTree;
import com.mongodb.sys.entity.Tree;
import org.springframework.stereotype.Component;

@Component
public class TreeDao extends MongodbBaseDao<Tree,QueryTree> {



}
