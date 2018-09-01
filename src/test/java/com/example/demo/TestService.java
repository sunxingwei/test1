package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.lang.model.SourceVersion;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sunxw on 2018-08-23 18:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {

    @Autowired
    DataSource dataSource;
    @Autowired
    EmployeeMapper employeeMapper;


    @Test
    public void testEntityWrapperDelete() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);

        Employee employee = employeeMapper.selectById("1");
        System.out.println(employee);
    }

}
