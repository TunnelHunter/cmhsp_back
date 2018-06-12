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
    @RequestMapping("/socialFreshDown")//下拉刷新获取最新五条动态
    public RespEntity showsociallist() {


        List<Social> list1 = socialRepository.findAll();
//      Social o1 =list1.get(list1.size()-1);
//        Social o2=list1.get(list1.size()-2);
//      User u1= userRepository.findAllByUserid(o1.getUserid());
//        u1.getUsername();
//        u1.getImageAddre();
////       Object o1= list1.get(list1.size()-1);
////       Object o2= list1.get(list1.size()-2);
////       Object o3= list1.get(list1.size()-3);
////       Object o4= list1.get(list1.size()-4);
////       Object o5= list1.get(list1.size()-5);
        Collections.reverse(list1); // 倒序排列
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
            jsonObject.put("comments",social.getComments());
            jsonArray.add(jsonObject);

        }

      //  newlist.addAll(u);
        return new RespEntity(RespCode.SUCCESS,jsonArray);
    }
    @Autowired
    SocialService socialService;
    @RequestMapping("/socialFavorite")//收藏动态
    public RespEntity favoritesocial(@RequestBody com.alibaba.fastjson.JSONObject object1) {
        com.alibaba.fastjson.JSONObject ob1 =object1;
        String sid =ob1.get("socialid").toString();
        Integer uid =ob1.getInteger("userid");
        String  uname =ob1.get("username").toString();
        socialService.addsocialtofavorite(uid,uname,sid);
        return new RespEntity(RespCode.SUCCESS);
    }
    @RequestMapping("/socialAdd")//发布动态
    public RespEntity addsocial(@RequestBody com.alibaba.fastjson.JSONObject object2) {
        com.alibaba.fastjson.JSONObject ob2 =object2;
        String simg =ob2.get("imagedata").toString();
        Integer uid =ob2.getInteger("userid");
        String  stext =ob2.get("textdata").toString();
        String atime =ob2.get("socialaddtime").toString();
        socialService.addsocial(uid,simg,stext,atime);
        return new RespEntity(RespCode.SUCCESS);
    }
    @RequestMapping("/socialCommentAdd")//发布评论
    public RespEntity addcomment(@RequestBody com.alibaba.fastjson.JSONObject object3) {
        com.alibaba.fastjson.JSONObject ob3 =object3;
        String cuid =ob3.get("userid").toString();
        String sid =ob3.get("socialid").toString();
        String cd =ob3.get("commentData").toString();
        String ct =ob3.get("commenttime").toString();
        socialService.addcomment(cuid,sid,cd,ct);
        return new RespEntity(RespCode.SUCCESS);
    }
}
