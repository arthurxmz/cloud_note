package cn.tedu.cloud_note.controller;

import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserRegisterController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Object> execute(String username, String desc, String password){
		System.out.println(username);
		
		NoteResult<Object> result=userService.addUser(username, password, desc);
		return result;
		
	}
}
