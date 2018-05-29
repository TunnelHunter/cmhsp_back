package cn.psychology.dao;

import cn.psychology.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score,String> {


}
