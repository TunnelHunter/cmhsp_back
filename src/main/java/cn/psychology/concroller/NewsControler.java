package cn.psychology.concroller;

import cn.psychology.Impl.SysNewsImpl;
import cn.psychology.Util.JsonUtil;
import cn.psychology.dao.ReadRepository;
import cn.psychology.entity.ReadTable;
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
    @Autowired
    private ReadRepository readRepository;
    private JsonUtil jsonUtil = new JsonUtil();
    //暂时用作后台通过postman添加系统信息。
    @RequestMapping(value = "/news/insert",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public String insertNews(@RequestBody JSONObject json){
        String context = json.get("context").toString();
        String  Result =  sysNews.insertNewSys(context);
        return  jsonUtil.JsonPackage(0,Result);
    }
    //暂时用作后台通过postman添加书籍文章信息
    @RequestMapping(value = "/read/insert",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public String insertRead(@RequestBody JSONObject json){
        ReadTable readTable = new ReadTable();
        String readId = json.get("readId").toString();
        int readTypeInt = Integer.parseInt(json.get("readType").toString()) ;



        String readTitle = json.get("readTitle").toString();
        String readAuthor = json.get("readAuthor").toString();
        String readImage = json.get("readImage").toString();
        String readContext = json.get("readContext").toString();
        readTable.setReadId(readId);
        readTable.setReadAuthor(readAuthor);
        readTable.setReadContext(readContext);
        readTable.setReadImage(readImage);
        readTable.setReadTitle(readTitle);
        readTable.setReadType(readTypeInt);
        ReadTable  Result =  readRepository.insert(readTable);
        return  jsonUtil.JsonPackage(0,Result.getClass().toString());
    }
}
