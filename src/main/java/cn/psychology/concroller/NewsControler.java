package cn.psychology.concroller;

import cn.psychology.Impl.SysNewsImpl;
import cn.psychology.Util.JsonUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsControler {
    @Autowired
    private SysNewsImpl sysNews;
    private JsonUtil jsonUtil = new JsonUtil();
    //暂时用作后台通过postman添加系统信息。
    @RequestMapping(value = "/news/insert",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public String insertNews(@RequestBody JSONObject json){
        String context = json.get("context").toString();
        String  Result =  sysNews.insertNewSys(context);
        return  jsonUtil.JsonPackage(0,Result);
    }
}
