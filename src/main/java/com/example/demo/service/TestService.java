package com.example.demo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * Created by sunxw on 2018-08-23 18:15
 */

public class TestService {
    @Autowired
    EmployeeMapper employeeMapper;


    @Test
    public void testEntityWrapperDelete() {

        employeeMapper.delete(
                new EntityWrapper<Employee>()
                        .eq("last_name", "Tom")
                        .eq("age", 22)
        );

    }

}
