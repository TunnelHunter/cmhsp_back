package cn.psychology.concroller;




import cn.psychology.Impl.MusicImpl;
import cn.psychology.Util.RespCode;
import cn.psychology.Util.RespEntity;
import cn.psychology.dao.MusicRepository;
import cn.psychology.entity.Favorite;
import cn.psychology.entity.Music;

import cn.psychology.entity.User;
import cn.psychology.service.MusicService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class MusicController {
    @Autowired
    MusicRepository musicRepository;

  //  @Autowired
  // private MusicImpl music;

    @RequestMapping(value="/CMHSP/musicSceneList",produces="application/json;charset=UTF-8")//通过场景id获取所以音乐
    public RespEntity findmusiclist(@RequestBody Music music) {
        return new RespEntity(RespCode.SUCCESS,musicRepository.findAllByMusicsceneId(music.getMusicsceneId()));
    }

    
    @Autowired
    MusicService musicService;
    @PreAuthorize("hasRole('USER')")
    @RequestMapping("/CMHSP/musicFavorite")//收藏音乐
    public RespEntity favoritemusic(@RequestBody com.alibaba.fastjson.JSONObject object) {
        com.alibaba.fastjson.JSONObject ob =object;
        String sid =ob.get("songId").toString();
        Integer uid =ob.getInteger("userId");

//        musicService.addmusictofavorite(sid,uid);
//        return new RespEntity(RespCode.SUCCESS);
        int Result = musicService.addmusictofavorite(sid,uid);
        if(Result == 0){
            return new RespEntity(RespCode.SUCCESS);
        }else{
            return new RespEntity(RespCode.ERROR);
        }
    }
}
