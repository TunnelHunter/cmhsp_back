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
    public void addmusictofavorite(String songid,Integer userid) {
            Favorite favorite = new Favorite();
            Music music1 = musicRepository.findAllBySongid(songid);
            favorite.setTitle(music1.getSongname());
            favorite.setContext(music1.getSongcontext());
            favorite.setImage(music1.getSongauthor());
            favorite.setType(2);
            favorite.setUserid(userid);
            favoriteRepository.save(favorite);
        return ;
    }
}
