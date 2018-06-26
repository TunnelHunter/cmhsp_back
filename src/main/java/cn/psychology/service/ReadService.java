package cn.psychology.service;


import cn.psychology.dao.FavoriteRepository;
import cn.psychology.dao.ReadRepository;
import cn.psychology.entity.Favorite;
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
    @Autowired
    private FavoriteRepository favoriteRepository;

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
    public ReadTable readDetil(Integer readId) {
        return readRepository.findByReadId(readId);
    }

    //获取列表接口（书/文章）
    public List<ReadTable> readList(Boolean readType) {
        return readRepository.findByReadType(readType);
    }

    //添加收藏接口（书/文章）
    public int addFavorite(String readId,Integer userid){
        ReadTable readTable = readRepository.findByReadId(Integer.parseInt(readId));
        Favorite favoriteCharge = new Favorite();
        favoriteCharge = favoriteRepository.findBySourceidAndAndType(readTable.getReadId(),3);
        //防止重复添加
        if( favoriteCharge!=null ){
            //已有该条收藏，不用重复添加
            return 1;
        }else {
            Favorite favorite = new Favorite();
            favorite.setUserid(userid);
            favorite.setSourceid(readTable.getReadId());
            favorite.setContext(readTable.getReadAuthor());
            favorite.setImage(readTable.getReadImage());
            favorite.setTitle(readTable.getReadTitle());
            favorite.setType(3);
            favoriteRepository.save(favorite);
            return 0;
        }

    }

}
