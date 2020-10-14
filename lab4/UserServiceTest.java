package com.example.springweb;

import com.example.springweb.dao.User;
import com.example.springweb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testUsers() {
        User user = new User();
        user.setEmail("111.com");
        user.setPassword("111");
        user.setType(1);
        user.setCompanyNameZh("测试公司");
        user.setCompanyNameEn("test company");
        user.setCompanyAddress("测试位置");
        user.setCompanyHomepage("测试网址");
        user.setCompanyTaxId("0000");
        user.setCompanyZip("000000");
        user.setContactEmail("contact@contact.com");
        user.setContactName("测试联系人");
        user.setContactPhone("10010101110");
        user.setContactTitle("测试职位");

        userService.register(user);
        List<User> users = userService.getUserList();
        assertNotNull(users);
        assertEquals(users.get(0).getEmail(), "111.com");
        assertEquals(users.get(0).getPassword(),"111");
    }
}
