package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lucyy-code
 * @description 用户模块的持久层
 *
 */
//@Mapper
public interface UserMapper {
    /**
     * Description : 用户注册
     *
     * @param user 用户信息
     * @return int 插入的结果
     **/
    Integer insert( User user);
    /**
     * Description : 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return top.year21.computerstore.entity.User
     **/

    User findByUserName(String username);

}
