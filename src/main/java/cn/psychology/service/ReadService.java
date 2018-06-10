package cn.psychology.service;


import cn.psychology.dao.ReadRepository;
import cn.psychology.entity.ReadTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ReadRepository readRepository;

    //阅读首屏加载接口
    public List<ReadTable> readFirstPage() {
        Criteria cr = new Criteria();
        Query query = new Query(cr.orOperator(Criteria.where("readId").gte(1).lte(3)
                ,Criteria.where("readId").is(8)));
        List<ReadTable> readTable = mongoTemplate.find(query, ReadTable.class);
        return readTable;
    }

    //阅读搜索接口
    public List<ReadTable> readSearch(String keyWord, Boolean readType) {
        Criteria cr = new Criteria();
        Query query = new Query(cr.orOperator(Criteria.where("readAuthor").regex(".*"+keyWord+".*")
                        .and("readType").is(readType)
                ,Criteria.where("readContext").regex(".*"+keyWord+".*")
                        .and("readType").is(readType)));
        List<ReadTable> readTable = mongoTemplate.find(query, ReadTable.class);
        return readTable;
    }

    //获取详细信息接口（书/文章）
    public List<ReadTable> readDetil(Integer readId) {
        return readRepository.findByReadId(readId);
    }

    //获取列表接口（书/文章）
    public List<ReadTable> readList(Boolean readType) {
        return readRepository.findByReadType(readType);
    }

}
