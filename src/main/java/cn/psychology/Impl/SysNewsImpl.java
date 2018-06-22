package cn.psychology.Impl;

import cn.psychology.dao.CombineSysRepository;
import cn.psychology.dao.SysNewsRepository;
import cn.psychology.entity.SysNews;
import cn.psychology.service.SysNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysNewsImpl implements SysNewsService {

    @Autowired
    private SysNewsRepository sysNewsRepository;
    @Autowired
    private CombUserSysImpl combUserSys;

    public String insertNewSys(String str){
        int currcount = (int)sysNewsRepository.count();
        int sysId = ++currcount;
        SysNews sysNews = new SysNews();
        sysNews.setContext(str);
        sysNews.setId(sysId);
        sysNews.setTime(new Date().toString() );
        combUserSys.insert(sysId);
        sysNewsRepository.save(sysNews);
        return "success";
    }

    public String findall(){
        sysNewsRepository.findAll();
        return "";
    }
    public SysNews findOneById(int id){
       return  sysNewsRepository.findOne(id);
    }


}
