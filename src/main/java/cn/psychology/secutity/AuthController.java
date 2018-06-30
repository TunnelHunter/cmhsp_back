package cn.psychology.secutity;

import cn.psychology.Util.JsonUtil;
import cn.psychology.Util.RespCode;
import cn.psychology.Util.RespEntity;
import cn.psychology.concroller.UserController;
import cn.psychology.dao.UserRepository;
import cn.psychology.entity.Social;
import cn.psychology.entity.User;
import cn.psychology.service.UserService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;//逻辑流
    @Autowired
    UserRepository userRepository;
    private JsonUtil jsonUtil = new JsonUtil();

    @RequestMapping(value = "/hahaha/login", method = RequestMethod.GET)
    public String wsw() {


        // Return the token
        return "ddddd";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public String createAuthenticationToken(@RequestBody com.alibaba.fastjson.JSONObject ob) throws AuthenticationException {
        //  @RequestBody JwtAuthenticationRequest authenticationRequest
        com.alibaba.fastjson.JSONObject jb = ob;

        String username = jb.get("username").toString();
        String password = jb.get("password").toString();
//        String logintime = jb.get("logintime").toString();

        final String token = authService.login(username, password);
        // Return the token
        ResponseEntity<?> ff = ResponseEntity.ok(new JwtAuthenticationResponse(token));
        JSONObject jsonObject = new JSONObject();
        User user = userRepository.findByUsername(username);
        jsonObject.put("token", token);
        jsonObject.put("userId", user.getuserId());
        jsonObject.put("userName", user.getusername());
        jsonObject.put("userImage", user.getImageAddre());
        jsonObject.put("userRegion", user.getRegion());
        jsonObject.put("userSign", user.getSignature());
        return jsonUtil.JsonPackage(0, jsonObject);

//        return new RespEntity(RespCode.SUCCESS, jsonObject);

    }

    @RequestMapping(value = "/auth/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException {
        System.out.println("  \n refresh \n");
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if (refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }

    //    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
//    public SysUser register(@RequestBody SysUser addedUser) throws AuthenticationException{
//        return authService.register(addedUser);
//    }
    //http://localhost:8080/auth/register
    @RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public String register(@RequestBody SysUser addedUser) throws AuthenticationException {

        //认证流
        authService.register(addedUser);
        //逻辑流

        boolean bool = userService.CheckLogin(addedUser.getUsername(), addedUser.getPassword());
        if (bool == true) {
            User user = new User();
            user.setusername(addedUser.getUsername());
            user.setuserpwd(addedUser.getPassword());
            user.setSignature("从心开始");
            user.setImageAddre("imgs/default_userImage.png");
            user.setUsernickname(addedUser.getUsername());
            user.setSex("");
            user.setRegion("");
            user.setUserRegTime("");
            userService.save(user);
            String aubRes =  "用户" + addedUser.getUsername() + "注册成功";
            return jsonUtil.JsonPackage(0, aubRes);
        } else {
            String aubRes =  "用户：" + addedUser.getUsername() + "已被注册";
            return jsonUtil.JsonPackage(1, aubRes);
        }


    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            System.out.println("  \n auth ！=null /n");
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "退出登录";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
