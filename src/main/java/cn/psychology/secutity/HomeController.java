package cn.psychology.secutity;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping(value = "/ssss")
    public String index() {
//        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
//        model.addAttribute("msg", msg);
        return "index";
    }

     @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    @RequestMapping(value="/admin/test",method = RequestMethod.POST)
    @ResponseBody
    public String adminTest1() {
        return "ROLE_ADMIN";
    }

        @PreAuthorize("hasRole('ADMIN')")
        @RequestMapping(value="/admin/test2",method = RequestMethod.POST)
    @ResponseBody
    public String adminTest2() {
        return "ROLE_ADMIN";
    }
}