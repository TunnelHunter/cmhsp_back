package cn.psychology.Impl;

import cn.psychology.Util.SysnewsStatus;
import cn.psychology.dao.CombineSysRepository;
import cn.psychology.dao.UserRepository;
import cn.psychology.entity.CombUserSysNews;
import cn.psychology.entity.User;
import cn.psychology.service.CombUserSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombUserSysImpl implements CombUserSysService {
    @Autowired
    private CombineSysRepository combineSysRepository;
    @Autowired
    private UserRepository userRepository;

    public String insert(long sysnewsid){


        long Count = userRepository.count();
        for(int i = 1;i<=Count;i++){
            User user = userRepository.findOne(i);
            CombUserSysNews combUserSysNews = new CombUserSysNews();
            combUserSysNews.setUserId(user.getuserId());
            combUserSysNews.setSysId(sysnewsid);
            combUserSysNews.setStatus(SysnewsStatus.hasnotRead.getIndex());//weidu
            combineSysRepository.save(combUserSysNews);
        }
        return "";
    }

    //获取我的未读系统消息
    public List<CombUserSysNews> findHasNotReadByUserId(int id){
        int status = SysnewsStatus.hasnotRead.getIndex();
        List<CombUserSysNews>  list = combineSysRepository.findAllByUserIdAndStatusOrderById(id,status);

        return list;
    }
    public CombUserSysNews findById(int id){
        return combineSysRepository.findById(id);
    }
    public String save(CombUserSysNews combUserSysNews){
        combineSysRepository.save(combUserSysNews);
        return "successful";
    }
    //获取我的所有系统消息
    public List<CombUserSysNews> findByUserId(int id){
        List<CombUserSysNews>  list = combineSysRepository.findByUserId(id);

        return list;
    }


}
