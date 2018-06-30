package cn.psychology.dao;

import cn.psychology.entity.CombUserSysNews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CombineSysRepository extends JpaRepository<CombUserSysNews,Integer> {

public List<CombUserSysNews> findAllByIdAndStatusOrderById(int id, int status);
    public List<CombUserSysNews> findAllByUserIdAndStatusOrderById(int id,int status);
    public CombUserSysNews findById(int id);//主键查询
    public List<CombUserSysNews> findByUserId(Integer userId);
}
