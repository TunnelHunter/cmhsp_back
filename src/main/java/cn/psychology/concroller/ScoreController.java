package cn.psychology.concroller;

import cn.psychology.Impl.TiImpl;
import cn.psychology.dao.ScoreRepository;
import cn.psychology.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


@RestController
public class ScoreController {
    @Autowired
    private ScoreRepository scoreRepository;

    @RequestMapping(value="/getscore/{id}", produces = "application/json; charset=UTF-8")
    public String  findoneScore(@PathVariable String id) {
        Score score = scoreRepository.findOne(id);

        return score.getCurrscore();
    }
    @RequestMapping(value="/score", produces = "application/json; charset=UTF-8")
    public List<Score>  findoneScore() {
        //Score score = scoreRepository.findOne(id);
        List<Score> score = scoreRepository.findAll();
        return score;
    }
    @RequestMapping(value="/setscore/{id},{score},{tiid},{time}", produces = "application/json; charset=UTF-8")
    public String  findoneScore(@PathVariable Integer id, String score,long time,String tiid) {

        Score sc = new Score();
        sc.setScoreid(id);
        sc.setCurrscore(score);
        sc.setTiid(tiid);
        sc.setCurrentime(time);
        scoreRepository.save(sc);


        return "okay";
    }
}
