package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest:表示标注当前类是一个测试类，不会随项目一起打包
@SpringBootTest

//@RunWith:表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数必须是SpringRunner的实体
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;
    /**
     * 单元测试方法：就可以独立运行，不用启动整个喜爱凝固
     * 1.必须被@Test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不能指定任何类型
     * 4.方法的访问修饰符必须是public
     */
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("timi");
        user.setPassword("123456");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);

    }
    @Test
    public void findByName(){
        User user = new User();
        User timi = userMapper.findByUserName("timi");
        System.out.println(timi);
    }
}
