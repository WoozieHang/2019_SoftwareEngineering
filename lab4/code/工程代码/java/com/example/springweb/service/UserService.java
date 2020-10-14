package com.example.springweb.service;

import javax.servlet.http.HttpServletRequest;
import com.example.springweb.dao.HelloUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
@Service
public class UserService {

    static private  List<String> loginUser=new ArrayList<String>(0);
    static private  List<String> changeUser=new ArrayList<String>(0);//存储要修改密码的用户的信息
    //List<Boolean> GetLoginLock()
    //除了添加常见访问私有变量的函数，还可以写一些获取数据库信息的函数！
    public  UserService(){

    }
    public void changeUserAdd(String sessionId){
        changeUser.add(sessionId);
    }
    public void loginUserAdd(String sessionId){
        loginUser.add(sessionId);
    }
    public void changeUserDel(String sessionId){
        changeUser.remove(sessionId);
    }
    public void loginUserDel(String sessionId){
        loginUser.remove(sessionId);
    }

    public boolean changeUserCheck(String sessionId){
        for(int i=0;i<changeUser.size();i++){

            if(changeUser.get(i).equals(sessionId))
                return true;

        }
        return false;
    }

    public boolean loginUserCheck(String sessionId){
        for(int i=0;i<loginUser.size();i++){

            if(loginUser.get(i).equals(sessionId))
                return true;

        }
        return false;
    }

    /*
    public void outInfo(){
        System.out.println("(info");
        for(int i=0;i<changeUser.size();i++)
            System.out.println(changeUser.get(i)+" ");
        System.out.println(")");
    }
*/
}


