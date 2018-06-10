package cn.psychology.service;

import cn.psychology.entity.Social;

public interface SocialService {
    public void addsocialtofavorite(Integer uid,String uname,String sid);
    public void  addsocial(Integer uid,String img,String text,String addtime);
    public void  addcomment(String cuid,String sid,String cd,String ct);


}
