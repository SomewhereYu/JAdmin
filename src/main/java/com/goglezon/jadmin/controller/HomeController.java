package com.goglezon.jadmin.controller;

import com.goglezon.jadmin.common.Result;
import com.goglezon.jadmin.model.User;
import com.goglezon.jadmin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuwenqi on 2015/9/11.
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{
    @Resource
    private UserService userService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "get",produces="application/json;charset=UTF-8")
    public String getJson(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
        User user=new User();
        user.setUserName("于文琦");
        user.setEmail("yuwenqi@goglezon.com");

        Result result=new Result(true);
        result.setErrorMsg("Error occurred.");
        result.setErrorCode("-1");
        result.setData(user);
        result.setData("user",user);
        return toJson(result);
    }
}
