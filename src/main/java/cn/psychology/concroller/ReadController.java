package cn.psychology.concroller;


import cn.psychology.Util.JsonUtil;
import cn.psychology.Util.RespCode;
import cn.psychology.Util.RespEntity;
import cn.psychology.entity.ReadTable;
import cn.psychology.service.ReadService;
import com.alibaba.fastjson.JSON;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;


@RestController
public class ReadController {

    @Autowired
    private ReadService readService;
    private JsonUtil jsonUtil = new JsonUtil();

    //阅读首屏加载接口
    @RequestMapping(value = "/CMHSP/readFirstPage",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public String readFirstPage() {

        JSONObject result =  readService.readFirstPage();
        return jsonUtil.JsonPackage(0,result);
    }

    //阅读搜索接口
    @RequestMapping(value = "/CMHSP/readSearch",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public RespEntity readSearch(@RequestBody LinkedHashMap<String,Object> ob ) {
        String str = JSON.toJSONString(ob);
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(str);
        String readType = json.get("readType").toString();
        String searchKeyword = json.get("searchKeyword").toString() ;

        List<ReadTable> result = readService.readSearch(searchKeyword,Integer.parseInt(readType));
        return new RespEntity(RespCode.SUCCESS, result);
    }

    //获取详细信息接口（书/文章）
    @RequestMapping(value = "/CMHSP/readDetil",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public RespEntity readDetil(@RequestBody LinkedHashMap<String,Object> ob ) {

        String str = JSON.toJSONString(ob);
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(str);
        String readId = json.get("readId").toString() ;
        //return readService.readDetil(Integer.parseInt(readId));
        ReadTable result = readService.readDetil(readId);
        return new RespEntity(RespCode.SUCCESS, result);
    }

    //获取列表接口（书/文章）
    @RequestMapping(value = "/CMHSP/readList",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public RespEntity readList(@RequestBody LinkedHashMap<String,Object> ob ) {
        String str = JSON.toJSONString(ob);
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(str);
        String readType = json.get("readType").toString() ;

        //return readService.readList(readTypeboolean);
        List<ReadTable> result = readService.readList(Integer.parseInt(readType));
        return new RespEntity(RespCode.SUCCESS, result);
    }

    //阅读收藏接口
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/CMHSP/readFavour",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public RespEntity readFavour(@RequestBody LinkedHashMap<String,Object> ob ) {
        String str = JSON.toJSONString(ob);
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(str);
        String userId = json.get("userId").toString() ;
        String readId = json.get("readId").toString() ;

//        readService.addFavorite(readId,Integer.parseInt(userId));
        int Result = readService.addFavorite(readId,Integer.parseInt(userId));
        if(Result == 0){
            return new RespEntity(RespCode.SUCCESS);
        }else{
            return new RespEntity(RespCode.ERROR);
        }

    }
}
