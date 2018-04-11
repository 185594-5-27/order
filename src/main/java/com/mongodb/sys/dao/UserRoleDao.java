package com.mongodb.sys.dao;

import com.mongodb.common.base.dao.MongodbBaseDao;
import com.mongodb.sys.entity.QueryUserRole;
import com.mongodb.sys.entity.UserRole;
import net.sf.json.JSONObject;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRoleDao extends MongodbBaseDao<UserRole,QueryUserRole> {

    /**
     * 功能描述：根据角色ID的集合来获取所有的角色数据
     * @param roles
     * @return
     */
    public List<UserRole> getUserRoleByRoleId(List<UserRole> roles){
        Query query = new Query();
        String [] ids = new String[roles.size()];
        for(int i=0;i<roles.size();i++){
            ids[i] = roles.get(i).getId();
        }
        query.addCriteria(Criteria.where("id").in(ids));
        return mongoTemplate.find(query,UserRole.class);
    }

}
