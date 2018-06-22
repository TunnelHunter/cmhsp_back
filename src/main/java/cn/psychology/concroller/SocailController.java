package cn.psychology.concroller;

import cn.psychology.Util.RespCode;
import cn.psychology.Util.RespEntity;
import cn.psychology.dao.SocialRepository;
import cn.psychology.dao.UserRepository;
import cn.psychology.entity.Social;
import cn.psychology.entity.User;
import cn.psychology.service.MusicService;
import cn.psychology.service.SocialService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class SocailController {
    @Autowired
    SocialRepository socialRepository;
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/CMHSP/socialFreshDown")//下拉刷新获取最新五条动态
    public RespEntity showsociallist() {
        List<Social> list1 = socialRepository.findAll();
        Collections.reverse(list1); // 倒序排列
        if(list1.size()>4){
            List<Social> newlist = list1.subList(0, 5);
            JSONArray jsonArray =new JSONArray();
            for( int i=0;i<5;i++ ){
                JSONObject jsonObject = new JSONObject();
                User user1= userRepository.findAllByUserId(newlist.get(i).getUserid());
                Social social = newlist.get(i);
                jsonObject.put("userid",user1.getUserId());
                jsonObject.put("username",user1.getUsername());
                jsonObject.put("imageAddre",user1.getImageAddre());
                jsonObject.put("socialid",social.getSocialid());
                jsonObject.put("socialaddtime",social.getSocialaddtime());
                jsonObject.put("textdata",social.getTextdata());
                jsonObject.put("imagedata",social.getImagedata());
                // 评论包含用户头像姓名的新的对象
                if(social.getComments()==null){jsonObject.put("comments",null);}else{
                    JSONArray cjsonArray =new JSONArray();
                    for(int k=0;k<social.getComments().size();k++){
                        List<Social.Comments> cnewlist =social.getComments();
                        JSONObject cjsonObject=new JSONObject();
                        User cuser =userRepository.findAllByUserId(cnewlist.get(k).getCuserid());
                        cjsonObject.put("cuserid",cuser.getUserId());
                        cjsonObject.put("cusername",cuser.getUsername());
                        cjsonObject.put("cuserimg",cuser.getImageAddre());
                        cjsonObject.put("commentData",cnewlist.get(k).getCommentData());
                        cjsonObject.put("commenttime",cnewlist.get(k).getCommenttime());
                        cjsonArray.add(cjsonObject);
                    }
                    jsonObject.put("comments",cjsonArray);}
                jsonArray.add(jsonObject);
            }
            return new RespEntity(RespCode.SUCCESS,jsonArray);}
        else
        { List<Social> newlist = list1.subList(0, list1.size());
            JSONArray jsonArray =new JSONArray();
            for( int i=0;i<list1.size();i++ ){
                JSONObject jsonObject = new JSONObject();
                User user1= userRepository.findAllByUserId(newlist.get(i).getUserid());
                Social social = newlist.get(i);
                jsonObject.put("userid",user1.getUserId());
                jsonObject.put("username",user1.getUsername());
                jsonObject.put("imageAddre",user1.getImageAddre());
                jsonObject.put("socialid",social.getSocialid());
                jsonObject.put("socialaddtime",social.getSocialaddtime());
                jsonObject.put("textdata",social.getTextdata());
                jsonObject.put("imagedata",social.getImagedata());
                // 评论包含用户头像姓名的新的对象
                if(social.getComments()==null){jsonObject.put("comments",null);}else{
                    JSONArray cjsonArray =new JSONArray();
                    for(int k=0;k<social.getComments().size();k++){
                        List<Social.Comments> cnewlist =social.getComments();
                        JSONObject cjsonObject=new JSONObject();
                        User cuser =userRepository.findAllByUserId(cnewlist.get(k).getCuserid());
                        cjsonObject.put("cuserid",cuser.getUserId());
                        cjsonObject.put("cusername",cuser.getUsername());
                        cjsonObject.put("cuserimg",cuser.getImageAddre());
                        cjsonObject.put("commentData",cnewlist.get(k).getCommentData());
                        cjsonObject.put("commenttime",cnewlist.get(k).getCommenttime());
                        cjsonArray.add(cjsonObject);
                    }
                    jsonObject.put("comments",cjsonArray);}
                jsonArray.add(jsonObject);
            }
            return new RespEntity(RespCode.SUCCESS,jsonArray);}
    }

    @RequestMapping("/CMHSP/socialFreshUp")//上拉刷新获取接下来五条动态
    public RespEntity shownextsociallist(@RequestBody Social social1) {
        List a = socialRepository.findBySocialidLessThan(social1.getSocialid());
        Collections.reverse(a); // 倒序排列
        if(a.size()>4){
            List<Social> newlist = a.subList(0, 5);
            JSONArray jsonArray =new JSONArray();
            for( int i=0;i<5;i++ ){
                JSONObject jsonObject = new JSONObject();
                User user1= userRepository.findAllByUserId(newlist.get(i).getUserid());
                Social social = newlist.get(i);
                jsonObject.put("userid",user1.getUserId());
                jsonObject.put("username",user1.getUsername());
                jsonObject.put("imageAddre",user1.getImageAddre());
                jsonObject.put("socialid",social.getSocialid());
                jsonObject.put("socialaddtime",social.getSocialaddtime());
                jsonObject.put("textdata",social.getTextdata());
                jsonObject.put("imagedata",social.getImagedata());
                // 评论包含用户头像姓名的新的对象
                if(social.getComments()==null){jsonObject.put("comments",null);}else{
                    JSONArray cjsonArray =new JSONArray();
                    for(int k=0;k<social.getComments().size();k++){
                        List<Social.Comments> cnewlist =social.getComments();
                        JSONObject cjsonObject=new JSONObject();
                        User cuser =userRepository.findAllByUserId(cnewlist.get(k).getCuserid());
                        cjsonObject.put("cuserid",cuser.getUserId());
                        cjsonObject.put("cusername",cuser.getUsername());
                        cjsonObject.put("cuserimg",cuser.getImageAddre());
                        cjsonObject.put("commentData",cnewlist.get(k).getCommentData());
                        cjsonObject.put("commenttime",cnewlist.get(k).getCommenttime());
                        cjsonArray.add(cjsonObject);
                    }
                    jsonObject.put("comments",cjsonArray);}
                jsonArray.add(jsonObject);
            }
            return  new RespEntity(RespCode.SUCCESS,jsonArray);}
        else{ List<Social> newlist = a.subList(0, a.size());
            JSONArray jsonArray =new JSONArray();
            for( int i=0;i<a.size();i++ ){
                JSONObject jsonObject = new JSONObject();
                User user1= userRepository.findAllByUserId(newlist.get(i).getUserid());
                Social social = newlist.get(i);
                jsonObject.put("userid",user1.getUserId());
                jsonObject.put("username",user1.getUsername());
                jsonObject.put("imageAddre",user1.getImageAddre());
                jsonObject.put("socialid",social.getSocialid());
                jsonObject.put("socialaddtime",social.getSocialaddtime());
                jsonObject.put("textdata",social.getTextdata());
                jsonObject.put("imagedata",social.getImagedata());
                // 评论包含用户头像姓名的新的对象
                if(social.getComments()==null){jsonObject.put("comments",null);}else{
                    JSONArray cjsonArray =new JSONArray();
                    for(int k=0;k<social.getComments().size();k++){
                        List<Social.Comments> cnewlist =social.getComments();
                        JSONObject cjsonObject=new JSONObject();
                        User cuser =userRepository.findAllByUserId(cnewlist.get(k).getCuserid());
                        cjsonObject.put("cuserid",cuser.getUserId());
                        cjsonObject.put("cusername",cuser.getUsername());
                        cjsonObject.put("cuserimg",cuser.getImageAddre());
                        cjsonObject.put("commentData",cnewlist.get(k).getCommentData());
                        cjsonObject.put("commenttime",cnewlist.get(k).getCommenttime());
                        cjsonArray.add(cjsonObject);
                    }
                    jsonObject.put("comments",cjsonArray);}
                jsonArray.add(jsonObject);
            }
            return  new RespEntity(RespCode.SUCCESS,jsonArray);}}


    @Autowired
    SocialService socialService;
    @RequestMapping("/CMHSP/socialFavorite")//收藏动态
    public RespEntity favoritesocial(@RequestBody com.alibaba.fastjson.JSONObject object1) {
        com.alibaba.fastjson.JSONObject ob1 =object1;
        Integer sid =ob1.getInteger("socialid");
        Integer uid =ob1.getInteger("userid");
        String  uname =ob1.get("username").toString();
        socialService.addsocialtofavorite(uid,uname,sid);
        return new RespEntity(RespCode.SUCCESS);
    }
    @RequestMapping("/CMHSP/socialAdd")//发布动态
    public RespEntity addsocial(@RequestBody com.alibaba.fastjson.JSONObject object2) {
        com.alibaba.fastjson.JSONObject ob2 =object2;
        String simg =ob2.get("imagedata").toString();
        Integer uid =ob2.getInteger("userid");
        String  stext =ob2.get("textdata").toString();
        String atime =ob2.get("socialaddtime").toString();
        socialService.addsocial(uid,simg,stext,atime);
        return new RespEntity(RespCode.SUCCESS);
    }
    @RequestMapping("/CMHSP/socialCommentAdd")//发布评论
    public RespEntity addcomment(@RequestBody com.alibaba.fastjson.JSONObject object3) {
        com.alibaba.fastjson.JSONObject ob3 =object3;
        Integer cuid =ob3.getInteger("userid");
        Integer sid =ob3.getInteger("socialid");
        String cd =ob3.get("commentData").toString();
        String ct =ob3.get("commenttime").toString();
        socialService.addcomment(cuid,sid,cd,ct);
        return new RespEntity(RespCode.SUCCESS);
    }
}
