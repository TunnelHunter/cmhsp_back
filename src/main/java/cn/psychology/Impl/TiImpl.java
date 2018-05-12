package cn.psychology.Impl;

import cn.psychology.dao.TiRepository;
import cn.psychology.entity.Ti;
import cn.psychology.service.TiService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiImpl implements TiService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private TiRepository tiRepository;



    public Ti findByExaminationId(String examinationId) {
        Query query = new Query(Criteria.where("examinationId").is(examinationId));
        Ti ti = mongoTemplate.findOne(query, Ti.class);
        return ti;
    }

    public void saveTi(Ti ti) {
        mongoTemplate.save(ti);
    }
    public void insertTi(String Str){

        String classStr = Str;

        JSONObject parseObject = JSON.parseObject(classStr);
        mongoTemplate.insert(parseObject,"TestCollection");

    }
    public List<Ti> findAll(){
        return mongoTemplate.findAll(Ti.class);
        //return tiRepository.findAll();
    }
    public int count() throws Exception {
        long size = tiRepository.count();
        //System.out.println("-----------"+size+"-------------");
        int count = Integer.valueOf(String.valueOf(size));
        return count;
    }



}
