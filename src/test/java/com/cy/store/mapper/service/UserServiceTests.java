package com.cy.store.mapper.service;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest

//@RunWith:表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数必须是SpringRunner的实体
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private IUserService userService;

    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("yuio1");
            user.setPassword("123456");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            //获取异常的对象，类名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常具体信息
            System.out.println(e.getMessage());
        }

    }

}
