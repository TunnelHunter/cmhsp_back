package cn.psychology.service;

import cn.psychology.dao.UserRepository;
import cn.psychology.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    //Findbyid
    public User Findbyid(@PathVariable Integer id) {
        return userRepository.findOne(id);
    }

    //注册方法
    public boolean CheckLogin(String userName, String userPassword) {
        User user = new User();
        if (userRepository.findByUsername(userName) == null) {
            //可被注册
            //对密码进行加密
            // EncodePwd encode = new EncodePwd();
            // String userPasswordcoded = encode.EncoderByMd5(userPassword);
            return true;
        } else {
            //用户名已经存在
            return false;
        }
    }


    public void save(User obj) {
        userRepository.save(obj);
    }

    //登陆
    public String Login(@PathVariable String name, @PathVariable String pwd) {
        if (userRepository.findByUsernameAndUserpwd(name, pwd) != null) {
            return "cg";
        } else {
            return "oh sorry user name or password is wrong";
        }
    }
    //
    public User FindbyUserName(String name){
        return userRepository.findByUsername(name);
    }
}
