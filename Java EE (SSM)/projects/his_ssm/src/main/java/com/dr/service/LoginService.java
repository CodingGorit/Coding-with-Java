  package com.dr.service;
  
  import com.dr.pojo.User;
  import org.springframework.web.servlet.ModelAndView;

  import javax.servlet.http.HttpServletRequest;

  public interface LoginService {
	  User findUser(User user)throws Exception;

      String register(HttpServletRequest request);
  }