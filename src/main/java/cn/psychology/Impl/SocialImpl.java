package cn.psychology.Impl;


import cn.psychology.dao.FavoriteRepository;
import cn.psychology.dao.SocialRepository;
import cn.psychology.dao.UserRepository;
import cn.psychology.entity.Favorite;
import cn.psychology.entity.Social;
import cn.psychology.entity.User;
import cn.psychology.service.SocialService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SocialImpl implements SocialService {
    @Autowired
    SocialRepository socialRepository;
    @Autowired
    SocialService socialService;
    @Autowired
    FavoriteRepository favoriteRepository;
    @Autowired
    UserRepository userRepository;

    public void addsocialtofavorite(Integer uid, String uname, Integer sid) {
        Favorite favorite = new Favorite();
        Social social =socialRepository.findAllBySocialid(sid);
        favorite.setTitle(uname);
        favorite.setContext(social.getTextdata());
        favorite.setImage(social.getImagedata());
        favorite.setType(1);
        favorite.setUserid(uid);
        favoriteRepository.save(favorite);
    }
    public void  addsocial(Integer uid,String img,String text,String addtime){
        if(socialRepository.count()==0){
            Social social =new Social();
            social.setUserid(uid);
            social.setImagedata(img);
            social.setTextdata(text);
            social.setSocialaddtime(addtime);
            social.setSocialid(1);
            socialRepository.save(social);}
        else{
            List<Social> list1 = socialRepository.findAll();
            Social o1 =list1.get(list1.size()-1);
            Social social =new Social();
            social.setUserid(uid);
            social.setImagedata(img);
            social.setTextdata(text);
            social.setSocialaddtime(addtime);
            social.setSocialid(o1.getSocialid()+1);
            socialRepository.save(social);}
    }


    public void addcomment(Integer cuid, Integer sid, String cd, String ct) {

        Social social = socialRepository.findAllBySocialid(sid);
        if (social.getComments()!=null) {
            ArrayList a = social.getComments();
            Social.Comments nc = social.new Comments();
            nc.setCommenttype(1);
            nc.setCuserid(cuid);
            nc.setCommentData(cd);
            nc.setCommenttime(ct);
            a.add(nc);
            social.setComments(a);
            socialRepository.save(social);
        }
        else{
            ArrayList a1 =new ArrayList();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cuserid",cuid);
            jsonObject.put("commentData",cd);
            jsonObject.put("commenttime",ct);
            a1.add(0,jsonObject);
            social.setComments(a1);
            socialRepository.save(social);
        }
    }
}
