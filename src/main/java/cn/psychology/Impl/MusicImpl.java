package cn.psychology.Impl;


import cn.psychology.dao.FavoriteRepository;
import cn.psychology.dao.MusicRepository;
import cn.psychology.dao.UserRepository;
import cn.psychology.entity.Favorite;
import cn.psychology.entity.Music;
import cn.psychology.entity.User;
import cn.psychology.service.MusicService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicImpl implements MusicService {
//苗哥写的
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Autowired
//    private MusicRepository musicRepository;
//
//    public void insertTi(String Str){
//
//        String classStr = Str;
//
//        JSONObject parseObject = JSON.parseObject(classStr);
//        mongoTemplate.insert(parseObject,"Music");
//
//    }
//    public int count() throws Exception {
//        long size = musicRepository.count();
//        //System.out.println("-----------"+size+"-------------");
//        int count = Integer.valueOf(String.valueOf(size));
//        return count;
//    }
@Autowired
MusicRepository musicRepository;
@Autowired
    FavoriteRepository favoriteRepository;
    public int addmusictofavorite(String songid,Integer userid) {
            Favorite favorite = new Favorite();
            Music music1 = musicRepository.findAllBySongId(songid);
            //防止重复收藏
        Favorite favoriteCharge = new Favorite();
        favoriteCharge =  favoriteRepository.findBySourceidAndAndTypeAndAndUserid(music1.getSongId(),2,userid);
            if(favoriteCharge !=null){
                //已有该条收藏
                return 1;
            }else {
                favorite.setTitle(music1.getSongName());
                favorite.setContext(music1.getSongAuthor());
                favorite.setImage(music1.getSongAuthor());
                favorite.setType(2);
                favorite.setUserid(userid);
                favorite.setSourceid(music1.getSongId());
                favoriteRepository.save(favorite);
                return 0;
            }
    }
}
