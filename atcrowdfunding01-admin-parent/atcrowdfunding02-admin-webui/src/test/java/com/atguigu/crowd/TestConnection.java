package com.atguigu.crowd;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
// 加载Spring 配置文件的注解
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class TestConnection {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void testTx() {
        Admin admin = new Admin(null, "jerry", "123456", "杰瑞", "jerry@qq.com", null);
        adminService.saveAdmin(admin);
    }


    @Test
    public void testInsert() {
        Admin admin = new Admin(null, "tom", "123123", "汤姆", "tom@qq.com", null);

        int insert = adminMapper.insert(admin);
        System.out.println(insert);
    }

    @Test
    public void testDataSource() throws SQLException {
// 1.通过数据源对象获取数据源连接
//        Connection connection = dataSource.getConnection();
        // 获取日志记录对象
        Logger logger = LoggerFactory.getLogger(TestConnection.class);
// 2.打印数据库连接
//        System.out.println(connection);
        logger.debug("hello i am debug level!!");
        logger.debug("hello i am debug level!!");
        logger.debug("hello i am debug level!!");

        logger.info("info level!!");
        logger.info("info level!!");
        logger.info("info level!!");

        logger.warn("warn level!!");
        logger.warn("warn level!!");
        logger.warn("warn level!!");

    }
}
