package cn.psychology.service;

import cn.psychology.entity.Favorite;
import cn.psychology.entity.Music;
import cn.psychology.entity.User;

public interface MusicService {
    public int addmusictofavorite(String songid,Integer userid);

}
