package cn.psychology.service;

import cn.psychology.entity.Favorite;
import cn.psychology.entity.Music;
import cn.psychology.entity.User;

public interface MusicService {
    public void addmusictofavorite(String songid,Integer userid);

}
