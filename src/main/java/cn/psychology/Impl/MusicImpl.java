package cn.psychology.Impl;


import cn.psychology.dao.MusicRepository;
import cn.psychology.entity.Music;
import cn.psychology.service.MusicService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class MusicImpl implements MusicService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MusicRepository musicRepository;

    public void insertTi(String Str){

        String classStr = Str;

        JSONObject parseObject = JSON.parseObject(classStr);
        mongoTemplate.insert(parseObject,"Music");

    }
    public int count() throws Exception {
        long size = musicRepository.count();
        //System.out.println("-----------"+size+"-------------");
        int count = Integer.valueOf(String.valueOf(size));
        return count;
    }


}
