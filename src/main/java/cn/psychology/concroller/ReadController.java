package cn.psychology.concroller;


import cn.psychology.Util.RespCode;
import cn.psychology.Util.RespEntity;
import cn.psychology.entity.ReadTable;
import cn.psychology.service.ReadService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;


@RestController
public class ReadController {

    @Autowired
    private ReadService readService;

    //阅读首屏加载接口
    @RequestMapping(value = "/CMHSP/readFirstPage",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public List<ReadTable> readFirstPage() {
        return readService.readFirstPage();
    }

    //阅读搜索接口
    @RequestMapping(value = "/CMHSP/readSearch",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public List<ReadTable> readSearch(@RequestBody LinkedHashMap<String,Object> ob ) {
        String str = JSON.toJSONString(ob);
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(str);
        String readType = json.get("readType").toString();
        String searchKeyword = json.get("searchKeyword").toString() ;
        boolean readTypeboolean = false;
        if(readType.equals("0")){
            readTypeboolean = false;
        }else{
            readTypeboolean = true;
        }
        return readService.readSearch(searchKeyword,readTypeboolean);
    }

    //获取详细信息接口（书/文章）
    @RequestMapping(value = "/CMHSP/readDetil",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public ReadTable readDetil(@RequestBody LinkedHashMap<String,Object> ob ) {

        String str = JSON.toJSONString(ob);
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(str);
        String readId = json.get("readId").toString() ;
        return readService.readDetil(Integer.parseInt(readId));
    }

    //获取列表接口（书/文章）
    @RequestMapping(value = "/CMHSP/readList",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public List<ReadTable> readList(@RequestBody LinkedHashMap<String,Object> ob ) {
        String str = JSON.toJSONString(ob);
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(str);
        String readType = json.get("readType").toString() ;
        boolean readTypeboolean = false;
        if(readType.equals("0")){
            readTypeboolean = false;
        }else{
            readTypeboolean = true;
        }
        return readService.readList(readTypeboolean);
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
