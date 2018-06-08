package cn.psychology.dao;

import cn.psychology.entity.CombineRU;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.jvm.hotspot.ui.FindByQueryPanel;

public interface CombineRoleRepository extends JpaRepository<CombineRU,Integer> {

    public CombineRU findCombineRUByUserid(Integer id);
}
