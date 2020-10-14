package com.example.springweb.controller;
import com.example.springweb.mapper.HelloMapper;
import com.example.springweb.mapper.AppInfoMapper;
import com.example.springweb.service.HelloService;

import com.example.springweb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.springweb.dao.HelloUser;
import com.example.springweb.dao.AppInfo;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
@Controller
public class MainPageController {
    @Resource
    private HelloMapper helloMapper;

    @Resource
    private  AppInfoMapper appInfoMapper;

    @Autowired
    HelloService helloService;

    @PostMapping("/mainPage")
    public ModelAndView mainPage(HttpServletRequest request, ModelAndView modelAndView){
        //System.out.println("test??");
        //appInfoMapper.findAll().get(0).OutInfo();

        //System.out.println("----------");
        //AppInfo appinfo=appInfoMapper.getAppInfo("中国象棋云库app");
        //appinfo.OutInfo();
        modelAndView.addObject("UserName",request.getSession().getAttribute("loginUname").toString());
        modelAndView.setViewName("mainPage");
        return modelAndView;
    }

    @PostMapping("/createApp")
    public ModelAndView createApp(HttpServletRequest request, ModelAndView modelAndView){
        modelAndView.setViewName("createApp");
        return modelAndView;
    }

    @PostMapping("/postAppName")
    public ModelAndView login(Model model, HttpServletRequest request, ModelAndView modelAndView,  BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("createApp");
            return modelAndView;
        }
        UserService us=new UserService();
        if(!us.loginUserCheck(request.getSession().getId())||request.getSession().getAttribute("loginUname").toString().length()==0){
            modelAndView.setViewName("logoutInfo");
            return modelAndView;
        }


        AppInfo info=new AppInfo();
        //检查info有无格式问题，有则返回格式报错信息errorInfo
        String errorInfo=info.CheckInfo(request);
        if(errorInfo!=null){
            modelAndView.addObject("error",errorInfo);
            modelAndView.setViewName("createApp");
            return modelAndView;
        }

        else{
            info.SetInfo(request);
            info.OutInfo();
            /*
            这里实现把info插入到数据库即可
            */
            appInfoMapper.insert(info);

            //appInfoMapper.findAll().get(0).OutInfo();
            modelAndView.addObject("success","提交成功");
            modelAndView.setViewName("createApp");
            return modelAndView;
        }

    }
    @PostMapping("/appProcess")
    public ModelAndView appProcess(HttpServletRequest request, ModelAndView modelAndView){
        modelAndView.setViewName("appProcess");
        return modelAndView;
    }

    @PostMapping("/enterpriseInfo")
    public ModelAndView enterpriseInfo(HttpServletRequest request, ModelAndView modelAndView){
        modelAndView.setViewName("enterpriseInfo");
        return modelAndView;
    }

    @PostMapping("/accountManage")
    public ModelAndView accountManage(HttpServletRequest request, ModelAndView modelAndView){
        modelAndView.setViewName("accountManage");
        return modelAndView;
    }

}
