
package cn.psychology.concroller;

import cn.psychology.dao.UserRepository;
import cn.psychology.entity.User;
import cn.psychology.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/{id}")
    public User FindUserbyid(@PathVariable Integer id) {
        User user = userService.Findbyid(id);
        return user;
    }

    @GetMapping(value = "/login/{name}&{pwd}")
    public String UserLogin(@PathVariable String name, @PathVariable String pwd) {
        String Res = userService.Login(name,pwd);
        return Res;
    }

    @GetMapping(value = "/register/{name}&{pwd}")
    public String Register(@PathVariable String name, @PathVariable String pwd) {
        boolean bool = userService.CheckLogin(name, pwd);
        if (bool == true){
            User user = new User();
            user.setUsername(name);
            user.setUserpwd(pwd);
            userService.save(user);
            return "用户："+name+"注册成功";
        }else{
            return "用户："+name+"已被注册";
        }
    }
    @GetMapping(value = "/register/{name}&{pwd}&{nick}&{sign}&{sex}&{region}")
    public String Register(@PathVariable String name, @PathVariable String pwd,@PathVariable String nick,
                           @PathVariable String sign,@PathVariable String sex,@PathVariable String region,
                           @PathVariable String imageaddr
                           ) {
        boolean bool = userService.CheckLogin(name, pwd);
        if (bool == true){
            User user = new User();
            user.setUsername(name);
            user.setUserpwd(pwd);
            user.setRegion(region);
            user.setSex(sex);
            user.setUsernickname(nick);
            user.setImageAddre(imageaddr);
            user.setSignature(sign);
            userService.save(user);
            return "用户："+name+"注册成功";
        }else{
            return "用户："+name+"已被注册";
        }
    }
}





