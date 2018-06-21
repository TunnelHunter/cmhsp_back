package cn.psychology.secutity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class SysUserImpl implements SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(String str){

        String classStr = str;

        JSONObject parseObject = JSON.parseObject(classStr);
        mongoTemplate.insert(parseObject,"Secuser");
    }

}
