package cn.psychology.service;

import cn.psychology.entity.Social;

public interface SocialService {
    public int addsocialtofavorite(Integer uid,String uname,Integer sid);
    public void  addsocial(Integer uid,String img,String text,String addtime);
    public void  addcomment(Integer cuid,Integer sid,String cd,String ct);

}
