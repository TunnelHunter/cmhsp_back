package cn.psychology.concroller;


import cn.psychology.Impl.TestImpl;
import cn.psychology.Util.JsonUtil;
import cn.psychology.dao.ScoreRepository;
import cn.psychology.entity.ExamPaper;
import cn.psychology.entity.Score;
import com.alibaba.fastjson.JSON;
import net.minidev.json.JSONUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Component
@RestController
public class TestController {
    @Autowired
    private TestImpl tiimpl;
    @Autowired
    private ScoreRepository scoreRepository;

    private JsonUtil jsonUtil = new JsonUtil();

    @RequestMapping(value="/ti/{id}", produces = "application/json; charset=UTF-8")
    public ExamPaper findone(@PathVariable String id) {
        ExamPaper ti = tiimpl.findByExaminationId(id);
        System.out.println(ti.getQuestionsMessage());
        return ti;

    }

    @RequestMapping(value = "/CMHSP/examinationsList",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")

    public  String findall() {
        List<ExamPaper> list = tiimpl.findAll();
       // return "";
        return jsonUtil.JsonPackage(0,list);

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
    @RequestMapping(value="/getscore/{id}", produces = "application/json; charset=UTF-8")
    public String  findoneScore(@PathVariable String id) {
        Score score = scoreRepository.findOne(id);

        return score.getScore();
    }
    @RequestMapping(value="/score", produces = "application/json; charset=UTF-8")
    public List<Score>  findoneScore() {
        //Score score = scoreRepository.findOne(id);
        List<Score> score = scoreRepository.findAll();
        return score;
    }
    @RequestMapping(value="/setscore",method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public String  findoneScore(@RequestBody List vmHostlist, HttpServletRequest request) {



//        Score sc = new Score();
//        sc.setScoreId(id);
//        sc.setScore(score);
//        sc.setExamId(examid);
//        sc.setTestTime(time);
//        scoreRepository.save(sc);


        return "okay";
    }

}
