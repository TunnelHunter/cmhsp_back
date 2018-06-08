package cn.psychology.dao;

import cn.psychology.entity.Score;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score,Integer> {

    public List<Score> findAllByUserId(String userId);




}
