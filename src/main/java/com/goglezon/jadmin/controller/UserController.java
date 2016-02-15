package com.goglezon.jadmin.controller;

import com.goglezon.jadmin.model.group.Second;
import com.goglezon.jadmin.view.UserView;
import com.goglezon.jadmin.model.User;
import com.goglezon.jadmin.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Yuwenqi on 2015/9/11.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    private static Logger logger = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addUser(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        request.getSession().setAttribute("currentUser", "nobody");
        String defaultPage = "user";
        boolean ret = false;
        UserView user = new UserView();
        try {
            ret = userService.create((String) request.getSession().getAttribute("currentUser"), user);
        } catch (Exception e) {
            setError(modelMap, e.getMessage());
        }
        modelMap.put("ret", ret);
        modelMap.put("user", user.getUserName());
        logger.info(modelMap);
        return defaultPage;
    }

    @RequestMapping(value = "login")
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws IOException {
        return "login";
    }

    @RequestMapping(value = "doLogin")
    public String doLogin(@Validated({Second.class}) @ModelAttribute("doLoginForm") UserView userView,BindingResult bindingResult,HttpServletRequest request,ModelMap modelMap) throws IOException {
        String defaultPage = "login";
        try {
            if(bindingResult.hasErrors()){

                setError(modelMap,bindingResult.getFieldError().getField(),bindingResult.getFieldError().getDefaultMessage());
                return defaultPage;
            }
            User user = userService.login(userView);
            if (user != null) {
                request.getSession().setAttribute("userName", user.getUserName());
            } else {
                return defaultPage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/home/index.action";
    }
}
