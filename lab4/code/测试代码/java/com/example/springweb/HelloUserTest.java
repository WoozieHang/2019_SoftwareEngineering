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
public class HelloUserTest {
    @Autowired
    HelloUser hu;

    @Test
    public void a_testName() {
       hu.setName("aaa1");
        assertEquals(hu.getName(),"aaa1");

        hu.setName("sadgag2");
        assertEquals(hu.getName(),"sadgag2");

        hu.setName("dsg.2");
        assertEquals(hu.getName(),"dsg.2");
    }

    @Test
    public void b_testName() {
        hu.setName("basd1");
        assertEquals(hu.getName(),"basd1");

        hu.setName("asdgag2214LAFS'''..saf");
        assertEquals(hu.getName(),"asdgag2214LAFS'''..saf");

        hu.setName("dsgasffq3ffq.2");
        assertEquals(hu.getName(),"dsgasffq3ffq.2");
    }

    @Test
    public  void  c_testId(){
        hu.setId("aaa1");
        assertEquals(hu.getId(),"aaa1");

        hu.setId("sadgag2");
        assertEquals(hu.getId(),"sadgag2");

        hu.setId("dsg.2");
        assertEquals(hu.getId(),"dsg.2");
    }


    @Test
    public void d_testId() {
        hu.setId("basd1");
        assertEquals(hu.getId(),"basd1");

        hu.setId("asdgag2214LAFS'''..saf");
        assertEquals(hu.getId(),"asdgag2214LAFS'''..saf");

        hu.setId("dsgasffq3ffq.2");
        assertEquals(hu.getId(),"dsgasffq3ffq.2");
    }


    @Test
    public  void  e_testPassword(){
        hu.setPassword("aaa1");
        assertEquals(hu.getPassword(),"aaa1");

        hu.setPassword("sadgag2");
        assertEquals(hu.getPassword(),"sadgag2");

        hu.setPassword("dsg.2");
        assertEquals(hu.getPassword(),"dsg.2");
    }


    @Test
    public void f_testPassword() {
        hu.setPassword("basd1");
        assertEquals(hu.getPassword(),"basd1");

        hu.setPassword("asdgag2214LAFS'''..saf");
        assertEquals(hu.getPassword(),"asdgag2214LAFS'''..saf");

        hu.setPassword("dsgasffq3ffq.2");
        assertEquals(hu.getPassword(),"dsgasffq3ffq.2");
    }


    @Test
    public  void  g_testEmail(){
        hu.setEmail("aaa1");
        assertEquals(hu.getEmail(),"aaa1");

        hu.setEmail("sadgag2");
        assertEquals(hu.getEmail(),"sadgag2");

        hu.setEmail("dsg.2");
        assertEquals(hu.getEmail(),"dsg.2");
    }


    @Test
    public void h_testEmail() {
        hu.setEmail("basd1");
        assertEquals(hu.getEmail(),"basd1");

        hu.setEmail("asdgag2214LAFS'''..saf");
        assertEquals(hu.getEmail(),"asdgag2214LAFS'''..saf");

        hu.setEmail("dsgasffq3ffq.2");
        assertEquals(hu.getEmail(),"dsgasffq3ffq.2");
    }

    @Test
    public  void  i_testQuestion(){
        hu.setQuestion("aaa1");
        assertEquals(hu.getQuestion(),"aaa1");

        hu.setQuestion("sadgag2");
        assertEquals(hu.getQuestion(),"sadgag2");

        hu.setQuestion("dsg.2");
        assertEquals(hu.getQuestion(),"dsg.2");
    }


    @Test
    public void j_testQuestion() {
        hu.setQuestion("basd1");
        assertEquals(hu.getQuestion(),"basd1");

        hu.setQuestion("asdgag2214LAFS'''..saf");
        assertEquals(hu.getQuestion(),"asdgag2214LAFS'''..saf");

        hu.setQuestion("dsgasffq3ffq.2");
        assertEquals(hu.getQuestion(),"dsgasffq3ffq.2");
    }

    @Test
    public  void  k_testAnswer(){
        hu.setAnswer("aaa1");
        assertEquals(hu.getAnswer(),"aaa1");

        hu.setAnswer("sadgag2");
        assertEquals(hu.getAnswer(),"sadgag2");

        hu.setAnswer("dsg.2");
        assertEquals(hu.getAnswer(),"dsg.2");
    }


    @Test
    public void l_testAnswer() {
        hu.setAnswer("basd1");
        assertEquals(hu.getAnswer(),"basd1");

        hu.setAnswer("asdgag2214LAFS'''..saf");
        assertEquals(hu.getAnswer(),"asdgag2214LAFS'''..saf");

        hu.setAnswer("dsgasffq3ffq.2");
        assertEquals(hu.getAnswer(),"dsgasffq3ffq.2");
    }


    @Test
    public  void  m_testEnsure(){
        hu.setEnsure("aaa1");
        assertEquals(hu.getEnsure(),"aaa1");

        hu.setEnsure("sadgag2");
        assertEquals(hu.getEnsure(),"sadgag2");

        hu.setEnsure("dsg.2");
        assertEquals(hu.getEnsure(),"dsg.2");
    }


    @Test
    public void n_testEnsure() {
        hu.setEnsure("basd1");
        assertEquals(hu.getEnsure(),"basd1");

        hu.setEnsure("asdgag2214LAFS'''..saf");
        assertEquals(hu.getEnsure(),"asdgag2214LAFS'''..saf");

        hu.setQuestion("dsgasffq3ffq.2");
        assertEquals(hu.getQuestion(),"dsgasffq3ffq.2");
    }

    @Test
    public  void  o_testIsMaster(){
        hu.setIsMaster(false);
        assertEquals(hu.getIsMaster(),false);



    }


    @Test
    public void p_testAnswer() {
        hu.setIsMaster(true);
        assertEquals(hu.getIsMaster(),true);
    }

}
