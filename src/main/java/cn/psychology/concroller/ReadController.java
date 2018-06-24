package cn.psychology.concroller;


import cn.psychology.entity.ReadTable;
import cn.psychology.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<ReadTable> readSearch(@RequestParam String keyWord, @RequestParam Boolean readType) {
        return readService.readSearch(keyWord,readType);
    }

    //获取详细信息接口（书/文章）
    @RequestMapping(value = "/CMHSP/readDetil",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public List<ReadTable> readDetil(@RequestParam Integer readId) {
        return readService.readDetil(readId);
    }

    //获取列表接口（书/文章）
    @RequestMapping(value = "/CMHSP/readList",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public List<ReadTable> readList(@RequestParam Boolean readType) {
        return readService.readList(readType);
    }

    //阅读收藏接口
    @RequestMapping(value = "/CMHSP/readFavour",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public String readFavour() {
        return ("success");
    }
}
