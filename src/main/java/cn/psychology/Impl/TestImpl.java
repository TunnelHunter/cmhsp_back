package cn.psychology.Impl;

import cn.psychology.dao.TestRepository;
import cn.psychology.entity.ExamPaper;
import cn.psychology.service.TestService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestImpl implements TestService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private TestRepository testRepository;



    public ExamPaper findByExaminationId(String examinationId) {
        Query query = new Query(Criteria.where("examinationId").is(examinationId));
        ExamPaper ti = mongoTemplate.findOne(query, ExamPaper.class);
        return ti;
    }

    public void saveTi(ExamPaper ti) {
        mongoTemplate.save(ti);
    }
    public void insertTi(String Str){

        String classStr = Str;

        JSONObject parseObject = JSON.parseObject(classStr);
        mongoTemplate.insert(parseObject,"TestCollection");

    }
    public List<ExamPaper> findAll(){
        return mongoTemplate.findAll(ExamPaper.class);
        //return tiRepository.findAll();
    }
    public int count() throws Exception {
        long size = testRepository.count();
        //System.out.println("-----------"+size+"-------------");
        int count = Integer.valueOf(String.valueOf(size));
        return count;
    }



}
