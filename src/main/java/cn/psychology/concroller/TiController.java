package cn.psychology.concroller;


import cn.psychology.Impl.TiImpl;
import cn.psychology.dao.TiRepository;
import cn.psychology.entity.Ti;
import cn.psychology.service.TiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Component
@RestController
public class TiController {
    @Autowired
    private TiImpl tiimpl;

    @RequestMapping(value="/ti/{id}", produces = "application/json; charset=UTF-8")
    public Ti findone(@PathVariable String id) {
        Ti ti = tiimpl.findByExaminationId(id);
        System.out.println(ti.getQuestionsMessage());
        return ti;

    }

    @RequestMapping("/ti/all")
    public List<Ti> findall() {
        List<Ti> list = tiimpl.findAll();
        return list;

    }
    @RequestMapping("ti/insert")
    public String insert(){
        String Str = "";
        //tiimpl.insertTi(Str);
        return "yes";
    }
    @RequestMapping(value = "/ti/count",produces = "application/json;charset=UTF-8")
    public int Count(){
        int Res = 0;
        try {
             Res = tiimpl.count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Res;
    }

}
