package com.cy.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest

class StoreApplicationTests {
    @Autowired //自动装配
    private DataSource dataSource;
    @Test
    void contextLoads() {
    }

    /**
     * 数据库连接池
     * 1.DBCP
     * 2.c3p0
     * 3.Hikari:管理数据库链接对象
     * HikariProxyConnection@1202790087 wrapping com.mysql.cj.jdbc.ConnectionImpl@58fa5769
     * @throws SQLException
     */

    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

}
