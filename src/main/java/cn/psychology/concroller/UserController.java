
package cn.psychology.concroller;

import cn.psychology.Impl.CombUserSysImpl;
import cn.psychology.Impl.FavoriteImpl;
import cn.psychology.Impl.SysNewsImpl;
import cn.psychology.Util.JsonUtil;
import cn.psychology.Util.RespCode;
import cn.psychology.Util.RespEntity;
import cn.psychology.Util.SysnewsStatus;
import cn.psychology.dao.SocialRepository;
import cn.psychology.dao.UserRepository;
import cn.psychology.entity.*;
import cn.psychology.service.UserService;
import com.alibaba.fastjson.JSON;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SysNewsImpl sysNews;
    @Autowired
    private CombUserSysImpl combUserSys;
    @Autowired
    private SocialRepository socialRepository;
    @Autowired
    private FavoriteImpl favorite;

    private JsonUtil jsonUtil = new JsonUtil();

    @RequestMapping("/user/{id}")
    public User FindUserbyid(@PathVariable Integer id) {
        User user = userService.Findbyid(id);
        return user;
    }

    @GetMapping(value = "/login/{name}&{pwd}")
    public String UserLogin(@PathVariable String name, @PathVariable String pwd) {
        String Res = userService.Login(name,pwd);
        return Res;
    }

    @GetMapping(value = "/register/{name}&{pwd}")
    public String Register(@PathVariable String name, @PathVariable String pwd) {
        boolean bool = userService.CheckLogin(name, pwd);
        if (bool == true){
            User user = new User();
            user.setUsername(name);
            user.setUserpwd(pwd);
            user.setSignature("");
            user.setImageAddre("");
            user.setUsernickname("");
            user.setSex("");
            user.setRegion("");
            user.setUserRegTime("");
            userService.save(user);
            return "用户"+name+"注册成功";
        }else{
            return "用户："+name+"已被注册";
        }
    }
    @RequestMapping(value = "/CMHSP/userUpdate",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public String Update(@RequestBody User user) {
        if( user!= null ){
            //检查是否登录
            boolean bool = userService.CheckLogin(user.getUsername(), user.getUserpwd());
            if (bool == false){//checklogin失败，代表已有此用户。
                 User userData =  userRepository.findByUsername(user.getUsername());
                 JSONObject Resjson = new JSONObject();


                 if((!userData.getUserpwd().equals(user.getUserpwd()))

                         ){
                     Resjson.put("pwd","修改成功");
                     userData.setUserpwd(user.getUserpwd());
                 }
                 if((!userData.getSignature().equals(user.getSignature())

                         )
                         ){
                     Resjson.put("Sign","修改成功");
                     userData.setSignature(user.getSignature());
                 }
                 if((!userData.getSex().equals(user.getSex()))

                         ){
                     Resjson.put("Sex","修改成功");
                    userData.setSex(user.getSex());
                }
                if((!userData.getUsernickname().equals(user.getUsernickname()))

                        ){
                    Resjson.put("nickName","修改成功");
                     userData.setUsernickname(user.getUsernickname());
                 }
                 if((!userData.getImageAddre().equals(user.getImageAddre()) )

                         ){
                     Resjson.put("Image","修改成功");
                     userData.setImageAddre(user.getImageAddre());
                 }
                 if((!userData.getRegion().equals(user.getRegion()))

                         ){
                     Resjson.put("Region","修改成功");
                     userData.setRegion(user.getRegion());
                 }
                userService.save(userData);
                System.out.println(Resjson);
                return jsonUtil.JsonPackage(0,Resjson);

            }else{
                 return jsonUtil.JsonPackage(1,"Check Failture");

            }

        }else{
            return jsonUtil.JsonPackage(1,"Entity Is Null");

        }

    }
    //获取我的未读系统消息
    @RequestMapping(value = "/CMHSP/userGetsysMessage",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public  String usergetmessage(@RequestBody LinkedHashMap<String,Object> ob ) {
        String str = JSON.toJSONString(ob);
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(str);
        int userId = Integer.parseInt(json.get("userID").toString()) ;

        List<CombUserSysNews> list= combUserSys.findHasNotReadByUserid(userId);
        JSONArray jsonArray = new JSONArray();
        for(CombUserSysNews attribute : list) {
            JSONObject Reslist = new JSONObject();
            //Reslist.add(sysNews.findOneById((int)attribute.getSysId()));
            Reslist.put("context",sysNews.findOneById((int)attribute.getSysId()).getContext());
            Reslist.put("time",sysNews.findOneById((int)attribute.getSysId()).getTime());
            jsonArray.put(Reslist);

        }
        return jsonUtil.JsonPackage(0,jsonArray);

    }
    //获取我的未读消息提醒
    @RequestMapping(value = "/CMHSP/userNotice",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public  String usergetmessagecount(@RequestBody LinkedHashMap<String,Object> ob ) {
        String str = JSON.toJSONString(ob);
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(str);
        int userId = Integer.parseInt(json.get("userID").toString());

        JSONObject resjson = new JSONObject();


        //系统消息
        List<CombUserSysNews> CombUserSysNewslist= combUserSys.findHasNotReadByUserid(userId);
        JSONArray Reslist = new JSONArray();
        for(CombUserSysNews attribute : CombUserSysNewslist) {
            //Reslist.add(sysNews.findOneById((int)attribute.getSysId()));
            Reslist.put(sysNews.findOneById((int)attribute.getSysId()).getContext());

        }
        resjson.put("sysNews",CombUserSysNewslist.size());

        //我的评论消息
        List<Social> socialsList = socialRepository.findAllByUserid(userId);
        int socialListSize = socialsList.size();
        JSONArray hasNotReadComments = new JSONArray();
        ArrayList<Object> hasNotReadCommentss = new ArrayList<>();
        for( int i=0;i<socialListSize;i++ ){
            List<Social.Comments> commentsList = socialsList.get(i).getComments();
            int commentsListSize = commentsList.size();
            for( int j=0;j<commentsListSize;j++ ){
                if( commentsList.get(j).getCommenttype().equals(0) ){
                    JSONObject jsonObject = new JSONObject();
                    hasNotReadCommentss.add(commentsList.get(j));
                    //jsonObject.put("commentsCOntext",commentsList.get(j));
                    //hasNotReadComments.put(jsonObject);

                }
            }

        }
        resjson.put("comNews",hasNotReadCommentss.size());
        if( (hasNotReadCommentss.size()!=0)||(CombUserSysNewslist.size()!=0) ){
            resjson.put("haveNews",1);
        }else{
            resjson.put("haveNews",0);
        }
        //resjson.put("comNews",hasNotReadComments.length());
        return jsonUtil.JsonPackage(0,resjson);

    }

    @RequestMapping(value = "CMHSP/userClearNews",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public String userClearNews(@RequestBody LinkedHashMap<String,Object> ob) {
        String str = JSON.toJSONString(ob);
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(str);
        int userId = Integer.parseInt(json.get("userId").toString());
        int messageType = Integer.parseInt(json.get("messageType").toString());
        if( messageType == 0 ){
            //清空系统消息
            List<CombUserSysNews> CombUserSysNewslist= combUserSys.findHasNotReadByUserid(userId);
            for(CombUserSysNews attribute : CombUserSysNewslist) {
                //Reslist.add(sysNews.findOneById((int)attribute.getSysId()));
                CombUserSysNews combUserSysNews = combUserSys.findById(attribute.getId());
                combUserSysNews.setStatus(SysnewsStatus.hasRead.getIndex());
                combUserSys.save(combUserSysNews);
            }

        }else{
            //清空评论消息


            List<Social> socialsList = socialRepository.findAllByUserid(userId);
            int socialListSize = socialsList.size();
            for( int i=0;i<socialListSize;i++ ){
                Integer dd = socialsList.get(i).getSocialid();
                //Social social =  socialRepository.findAllBySocialid(socialsList.get(i).getSocialid());
                Social social =  socialRepository.findAllBySocialid(1);
                List<Social.Comments> commentsList = socialsList.get(i).getComments();
                int commentsListSize = commentsList.size();
                for( int j=0;j<commentsListSize;j++ ){
                    social.getComments().get(j).setCommenttype(SysnewsStatus.hasRead.getIndex());
                    socialRepository.save(social);
                }

            }



        }
        JSONObject resjson = new JSONObject();
        resjson.put("context","clear news  success");
        return jsonUtil.JsonPackage(0,resjson);
    }
    @RequestMapping(value = "/CMHSP/userFavorite",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public String getUserFavorite(@RequestBody User user) {


        List<Favorite> reslist = favorite.getFavorite(user.getUserId());
        return jsonUtil.JsonPackage(0,reslist);

    }

}





