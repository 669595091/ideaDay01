package cn.blb.controller;

import cn.blb.pojo.User;
import cn.blb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("say")
    @ResponseBody
    public String say(){
        System.out.println("welcome to China!!");
        return "success";
    }
    //根据ID查询用户
    @GetMapping("/{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id") Long i){
        User user = userService.queryUserById(i);
        return user;
    }
    //删除用户
    @GetMapping("/del/{ids}")
    @ResponseBody
    public String deleteUserById(@PathVariable("ids") Long ids){
        userService.deleteUserById(ids);
        return "success";
    }
    //查询用户
    @GetMapping("list")
    public String queryAllUser(Model model){
        List<User> userList = userService.queryAllUser();
        model.addAttribute("users",userList);
        return "item";
    }

}
