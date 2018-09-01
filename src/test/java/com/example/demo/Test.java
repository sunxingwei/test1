import com.example.demo.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Test {

    public static <T> T toBean(ObjectMapper mapper, String info, Class<T> clazz) throws IOException {
            return mapper.readValue(info, clazz);
    }
    @org.junit.Test
    public  void test3(){
        new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer.compare(o1.length(), o2.length());
                return o1.compareTo(o2);
            }
        };
        Comparator<String> com = (o1, o2) -> o1.compareTo(o2);


        TreeSet<Employee> employees = new TreeSet<>();
        employees.addAll(emps);
        for (Employee em : employees){
            System.out.println("em = " + em);
        }
        filterEmployee(emps,new Mytest());
        filterEmployee(emps, new TestTest<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 20;
            }
        });
        List<Employee> list = filterEmployee(emps,e -> e.getAge()>30);
        List<Employee> list1dd = filterEmployee(emps,e -> e.getAge() > 3);
        List<Employee> listdd = filterEmployee(emps,employee -> employee.getAge() > 12);
        List<Employee> listddd = filterEmployee(emps, new TestTest<Employee>() {
            @Override
            public boolean test(Employee employee) {
                String name = employee.getName();
               return  name.equals("ddd");
            }
        });

    }

    public List<Employee> filterEmployee(List<Employee> emps,TestTest<Employee> test){
        List<Employee> list = new ArrayList<>();
        for(Employee employee : emps){

            if(test.test(employee)){

                list.add(employee);
            }
        }
        return list;
    }

    //需求：获取公司中年龄小于 35 的员工信息
    public List<Employee> filterEmployeeAge(List<Employee> emps){
        List<Employee> list = new ArrayList<>();
        for (Employee employee : emps){
            if(employee.getAge() < 35){
                list.add(employee);
            }
        }
        return list;
    }
    //需求：获取公司中工资大于 5000 的员工信息
    public List<Employee> filterEmployeeSalary(List<Employee> emps){
        List<Employee> list = new ArrayList<>();
        for (Employee employee : emps){
            if (employee.getSalary() > 5000){
                list.add(employee);
            }
        }
        return list;
    }



    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );
}

interface TestTest<T>{

    boolean test(T t);
}

class Mytest implements TestTest<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 5000;
    }
}