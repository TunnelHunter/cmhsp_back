package cn.psychology.service;


import cn.psychology.Util.ReadType;
import cn.psychology.dao.FavoriteRepository;
import cn.psychology.dao.ReadRepository;
import cn.psychology.entity.Favorite;
import cn.psychology.entity.ReadTable;
import org.json.JSONObject;
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
    public JSONObject readFirstPage() {
        JSONObject result = new JSONObject();
        List<ReadTable> readTable = null;
        Criteria cr = new Criteria();
        //slide
        Query query = new Query(Criteria.where("readType").is(ReadType.ESSAY.getIndex())
                //,Criteria.where("readId").is(8)
        );
        List<ReadTable> resLists = mongoTemplate.find(query, ReadTable.class);
         readTable = mongoTemplate.find(query, ReadTable.class); //给哥地址
        readTable.clear();
        for(ReadTable entity:resLists){
            if( readTable.size()<5 ){
                readTable.add(entity);
            }
        }
         result.put("slide",readTable);
         //book
        Query query2 = new Query(Criteria.where("readType").is(ReadType.BOOK.getIndex())
                //,Criteria.where("readId").is(8)
        );
        List<ReadTable> resList= mongoTemplate.find(query2, ReadTable.class);
        readTable.clear();
        for(ReadTable entity:resList){
            if( readTable.size()<6 ){
                readTable.add(entity);
            }
        }
        result.put("book",readTable);

        //essay
        Query query3 = new Query(Criteria.where("readType").is(ReadType.ESSAY.getIndex())
                //,Criteria.where("readId").is(8)
        );
        List<ReadTable> resListEssay= mongoTemplate.find(query3, ReadTable.class);
        readTable.clear();
        for(ReadTable entity:resListEssay){
            if( readTable.size()<6 ){
                readTable.add(entity);
            }
        }
        result.put("essay",readTable);
        return result;
        //return readTable;

    }




    //阅读搜索接口
    public List<ReadTable> readSearch(String keyWord, int readType) {
        Criteria cr = new Criteria();
        Query query = new Query(cr.orOperator(Criteria.where("readAuthor").regex(".*"+keyWord+".*")
                        .and("readType").is(readType)
                ,Criteria.where("readContext").regex(".*"+keyWord+".*")
                        .and("readType").is(readType)));
        List<ReadTable> readTable = mongoTemplate.find(query, ReadTable.class);
        return readTable;
    }

    //获取详细信息接口（书/文章）
    public ReadTable readDetil(String readId) {
        return readRepository.findByReadId(readId);
    }

    //获取列表接口（书/文章）
    public List<ReadTable> readList(int readType) {
        return readRepository.findByReadType(readType);
    }

    //添加收藏接口（书/文章）
    public int addFavorite(String readId,Integer userid){
        ReadTable readTable = readRepository.findByReadId(readId);
        Favorite favoriteCharge = new Favorite();
        favoriteCharge = favoriteRepository.findBySourceidAndAndTypeAndAndUserid(readTable.getReadId(),3,userid);
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
