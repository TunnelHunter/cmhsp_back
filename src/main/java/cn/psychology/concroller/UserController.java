
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
        String Res = userService.CheckLogin(name, pwd);
        return Res;
    }
}





