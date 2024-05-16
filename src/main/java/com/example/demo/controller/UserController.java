package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {

  /**
   * ユーザー情報 Service
   */
  @Autowired
  UserService userService;

  /**
   * ユーザー情報一覧画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面のHTML
   */
  @RequestMapping(value = "/user/id_search", method = RequestMethod.POST)
  public String displayList(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
    User user = userService.search(userSearchRequest);
    model.addAttribute("userinfo", user);
    return "user/search";
  }
  
  @GetMapping(value = "/user/search")
  public String userSearch(Model model) {
	  model.addAttribute("userSearchRequest", new UserSearchRequest());
	  return "/user/search";
  }
}