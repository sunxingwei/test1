package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.JsonResult;
import com.example.demo.model.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sunxw on 2018-08-24 11:08
 */
@Api(value = "测试demo", description = "测试demo")
@RestController
@RequestMapping("/test")
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;


    @ApiOperation(value = "测试demo")
    @GetMapping(value = "/demo", produces = "application/json;charset=utf-8")
    public JsonResult getEmployees() {
        List<Employee> employees = employeeMapper.selectEmployeeall();
        return ResultUtil.success(employees);
    }

    @ApiOperation(value = "测试demo")
    @GetMapping(value = "/demo1", produces = "application/json;charset=utf-8")
    public JsonResult getEmployees1() {
        List<Employee> employees = employeeMapper.selectList(null);
        return ResultUtil.success(employees);
    }
}
