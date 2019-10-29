package cn.own.mhics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.own.mhics.common.ResponseBean;
import cn.own.mhics.entity.Person;
import cn.own.mhics.server.UserService;

@RestController
@RequestMapping("login")
public class LoginController {
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value="tologin/{test}",method=RequestMethod.GET)
	public String login(@PathVariable("test")String test,Model model) {
		System.out.println("访问连接成功，username="+test);//
		return "/user/login";
	}
	
	@GetMapping("/getperson")
	public ResponseBean getPerson() {
		
		List<Person> persons = userService.getUserList();
		System.out.println("查询成功"+persons);
		if(persons !=null)
		{
			return new ResponseBean(HttpStatus.OK.value(),"查询成功",persons);
		}
		return new ResponseBean(HttpStatus.FORBIDDEN.value(),"查询成功",persons);
	}
}
