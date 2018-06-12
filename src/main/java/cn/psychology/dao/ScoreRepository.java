package cn.psychology.dao;

import cn.psychology.entity.Score;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface ScoreRepository extends JpaRepository<Score,Integer> {

    public List<Score> findAllByUserId(String userId);
    public List<Score> findAllByUserIdAndAndTestType(String userId,String testType);
    public List<Score> findAllByUserIdOrderByTestType(String userId);
    public List<Score> findDistinctByUserId(String userId);



}
