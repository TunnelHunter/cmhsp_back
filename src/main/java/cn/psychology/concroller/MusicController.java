package cn.psychology.concroller;




import cn.psychology.Impl.MusicImpl;
import cn.psychology.Util.RespCode;
import cn.psychology.Util.RespEntity;
import cn.psychology.dao.MusicRepository;
import cn.psychology.entity.Music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicController {
    @Autowired
    MusicRepository musicRepository;

    @Autowired
    private MusicImpl music;

    @RequestMapping("/musicSceneList")
    public RespEntity findmusiclist(@RequestBody Music music) {
        return new RespEntity(RespCode.SUCCESS,musicRepository.findAllByMusicsceneId(music.getMusicsceneId()));
    }
    @RequestMapping("/music/insert")
    public String insert(){
        String Str = "{\n" +
                "\n" +
                "\t\"musicsceneId\": \"1\",\n" +
                "\t\"musicsceneName\": \"民谣\",\n" +
                "\t\"songid\": \"5\",\n" +
                "\t\"songname\": \"南方姑娘\",\n" +
                "\t\"songauthor\": \"赵雷（雷子）\",\n" +
                "\t\"songcontext\": \"http://m2.music.126.net/HMu8cIcUjkfOUn6AEb-PWQ==/3133608139215522.mp3\"\n" +
                "}";
        music.insertTi(Str);
        return "yes";
    }

}
