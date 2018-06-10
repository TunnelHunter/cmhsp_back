package cn.psychology.concroller;


import cn.psychology.entity.ReadTable;
import cn.psychology.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ReadController {

    @Autowired
    private ReadService readService;

    //阅读首屏加载接口
    @GetMapping("/readFirstPage")
    public List<ReadTable> readFirstPage() {
        return readService.readFirstPage();
    }

    //阅读搜索接口
    @GetMapping("/readSearch")
    public List<ReadTable> readSearch(@RequestParam String keyWord, @RequestParam Boolean readType) {
        return readService.readSearch(keyWord,readType);
    }

    //获取详细信息接口（书/文章）
    @GetMapping("/readDetil")
    public List<ReadTable> readDetil(@RequestParam Integer readId) {
        return readService.readDetil(readId);
    }

    //获取列表接口（书/文章）
    @GetMapping("/readList")
    public List<ReadTable> readList(@RequestParam Boolean readType) {
        return readService.readList(readType);
    }

    //阅读收藏接口
    @GetMapping("/readFavour")
    public String readFavour() {
        return ("success");
    }
}
