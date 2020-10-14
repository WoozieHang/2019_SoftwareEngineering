package com.example.springweb.controller;
import com.example.springweb.mapper.HelloMapper;
import com.example.springweb.service.HelloService;
import com.example.springweb.service.UserService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.springweb.dao.HelloUser;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import javax.servlet.http.HttpSession;
import java.io.IOException;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;

@Controller
public class ChangeKeyController {
    @Resource
    private HelloMapper helloMapper;

    @Autowired
    HelloService helloService;

    @GetMapping("/changeKey")
    public ModelAndView changeKey(HttpServletRequest request,ModelAndView modelAndView){

        UserService us=new UserService();
        System.out.println("!"+request.getSession().getId()+" "+us.changeUserCheck(request.getSession().getId()));
       //us.outInfo();
        if(us.changeUserCheck(request.getSession().getId())) {
            String tmp=request.getSession().getAttribute("changeUname").toString();
         // System.out.println(tmp);
            List<HelloUser> list=helloService.getUserList();
            for(int i=0;i<list.size();i++){
                HelloUser one_user=list.get(i);
                if(one_user.getName().equals(tmp)){
                    //System.out.println("info:"+one_user.toString());
                    modelAndView.addObject("Question",one_user.getQuestion());
                    modelAndView.setViewName("changeKey2");
                    return modelAndView;
                }
            }
        }
            modelAndView.setViewName("changeKey");
            return modelAndView;
    }

    @PostMapping("/changeKey")
    public ModelAndView changKey(HttpServletRequest request, ModelAndView modelAndView, @Valid HelloUser userVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("changeKey");
            return modelAndView;
        }
        String userName = userVo.getName();
        String email = userVo.getEmail();
        //System.out.println("test：  "+userName+" "+email);

        List<HelloUser> list=helloService.getUserList();

        for(int i=0;i<list.size();i++){
            HelloUser one_user=list.get(i);
            if(one_user.getName().equals(userName)&&one_user.getEmail().equals(email)){
                UserService us=new UserService();
                us.changeUserAdd(request.getSession().getId());
                //us.outInfo();
                request.getSession().setAttribute("changeUname",one_user.getName());
                //System.out.println("info:"+one_user.toString());

                modelAndView.addObject("Question",one_user.getQuestion());
                modelAndView.setViewName("changeKey2");
                return modelAndView;
            }
        }

        modelAndView.addObject("error","用户名或邮箱错误");
        modelAndView.setViewName("changekey");
        return modelAndView;
    }


    @PostMapping("/changeKey2")
    public ModelAndView changeKey2(HttpServletRequest request,ModelAndView modelAndView, @Valid HelloUser userVo, BindingResult bindingResult){
        UserService us=new UserService();
        //us.outInfo();
        System.out.println(us.changeUserCheck(request.getSession().getId()));
       if(!us.changeUserCheck(request.getSession().getId())){
           modelAndView.setViewName("logoutInfo");
           return modelAndView;
       }

        HelloUser this_user=helloMapper.getUser(request.getSession().getAttribute("changeUname").toString());

        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.addObject("Question",this_user.getQuestion());
            modelAndView.setViewName("changeKey2");
            return modelAndView;
        }
       String userName = request.getSession().getAttribute("changeUname").toString();
        String ans = userVo.getAnswer();
       // System.out.println("test：  "+userName+" "+email);

        List<HelloUser> list=helloService.getUserList();

        for(int i=0;i<list.size();i++){
            HelloUser one_user=list.get(i);
            if(one_user.getName().equals(userName)&&one_user.getAnswer().equals(ans)){
                modelAndView.setViewName("changeKey3");
                return modelAndView;
            }
        }

        modelAndView.addObject("error","密保错误");
        modelAndView.addObject("Question",this_user.getQuestion());
        modelAndView.setViewName("changekey2");
        return modelAndView;
    }

    @PostMapping("/changeKey3")
    public ModelAndView changeKey3(HttpServletRequest request,ModelAndView modelAndView, @Valid HelloUser userVo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("changeKey3");
            return modelAndView;
        }
        String password = userVo.getPassword();
        if(password.length()<6){
            modelAndView.addObject("error","密码长度至少为6");
            modelAndView.setViewName("changeKey3");
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
            modelAndView.setViewName("changeKey3");
            return modelAndView;
        }

        if(!userVo.getEnsure().equals(password)){
            modelAndView.addObject("error","两次密码不一致");
            modelAndView.setViewName("changeKey3");
            return modelAndView;
        }

        List<HelloUser> list=helloService.getUserList();
        String userName=request.getSession().getAttribute("changeUname").toString();
        for(int i=0;i<list.size();i++){
            HelloUser one_user=list.get(i);
            if(one_user.getName().equals(userName)){
                one_user.setPassword(password);
                helloMapper.updateByID(one_user);
                modelAndView.addObject("success","修改成功");
                modelAndView.setViewName("changeKey3");
                return modelAndView;
            }
        }

        modelAndView.addObject("error","用户不存在！");
        modelAndView.setViewName("changekey3");
        return modelAndView;
    }


    @PostMapping("/changeKey4")
    public ModelAndView changeKey4(HttpServletRequest request,ModelAndView modelAndView, @Valid HelloUser userVo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("changeKey4");
            return modelAndView;
        }
        request.getSession().removeAttribute("changeUname");
        UserService us=new UserService();
        us.changeUserDel(request.getSession().getId());
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
