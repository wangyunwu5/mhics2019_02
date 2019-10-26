package cn.own.mhics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@RequestMapping(value="tologin/{test}",method=RequestMethod.GET)
	public String login(@PathVariable("test")String test,Model model) {
		System.out.println("访问连接成功，username="+test);//
		return "/user/login";
	}
}
