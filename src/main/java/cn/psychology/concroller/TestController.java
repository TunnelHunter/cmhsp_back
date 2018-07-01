package cn.psychology.concroller;



import cn.psychology.Impl.TestImpl;
import cn.psychology.Util.ExamType;
import cn.psychology.Util.JsonUtil;
import cn.psychology.dao.ScoreRepository;
import cn.psychology.dao.TestRepository;
import cn.psychology.entity.ExamPaper;
import cn.psychology.entity.Score;
import cn.psychology.entity.User;
import com.alibaba.fastjson.JSON;
import net.minidev.json.JSONUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;


@Component
@RestController
public class TestController {
    
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private TestImpl testimpl;
    @Autowired
    private TestRepository testRepository;

    @PersistenceContext
    private EntityManager entitymanager;

    private JsonUtil jsonUtil = new JsonUtil();

    @RequestMapping(value="/ti/{id}", produces = "application/json; charset=UTF-8")
    public ExamPaper findone(@PathVariable String id) {
        ExamPaper ti = testimpl.findByExaminationId(id);
        System.out.println(ti.getQuestionsMessage());
        return ti;

    }

    @RequestMapping(value = "/CMHSP/examinationsList",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")

    public  String findall() {
        List<ExamPaper> list = testimpl.findAll();
        System.out.println(list);
        return jsonUtil.JsonPackage(0,list);

    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/CMHSP/examinationsResults",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")

    public  String setScore(@RequestBody Score score) {



                 scoreRepository.save(score);
         return jsonUtil.JsonPackage(0,"successful");
        //return jsonUtil.JsonPackage(0,list);

    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/CMHSP/userHisRecords",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")

    public  String getHisRecords(@RequestBody User user) {


        String userId = Integer.toString(user.getuserId());
        List<Score> list =  scoreRepository.findAllByUserId(userId);
        JSONArray jsonArray = new JSONArray();
        for( int i=0;i<list.size();i++ ){
            JSONObject jsonObject = new JSONObject();
            Score score = list.get(i);
            ExamPaper examPaper = testimpl.findByExaminationId(score.getExaminationId());
            int index = Integer.parseInt(score.getExaminationConclusionId());
            jsonObject.put("testType",score.getTestType());
            jsonObject.put("testId",score.getScoreId());
            jsonObject.put("testScore",score.getExaminationScore());
            jsonObject.put("summary",examPaper.getQuestionsConclusion().get( index-1 ).getSummary());  //  -1: conclusionId -1 = 数组下标
            jsonObject.put("time",score.getTestTime());
            jsonObject.put("conclusion",examPaper.getQuestionsConclusion().get( index-1 ).getQueConclusion());
            jsonObject.put("testName",examPaper.getExaminationName());
            jsonArray.put(jsonObject);
        }

        return jsonUtil.JsonPackage(0,jsonArray);
        //return jsonUtil.JsonPackage(0,list);

    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/CMHSP/userAnalysis",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")

    public  String getScoreAnalysis(@RequestBody LinkedHashMap<String,Object> ob ) {

        String str = JSON.toJSONString(ob);
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(str);
        String userId = json.get("userId").toString();

        List<Score> list =  scoreRepository.findAllByUserId(userId);
        JSONObject jsonObject = new JSONObject();
        // testTime 封装
        ArrayList<String> testTime = new ArrayList<>();
         for(Score example : list){
                   String time = example.getTestTime();
                   testTime.add(time);
                }

//         //testScore 封装
//        JSONArray jsonArrayScore = new JSONArray();
//        for( int i=0;i<list.size();i++ ){
//            JSONObject jsonObjectScore = new JSONObject();
//            jsonObjectScore.put("examName",testimpl.findByExaminationId(list.get(i).getExaminationId()).getExaminationName());
//            jsonObjectScore.put("score",list.get(i).getExaminationScore());
//            jsonArrayScore.put(jsonObjectScore);
//        }
//        //typeAnaly 封装
//        ArrayList<String > TypeCount= new ArrayList<>();
//        for(Score example : list){
//            if( TypeCount.contains(example.getTestType()) ){
//
//            }else{
//                TypeCount.add(example.getTestType());
//            }
//        }
//
//
//
//        JSONArray jsonArrayScoreByType = new JSONArray();
//        for(String example : TypeCount){
//           List<Score > l =  scoreRepository.findAllByUserIdAndAndTestType(userId,example);
//           JSONObject jsonObjecScoreByType = new JSONObject();
//            jsonObjecScoreByType.put("type",example);
//            jsonObjecScoreByType.put("count",l.size());
//           jsonArrayScoreByType.put(jsonObjecScoreByType);
//        }
//
//        jsonObject.put("typeAnaly",jsonArrayScoreByType);
//        jsonObject.put("testScore",jsonArrayScore);


         //封装testScore
        int count = (int)testRepository.count();
        JSONArray jsonArray = new JSONArray();
        ArrayList<String> arrayListScore = new ArrayList<>(); //存放score
        ArrayList<String> arrayListTestTime = new ArrayList<>(); //存放TestTime
        for( Integer i=1; i<=count;i++ ){
           // System.out.println(i);
            JSONObject jsonObject1 = new JSONObject(); //存放examname
            ExamPaper examPaper = testRepository.findByExaminationId(i.toString());
            jsonObject1.put("examName",examPaper.getExaminationName());

            arrayListScore.clear();
            arrayListTestTime.clear();
            List<Score> listscore = scoreRepository.findAllByUserIdAndExaminationId(userId,i.toString());
            for(Score sc: listscore ){
                arrayListScore.add(sc.getExaminationScore());
                arrayListTestTime.add(sc.getTestTime());

            }
            jsonObject1.put("score",arrayListScore);
            jsonObject1.put("testTime",arrayListTestTime);
            jsonArray.put(jsonObject1);
        }


        //封装 typeanalysis
        JSONArray jsonArrayScoreByType = new JSONArray();
        ArrayList<String > TypeCount= new ArrayList<>();
        for(Score example : list){
            if( TypeCount.contains(example.getTestType()) ){
            }else{
                TypeCount.add(example.getTestType());
            }
        }

        for(String example : TypeCount){
           List<Score > l =  scoreRepository.findAllByUserIdAndAndTestType(userId,example);
            //List<Score > l =  scoreRepository.findAllByUserIdAndAndTestType(userId,example);
            JSONObject jsonObjecScoreByType = new JSONObject();

            jsonObjecScoreByType.put("count",l.size());
            if( example.equals("1") ){
                jsonObjecScoreByType.put("typeName",ExamType.Depression.getName());
            }else if(  example.equals("2")|| example.equals("3")   ){
                jsonObjecScoreByType.put("typeName",ExamType.anxious.getName());
            }else{
                return jsonUtil.JsonPackage(1,"试题类型出错");
            }
            jsonArrayScoreByType.put(jsonObjecScoreByType);
        }
        jsonObject.put("allTestTime",testTime);
        jsonObject.put("testScore",jsonArray);
        jsonObject.put("typeAnaly",jsonArrayScoreByType);


        return jsonUtil.JsonPackage(0,jsonObject);
        //return jsonUtil.JsonPackage(0,list);

    }

    @RequestMapping("ti/insert")
    public String insert(){
        String Str = "";
        //testimpl.insertTi(Str);
        return "yes";
    }
    @RequestMapping(value = "/ti/count",produces = "application/json;charset=UTF-8")
    public int Count(){
        int Res = 0;
        try {
             Res = testimpl.count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Res;
    }

    @RequestMapping(value="/score", produces = "application/json; charset=UTF-8")
    public List<Score>  findoneScore() {
        //Score score = scoreRepository.findOne(id);
        List<Score> score = scoreRepository.findAll();
        return score;
    }
    @RequestMapping(value="/setscore",method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public String  findoneScore(@RequestBody JSONObject vmHost, HttpServletRequest request) {
        Score sc = new Score();
//        sc.setScoreId(id);
//        sc.setScore(score);
//        sc.setExamId(examid);
//        sc.setTestTime(time);
        scoreRepository.save(sc);


        return "okay";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value="/CMHSP/test",method = RequestMethod.GET, produces = "application/json")
//    public String  test(@RequestBody LinkedHashMap<String,Object> ob) {
   // public String  test(@RequestBody com.alibaba.fastjson.JSONObject ob) {
    public String  test() {

//        com.alibaba.fastjson.JSONObject jb = ob;
//
//        String str  = jb.get("userId").toString();
//        String str2  = jb.get("examinationScore").toString();
//
//        //scoreRepository.save(ob);
//        System.out.println(str+"  ----------   "+str2);
//
//
//        //Query query = entitymanager.createNativeQuery(sql);
//        ArrayList<String > TypeCount= new ArrayList<>();
//        List<Score> list =  scoreRepository.findAllByUserId("1");
//        for(Score example : list){
//            if( TypeCount.contains(example.getTestType()) ){
//
//            }else{
//                TypeCount.add(example.getTestType());
//            }
//        }

        //return jsonUtil.JsonPackage(0,TypeCount);
        return new Date().toString();
        //return new BCryptPasswordEncoder(123).toString();
       // return "dswswswdwdedrwegthwyjujtegbtr";
    }



}
