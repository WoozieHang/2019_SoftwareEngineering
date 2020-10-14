package com.example.springweb.controller;
import com.example.springweb.mapper.HelloMapper;
import com.example.springweb.service.HelloService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.springweb.dao.HelloUser;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class RegisterController {
    @Resource
    private HelloMapper helloMapper;

    @Autowired
    HelloService helloService;

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView){
        modelAndView.setViewName("register");
        System.out.println(" 66666");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(ModelAndView modelAndView, @Valid HelloUser userVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("register");
            return modelAndView;
        }
        String userName = userVo.getName();
        String password = userVo.getPassword();
        //System.out.println(" !!!!!!!!!!!!!!!!!!!!1 UN:"+userName+"PW"+ password+ "ID:"+userVo.getId()+"ensure:"+userVo.getEnsure());
        System.out.println(" !!!!!!!!!!!!!!!!!!!!2 type:"+userVo.getIsMaster());
        //HelloUser oneUser=new HelloUser("780659","ooir","123","401986905@qq.com","wife is？","cc",false,"123");
        //helloMapper.insert(oneUser);

        List<HelloUser> list=helloService.getUserList();

        if(userName.length()==0){
            modelAndView.addObject("error","请输入用户名");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        System.out.println("leng:"+userName.length());
        if(userName.length()>20){
            modelAndView.addObject("error","用户名长度应低于20个字符");
            modelAndView.setViewName("register");
            return modelAndView;
        }


        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().equals(userName)){
                modelAndView.addObject("error","用户名已被使用");
                modelAndView.setViewName("register");
                return modelAndView;
            }
        }

        if(password.length()<6||password.length()>20){
            modelAndView.addObject("error","密码长度应为6-16位");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        int count1=0,count2=0,count3=0;
        for(int i=0;i<password.length();i++){
            if(password.charAt(i)>='0'&&password.charAt(i)<='9')
                count1++;
            else if(password.charAt(i)>='a'&&password.charAt(i)<='z')
                count2++;
            else if(password.charAt(i)>='A'&&password.charAt(i)<='Z')
                count3++;
        }
        if(count1==0||(count2==0&&count3==0)){
            modelAndView.addObject("error","密码需要同时包括数字和字母");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        if(!userVo.getEnsure().equals(password)){
            modelAndView.addObject("error","两次密码不一致");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        //System.out.println(" 1!!!!!!!!!!!!!!!!!!");
        if(userVo.getEmail().length()==0){
            modelAndView.addObject("error","请输入邮箱");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        if(userVo.getEmail().length()>20||!(userVo.getEmail().indexOf('@')>=0&&userVo.getEmail().indexOf('@')<userVo.getEmail().length())){
            modelAndView.addObject("error","邮箱格式错误");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        //System.out.println(" 2!!!!!!!!!!!!!!!!!!");
        for(int i=0;i<list.size();i++){
            if(list.get(i).getEmail().equals(userVo.getEmail())){
                modelAndView.addObject("error","该邮箱已被使用");
                modelAndView.setViewName("register");
                return modelAndView;
            }
        }

        //System.out.println("3 !!!!!!!!!!!!!!!!!!");
        if(userVo.getQuestion().length()==0){
            modelAndView.addObject("error","请输入密保问题");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        if(userVo.getQuestion().length()>20){
            modelAndView.addObject("error","密保问题字数过多");
            modelAndView.setViewName("register");
            return modelAndView;
        }
        //System.out.println(" !!!!!!!!!!!!!!!!!!");
        if(userVo.getAnswer().length()==0){
            modelAndView.addObject("error","请输入密保答案");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        if(userVo.getAnswer().length()>20){
            modelAndView.addObject("error","密保答案字数过多");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        userVo.setId(171800000+list.size()+"");
        helloMapper.insert(userVo);

        modelAndView.addObject("success","注册成功！");
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
