package com.example.demo;

public class Employee {
    private Integer age;
    private String name;
    private Integer num;
    private Double salary;


    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", salary=" + salary +
                '}';
    }

    public Employee(Integer age, String name, Integer num, Double salary) {
        this.age = age;
        this.name = name;
        this.num = num;
        this.salary = salary;
    }









































    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}