package com.example.springweb.controller;


import com.example.springweb.service.HelloService;
import com.example.springweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.springweb.dao.HelloUser;
import com.example.springweb.mapper.HelloMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    HelloService helloService;

    @Resource
    private HelloMapper helloMapper;

    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request, ModelAndView modelAndView, Model model){
        UserService us=new UserService();
        if(us.loginUserCheck(request.getSession().getId())) {
            String tmp=request.getSession().getAttribute("loginUname").toString();
            HelloUser hu=helloMapper.getUser(tmp);
            model.addAttribute("UserName",tmp);
            if(!hu.getIsMaster())
            modelAndView.setViewName("mainPage");

            else modelAndView.setViewName("mainPage2");

            return modelAndView;
        }

        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(Model model,HttpServletRequest request,ModelAndView modelAndView, @Valid HelloUser userVo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }

        UserService us0=new UserService();
        if(us0.loginUserCheck(request.getSession().getId())) {
            modelAndView.setViewName("repeatLogin");
            return modelAndView;
        }

        String userName = userVo.getName();
        String password = userVo.getPassword();
       // System.out.println("  UN:"+userName+"PW"+ password+ "ID:"+userVo.getId());

        if(userName.length()<=20&&password.length()<=20&&helloService.ExistsUser(userName)) {
            HelloUser one_user = helloMapper.getUser(userName);
            if(one_user.getName().equals(userName)&&one_user.getPassword().equals(password)){
                UserService us=new UserService();
                us.loginUserAdd(request.getSession().getId());
                //us.outInfo();
                request.getSession().setAttribute("loginUname",one_user.getName());
                //System.out.println("uquestion:"+one_user.getQuestion());

                if(one_user.getIsMaster()==false) {
                    model.addAttribute("UserName", one_user.getName());
                    modelAndView.setViewName("mainPage");
                    return modelAndView;
                }
                else {
                    modelAndView.setViewName("mainPage2");
                    return modelAndView;
                }
            }

        }
        modelAndView.addObject("error","用户名或密码错误");
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @PostMapping("/back")
    public ModelAndView back(HttpServletRequest request,ModelAndView modelAndView, @Valid HelloUser userVo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }
        request.getSession().removeAttribute("loginUname");
        UserService us=new UserService();
        us.loginUserDel(request.getSession().getId());
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
