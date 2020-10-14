package com.example.springweb;

import com.example.springweb.dao.HelloUser;
import com.example.springweb.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;

import org.junit.runners.MethodSorters;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HelloServiceTest {
    @Autowired
    HelloService helloService;

    @Test
    public void a_getUsers() {

        List<HelloUser> users = helloService.getUserList();
        assertFalse("User not null", users == null);
        assertNotNull(users);
        assertNotEquals(users.size(), 0);
        assertEquals(users.size(), 5);
    }

    @Test
    public void b_getUsers(){
        List<HelloUser> users = helloService.getUserList();
        assertEquals(users.get(0).getName(), "admin");
        assertEquals(users.get(1).getName(), "master");
        assertEquals(users.get(2).getName(), "test");
        assertEquals(users.get(3).getName(), "yaaaome");
        assertEquals(users.get(0).getId(), "171800001");
        assertEquals(users.get(1).getId(),  "171800003");
        assertEquals(users.get(2).getId(),  "171800002");
        assertEquals(users.get(3).getId(),  "171800000");

    }



    @Test
    public void c_testInsert() throws Exception{
        int userNum1=helloService.getUserList().size();
        Map<String,String> params=new HashMap<>();
        params.put("id","1");
        params.put("name","小张");
        params.put("password","11111111111111111111");
        params.put("email","4");
        params.put("question","5");
        params.put("answer","6");
        helloService.InsertUser(params);
        int userNum2=helloService.getUserList().size();
        assertEquals(userNum2-userNum1,1);
    }

    @Test
    public void d_testInsert() throws Exception{
        //helloService.InsertUser(new HelloUser("4","zyy","dsb"));
        // assertEquals(helloService.getUserList().size(),3);
        int userNum1=helloService.getUserList().size();


        Map<String,String> params=new HashMap<>();
        params.put("id","2");
        params.put("name","小王");
        params.put("password","3");
        params.put("email","4");
        params.put("question","5");
        params.put("answer","6");
        helloService.InsertUser(params);
        int userNum2=helloService.getUserList().size();
        assertEquals(userNum2-userNum1,1);
    }

    @Test
    public void e_testGetOne() throws Exception{
        HelloUser helloUser = helloService.getOne("1");
        assertEquals(helloUser.getName(),"小张");
        helloUser = helloService.getOne("2");
        assertEquals(helloUser.getName(),"小王");
    }

    @Test
    public void f_testGetOne() throws Exception{
        HelloUser helloUser = helloService.getOne("3");
        assertEquals(helloUser.getName(),null);
    }


    @Test
    public void h_testUpdate() throws Exception{
       // helloService.UpdateByID(new HelloUser("3","ooo","bbbb"));
       // assertEquals(helloService.getOne("3").getName(),"ooo");
        Map<String,String> params=new HashMap<>();
        params.put("id","1");
        params.put("name","张三");
        helloService.UpdateByID(params);
        assertEquals(helloService.getOne("1").getName(),"张三");
    }



    @Test
    public void i_testUpdate() throws Exception{
        // helloService.UpdateByID(new HelloUser("3","ooo","bbbb"));
        // assertEquals(helloService.getOne("3").getName(),"ooo");
        Map<String,String> params=new HashMap<>();
        params.put("id","2");
        params.put("email","233@nju.edu.cn");
        helloService.UpdateByID(params);
        assertEquals(helloService.getOne("2").getEmail(),"233@nju.edu.cn");
    }

    @Test
    public void j_testExistsUser(){
        assertEquals(helloService.ExistsUser("张三"),true);
        assertEquals(helloService.ExistsUser("小王"),true);
    }


    @Test
    public void k_testExistsUser(){
        assertEquals(helloService.ExistsUser("李四"),false);
        assertEquals(helloService.ExistsUser("王五"),false);
    }



    @Test
    public void l_testDelete() throws Exception{
        helloService.DeleteByID("1");
        assertEquals(helloService.getOne("1").getName(),null);
        helloService.DeleteByID("2");
        assertEquals(helloService.getOne("2").getName(),null);
    }


    @Test
    public void m_testDelete() throws Exception{
        assertEquals(helloService.ExistsUser("张三"),false);
        assertEquals(helloService.ExistsUser("小王"),false);
    }


}
