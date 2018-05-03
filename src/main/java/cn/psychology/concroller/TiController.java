package cn.psychology.concroller;


import cn.psychology.dao.TiRepository;
import cn.psychology.entity.Ti;
import cn.psychology.service.TiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Component
@RestController
public class TiController {
    @Autowired
    private TiService tiService;
    
    @RequestMapping(value="/ti/{id}", produces = "application/json; charset=UTF-8")
    public Ti findone(@PathVariable String id) {
        Ti ti = tiService.findByExamination("1");
        return ti;

    }

    @RequestMapping("/ti/all")
    public List<Ti> findall(@PathVariable String id) {
        List<Ti> list = tiService.findAll();
        return list;

    }

}
