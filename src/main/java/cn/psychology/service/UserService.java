package cn.psychology.service;

import cn.psychology.Util.EncodePwd;
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
    public String CheckLogin(String userName, String userPassword) {
        User user = new User();
        if (userRepository.findByUsername(userName) == null) {

            //对密码进行加密
            // EncodePwd encode = new EncodePwd();
            // String userPasswordcoded = encode.EncoderByMd5(userPassword);
            user.setUsername(userName);
            user.setUserpwd(userPassword);
            userRepository.save(user);
            return "用户名  " + userName + " 注册成功";
        } else {
            return "用户名 " + userName + "已被占用";
        }
    }

    //登陆
    public String Login(@PathVariable String name, @PathVariable String pwd) {
        if (userRepository.findByUsernameAndUserpwd(name, pwd) != null) {
            return "cg";
        } else {
            return "oh sorry user name or password is wrong";
        }
    }
}
