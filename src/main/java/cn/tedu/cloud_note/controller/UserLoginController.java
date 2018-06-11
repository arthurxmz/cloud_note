package cn.tedu.cloud_note.controller;

import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/user")
public class UserLoginController {
    @Resource
    private UserService userService;
    @RequestMapping( value = "/login.do")
    @ResponseBody
    public NoteResult<User> execute(String username, String password){
        NoteResult<User> result=userService.checkLogin(username,password);

        return result;
    }

}
