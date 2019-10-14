package cn.own.mhics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@RequestMapping(value="logining/{username}",method=RequestMethod.GET)
	public void login(@PathVariable("username")String username) {
		System.out.println("访问连接成功，username="+username);
	}
}
