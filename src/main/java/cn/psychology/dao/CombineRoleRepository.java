package cn.psychology.dao;

import cn.psychology.entity.CombineRU;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombineRoleRepository extends JpaRepository<CombineRU,Integer> {

    public CombineRU findCombineRUByUserid(Integer id);
}
