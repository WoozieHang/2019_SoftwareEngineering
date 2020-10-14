package com.example.springweb;
import com.example.springweb.dao.HelloUser;
import com.example.springweb.service.UserService;
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
public class UserServiceTest {
    @Autowired
    UserService userService;




    @Test
    public void a_testChangeUserAdd() throws Exception{
        assertEquals(userService.changeUserCheck("1234"),false);
        assertEquals(userService.changeUserCheck("1234aaa"),false);
        assertEquals(userService.changeUserCheck("1234bb-"),false);
        assertEquals(userService.changeUserCheck("asd123"),false);
        assertEquals(userService.changeUserCheck("a1a2b3."),false);
        assertEquals(userService.changeUserCheck("!s-a"),false);
        userService.changeUserAdd("1234");
        userService.changeUserAdd("1234aaa");
        userService.changeUserAdd("1234bb-");
        userService.changeUserAdd("asd123");
        userService.changeUserAdd("a1a2b3.");
        userService.changeUserAdd("!s-a");
        assertEquals(userService.changeUserCheck("1234"),true);
        assertEquals(userService.changeUserCheck("1234aaa"),true);
        assertEquals(userService.changeUserCheck("1234bb-"),true);
        assertEquals(userService.changeUserCheck("asd123"),true);
        assertEquals(userService.changeUserCheck("a1a2b3."),true);
        assertEquals(userService.changeUserCheck("!s-a"),true);
    }

    @Test
    public void b_testChangeUserAdd() throws Exception{
        userService.changeUserAdd("AA");
        userService.changeUserAdd("DSASD12");
        userService.changeUserAdd("1234BB-");
        userService.changeUserAdd("ASD123");
        userService.changeUserAdd("A1A2B3.");
        userService.changeUserAdd("!S-A");
        assertEquals(userService.changeUserCheck("aa"),false);
        assertEquals(userService.changeUserCheck("dsasd12"),false);
        assertEquals(userService.changeUserCheck("s34bb-"),false);
        assertEquals(userService.changeUserCheck("ddd"),false);
        assertEquals(userService.changeUserCheck("xz//.."),false);
        assertEquals(userService.changeUserCheck("sad1"),false);
    }

    @Test
    public void c_testLoginUserAdd() throws Exception{
        assertEquals(userService.loginUserCheck("1234"),false);
        assertEquals(userService.loginUserCheck("1234aaa"),false);
        assertEquals(userService.loginUserCheck("1234bb-"),false);
        assertEquals(userService.loginUserCheck("asd123"),false);
        assertEquals(userService.loginUserCheck("a1a2b3."),false);
        assertEquals(userService.loginUserCheck("!s-a"),false);
        userService.loginUserAdd("1234");
        userService.loginUserAdd("1234aaa");
        userService.loginUserAdd("1234bb-");
        userService.loginUserAdd("asd123");
        userService.loginUserAdd("a1a2b3.");
        userService.loginUserAdd("!s-a");
        assertEquals(userService.loginUserCheck("1234"),true);
        assertEquals(userService.loginUserCheck("1234aaa"),true);
        assertEquals(userService.loginUserCheck("1234bb-"),true);
        assertEquals(userService.loginUserCheck("asd123"),true);
        assertEquals(userService.loginUserCheck("a1a2b3."),true);
        assertEquals(userService.loginUserCheck("!s-a"),true);
    }

    @Test
    public void d_testLoginUserAdd() throws Exception{
        userService.loginUserAdd("AA");
        userService.loginUserAdd("DSASD12");
        userService.loginUserAdd("1234BB-");
        userService.loginUserAdd("ASD123");
        userService.loginUserAdd("A1A2B3.");
        userService.loginUserAdd("!S-A");
        assertEquals(userService.loginUserCheck("aa"),false);
        assertEquals(userService.loginUserCheck("dsasd12"),false);
        assertEquals(userService.loginUserCheck("s34bb-"),false);
        assertEquals(userService.loginUserCheck("ddd"),false);
        assertEquals(userService.loginUserCheck("xz//.."),false);
        assertEquals(userService.loginUserCheck("sad1"),false);
    }


    @Test
    public void e_testChangeUserDel()throws Exception {
        assertEquals(userService.changeUserCheck("1234"),true);
        assertEquals(userService.changeUserCheck("1234aaa"),true);
        assertEquals(userService.changeUserCheck("1234bb-"),true);
        assertEquals(userService.changeUserCheck("asd123"),true);
        assertEquals(userService.changeUserCheck("a1a2b3."),true);
        assertEquals(userService.changeUserCheck("!s-a"),true);
        userService.changeUserDel("1234");
        userService.changeUserDel("1234aaa");
        userService.changeUserDel("1234bb-");
        userService.changeUserDel("asd123");
        userService.changeUserDel("a1a2b3.");
        userService.changeUserDel("!s-a");
        assertEquals(userService.changeUserCheck("1234"),false);
        assertEquals(userService.changeUserCheck("1234aaa"),false);
        assertEquals(userService.changeUserCheck("1234bb-"),false);
        assertEquals(userService.changeUserCheck("asd123"),false);
        assertEquals(userService.changeUserCheck("a1a2b3."),false);
        assertEquals(userService.changeUserCheck("!s-a"),false);
    }

    @Test
    public void f_testChangeUserDel() throws Exception{
        assertEquals(userService.changeUserCheck("AA"),true);
        assertEquals(userService.changeUserCheck("DSASD12"),true);
        assertEquals(userService.changeUserCheck("1234BB-"),true);
        assertEquals(userService.changeUserCheck("ASD123"),true);
        assertEquals(userService.changeUserCheck("A1A2B3."),true);
        assertEquals(userService.changeUserCheck("!S-A"),true);

        userService.changeUserDel("AA");
        userService.changeUserDel("DSASD12");
        userService.changeUserDel("1234BB-");
        userService.changeUserDel("ASD123");
        userService.changeUserDel("A1A2B3.");
        userService.changeUserDel("!S-A");
        assertEquals(userService.changeUserCheck("AA"),false);
        assertEquals(userService.changeUserCheck("DSASD12"),false);
        assertEquals(userService.changeUserCheck("1234BB-"),false);
        assertEquals(userService.changeUserCheck("ASD123"),false);
        assertEquals(userService.changeUserCheck("A1A2B3."),false);
        assertEquals(userService.changeUserCheck("!S-A"),false);
    }

    @Test
    public void g_testLoginUserDel() throws Exception{
        assertEquals(userService.loginUserCheck("1234"),true);
        assertEquals(userService.loginUserCheck("1234aaa"),true);
        assertEquals(userService.loginUserCheck("1234bb-"),true);
        assertEquals(userService.loginUserCheck("asd123"),true);
        assertEquals(userService.loginUserCheck("a1a2b3."),true);
        assertEquals(userService.loginUserCheck("!s-a"),true);
        userService.loginUserDel("1234");
        userService.loginUserDel("1234aaa");
        userService.loginUserDel("1234bb-");
        userService.loginUserDel("asd123");
        userService.loginUserDel("a1a2b3.");
        userService.loginUserDel("!s-a");
        assertEquals(userService.loginUserCheck("1234"),false);
        assertEquals(userService.loginUserCheck("1234aaa"),false);
        assertEquals(userService.loginUserCheck("1234bb-"),false);
        assertEquals(userService.loginUserCheck("asd123"),false);
        assertEquals(userService.loginUserCheck("a1a2b3."),false);
        assertEquals(userService.loginUserCheck("!s-a"),false);
    }

    @Test
    public void h_testLoginUserDel() throws Exception{
        assertEquals(userService.loginUserCheck("AA"),true);
        assertEquals(userService.loginUserCheck("DSASD12"),true);
        assertEquals(userService.loginUserCheck("1234BB-"),true);
        assertEquals(userService.loginUserCheck("ASD123"),true);
        assertEquals(userService.loginUserCheck("A1A2B3."),true);
        assertEquals(userService.loginUserCheck("!S-A"),true);
        userService.loginUserDel("AA");
        userService.loginUserDel("DSASD12");
        userService.loginUserDel("1234BB-");
        userService.loginUserDel("ASD123");
        userService.loginUserDel("A1A2B3.");
        userService.loginUserDel("!S-A");
        assertEquals(userService.loginUserCheck("AA"),false);
        assertEquals(userService.loginUserCheck("DSASD12"),false);
        assertEquals(userService.loginUserCheck("1234BB-"),false);
        assertEquals(userService.loginUserCheck("ASD123"),false);
        assertEquals(userService.loginUserCheck("A1A2B3."),false);
        assertEquals(userService.loginUserCheck("!S-A"),false);
    }

}
