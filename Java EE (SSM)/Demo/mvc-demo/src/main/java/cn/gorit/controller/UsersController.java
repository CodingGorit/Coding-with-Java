package cn.gorit.controller;

import cn.gorit.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UsersController {
	
	@RequestMapping("/toregesiter")
	public String tozhuce() {
		return "zhuce";
	}
	
	//bindingResult 获取校验的信息，服务单校验数使用
	@RequestMapping("/regesiter")
	public String zhuce(@Valid Users u, BindingResult br) {
		System.out.println(u.getAccount()+" "+u.getPhoneNum());
		for (ObjectError oe : br.getAllErrors()) {
			System.out.println(oe.getDefaultMessage());
		}
		if(br.hasErrors()) {
			return "zhuce";
		}
		return "index";
	}
}
