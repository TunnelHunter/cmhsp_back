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
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class MusicController {
    @Autowired
    MusicRepository musicRepository;

  //  @Autowired
  // private MusicImpl music;

    @RequestMapping(value="/musicSceneList",produces="application/json;charset=UTF-8")//通过场景id获取所以音乐
    public RespEntity findmusiclist(@RequestBody Music music) {
        return new RespEntity(RespCode.SUCCESS,musicRepository.findAllByMusicsceneId(music.getMusicsceneId()));
    }
    //苗哥写的
//    @RequestMapping("/music/insert")
//    public String insert(){
//        String Str = "{\n" +
//                "\n" +
//                "\t\"musicsceneId\": \"1\",\n" +
//                "\t\"musicsceneName\": \"民谣\",\n" +
//                "\t\"songid\": \"5\",\n" +
//                "\t\"songname\": \"南方姑娘\",\n" +
//                "\t\"songauthor\": \"赵雷（雷子）\",\n" +
//                "\t\"songcontext\": \"http://m2.music.126.net/HMu8cIcUjkfOUn6AEb-PWQ==/3133608139215522.mp3\"\n" +
//                "}";
//        music.insertTi(Str);
//        return "yes";
//    }
    @Autowired
    MusicService musicService;
    @RequestMapping("/musicFavorite")//收藏音乐
    public RespEntity favoritemusic(@RequestBody com.alibaba.fastjson.JSONObject object) {
        com.alibaba.fastjson.JSONObject ob =object;
        String sid =ob.get("songid").toString();
        Integer uid =ob.getInteger("userid");
        musicService.addmusictofavorite(sid,uid);
        return new RespEntity(RespCode.SUCCESS);
    }
}
