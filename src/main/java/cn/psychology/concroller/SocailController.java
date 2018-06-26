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
import org.springframework.security.access.prepost.PreAuthorize;
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
        int[] zero =new int[0];
        if(list1.size()>4){
            List<Social> newlist = list1.subList(0, 5);
            JSONArray jsonArray =new JSONArray();
            for( int i=0;i<5;i++ ){
                JSONObject jsonObject = new JSONObject();
                User user1= userRepository.findAllByUserId(newlist.get(i).getuserId());
                Social social = newlist.get(i);
                jsonObject.put("userId",user1.getuserId());
                jsonObject.put("userName",user1.getusername());
                jsonObject.put("imageAddre",user1.getImageAddre());
                jsonObject.put("socialId",social.getsocialId());
                jsonObject.put("socialAddTime",social.getsocialAddTime());
                jsonObject.put("textData",social.gettextData());
                jsonObject.put("imageData",social.getimageData());
                // 评论包含用户头像姓名的新的对象
                if(social.getComments()==null){jsonObject.put("comments",zero);}else{
                    JSONArray cjsonArray =new JSONArray();
                    for(int k=0;k<social.getComments().size();k++){
                        List<Social.Comments> cnewlist =social.getComments();
                        JSONObject cjsonObject=new JSONObject();
                        User cuser =userRepository.findAllByUserId(cnewlist.get(k).getCuserId());
                        cjsonObject.put("cuserId",cuser.getuserId());
                        cjsonObject.put("cuserName",cuser.getusername());
                        cjsonObject.put("cuserImg",cuser.getImageAddre());
                        cjsonObject.put("commentData",cnewlist.get(k).getCommentData());
                        cjsonObject.put("commentTime",cnewlist.get(k).getCommentTime());
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
                User user1= userRepository.findAllByUserId(newlist.get(i).getuserId());
                Social social = newlist.get(i);
                jsonObject.put("userId",user1.getuserId());
                jsonObject.put("userName",user1.getusername());
                jsonObject.put("imageAddre",user1.getImageAddre());
                jsonObject.put("socialId",social.getsocialId());
                jsonObject.put("socialaddTime",social.getsocialAddTime());
                jsonObject.put("textData",social.gettextData());
                jsonObject.put("imageData",social.getimageData());
                // 评论包含用户头像姓名的新的对象
                if(social.getComments()==null){jsonObject.put("comments",zero);}else{
                    JSONArray cjsonArray =new JSONArray();
                    for(int k=0;k<social.getComments().size();k++){
                        List<Social.Comments> cnewlist =social.getComments();
                        JSONObject cjsonObject=new JSONObject();
                        User cuser =userRepository.findAllByUserId(cnewlist.get(k).getCuserId());
                        cjsonObject.put("cuserId",cuser.getuserId());
                        cjsonObject.put("cuserName",cuser.getusername());
                        cjsonObject.put("cuserImg",cuser.getImageAddre());
                        cjsonObject.put("commentData",cnewlist.get(k).getCommentData());
                        cjsonObject.put("commentTime",cnewlist.get(k).getCommentTime());
                        cjsonArray.add(cjsonObject);
                    }
                    jsonObject.put("comments",cjsonArray);}
                jsonArray.add(jsonObject);
            }
            return new RespEntity(RespCode.SUCCESS,jsonArray);}
    }

    @RequestMapping("/CMHSP/socialFreshUp")//上拉刷新获取接下来五条动态
    public RespEntity shownextsociallist(@RequestBody Social social1) {
        List a = socialRepository.findBySocialIdLessThan(social1.getsocialId());
        Collections.reverse(a); // 倒序排列
        int[] zero = new int[0];
        if(a.size()>4){
            List<Social> newlist = a.subList(0, 5);
            JSONArray jsonArray =new JSONArray();
            for( int i=0;i<5;i++ ){
                JSONObject jsonObject = new JSONObject();
                User user1= userRepository.findAllByUserId(newlist.get(i).getuserId());
                Social social = newlist.get(i);
                jsonObject.put("userId",user1.getuserId());
                jsonObject.put("userName",user1.getusername());
                jsonObject.put("imageAddre",user1.getImageAddre());
                jsonObject.put("socialId",social.getsocialId());
                jsonObject.put("socialAddTime",social.getsocialAddTime());
                jsonObject.put("textData",social.gettextData());
                jsonObject.put("imageData",social.getimageData());
                // 评论包含用户头像姓名的新的对象
                if(social.getComments()==null){jsonObject.put("comments",zero);}else{
                    JSONArray cjsonArray =new JSONArray();
                    for(int k=0;k<social.getComments().size();k++){
                        List<Social.Comments> cnewlist =social.getComments();
                        JSONObject cjsonObject=new JSONObject();
                        User cuser =userRepository.findAllByUserId(cnewlist.get(k).getCuserId());
                        cjsonObject.put("cuserId",cuser.getuserId());
                        cjsonObject.put("cuserName",cuser.getusername());
                        cjsonObject.put("cuserImg",cuser.getImageAddre());
                        cjsonObject.put("commentData",cnewlist.get(k).getCommentData());
                        cjsonObject.put("commentTime",cnewlist.get(k).getCommentTime());
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
                User user1= userRepository.findAllByUserId(newlist.get(i).getuserId());
                Social social = newlist.get(i);
                jsonObject.put("userId",user1.getuserId());
                jsonObject.put("userName",user1.getusername());
                jsonObject.put("imageAddre",user1.getImageAddre());
                jsonObject.put("socialId",social.getsocialId());
                jsonObject.put("socialAddTime",social.getsocialAddTime());
                jsonObject.put("textData",social.gettextData());
                jsonObject.put("imageData",social.getimageData());
                // 评论包含用户头像姓名的新的对象
                if(social.getComments()==null){jsonObject.put("comments",zero);}else{
                    JSONArray cjsonArray =new JSONArray();
                    for(int k=0;k<social.getComments().size();k++){
                        List<Social.Comments> cnewlist =social.getComments();
                        JSONObject cjsonObject=new JSONObject();
                        User cuser =userRepository.findAllByUserId(cnewlist.get(k).getCuserId());
                        cjsonObject.put("cuserId",cuser.getuserId());
                        cjsonObject.put("cuserName",cuser.getusername());
                        cjsonObject.put("cuserImg",cuser.getImageAddre());
                        cjsonObject.put("commentData",cnewlist.get(k).getCommentData());
                        cjsonObject.put("commentTime",cnewlist.get(k).getCommentTime());
                        cjsonArray.add(cjsonObject);
                    }
                    jsonObject.put("comments",cjsonArray);}
                jsonArray.add(jsonObject);
            }
            return  new RespEntity(RespCode.SUCCESS,jsonArray);}}


    @Autowired
    SocialService socialService;
    @PreAuthorize("hasRole('USER')")
    @RequestMapping("/CMHSP/socialFavorite")//收藏动态
    public RespEntity favoritesocial(@RequestBody com.alibaba.fastjson.JSONObject object1) {
        com.alibaba.fastjson.JSONObject ob1 =object1;
        Integer sid =ob1.getInteger("socialId");
        Integer uid =ob1.getInteger("userId");
        String  uname =ob1.get("userName").toString();
        int Result = socialService.addsocialtofavorite(uid,uname,sid);
        if(Result == 0){
            return new RespEntity(RespCode.SUCCESS);
        }else{
            return new RespEntity(RespCode.ERROR);
        }
    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping("/CMHSP/socialAdd")//发布动态
    public RespEntity addsocial(@RequestBody com.alibaba.fastjson.JSONObject object2) {
        com.alibaba.fastjson.JSONObject ob2 =object2;
        String simg =ob2.get("imageData").toString();
        Integer uid =ob2.getInteger("userId");
        String  stext =ob2.get("textData").toString();
        String atime =ob2.get("socialAddTime").toString();
        socialService.addsocial(uid,simg,stext,atime);
        return new RespEntity(RespCode.SUCCESS);
    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping("/CMHSP/socialCommentAdd")//发布评论
    public RespEntity addcomment(@RequestBody com.alibaba.fastjson.JSONObject object3) {
        com.alibaba.fastjson.JSONObject ob3 =object3;
        Integer cuid =ob3.getInteger("userId");
        Integer sid =ob3.getInteger("socialId");
        String cd =ob3.get("commentData").toString();
        String ct =ob3.get("commentTime").toString();
        socialService.addcomment(cuid,sid,cd,ct);
        return new RespEntity(RespCode.SUCCESS);
    }
}
