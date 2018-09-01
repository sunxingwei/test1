package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Created by sunxw on 2018-08-18 11:38
 */
public class TestLambda2 {

    @Test
    public void test12(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Optional<Double> reduce = getList().stream().map(Employee::getSalary).reduce(Double::sum);
        Integer sum = list.stream().reduce(0, (x, y) ->Integer.sum(x,y));
        int sum1 = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum1 = " + sum1);
        System.out.println("sum = " + sum);
        Integer i = getList().stream().map(Employee::getName)
                .flatMap((str) -> {
                    List<Character> characters = new ArrayList<>();
                    char[] chars = str.toCharArray();
                    for (Character character : chars) {
                        characters.add(character);
                    }
                    return characters.stream();

                })
                .map(character -> {
                    if (character.equals('三')) {
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .reduce(Integer::sum).get();

    }



    @Test
    public void test11(){

        Consumer<String> str = (s)-> System.out.println("s = " + s);
        Consumer<String> str12 = System.out::println;
        str.accept("ddd");

        Supplier<Integer> supplier = ()->(int)(Math.random()*100);
        Integer integer = supplier.get();
        Function<String,String> function = (str1)->str1.toLowerCase();
        Predicate<String> predicate = (s)->s.equals("ddd");

        //testConsumer("测试",(s)-> System.out.println("平时经理级"+s));
        String sstr = testSupplier(()->(int)(Math.random() * 100));
        System.out.println("sstr = " + sstr);
    }


    public String testSupplier(Supplier<Integer> s){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <50 ; i++) {
            Integer integer = s.get();

            stringBuilder.append(integer+">");
        }
        return stringBuilder.toString();
    }


    public void testConsumer(String tests,Consumer<String> consumer){
        consumer.accept(tests);

    }
    
    
    @Test
    public void test6(){
       String sss =  gets("eeee",(ss)->ss.toLowerCase());
        System.out.println("sss = " + sss);
        String stre = gets("weryeee",(str)-> str.substring(2,4));
        System.out.println("stre = " + stre);
    }
    
    public String gets(String s,TestString<String> str){
        return str.getValue(s);
    }
    
    @Test
    public void test5(){

        Collections.sort(getList(),
                (o1,o2)->{
                if(o1.getAge() == o2.getAge()){
                    return o1.getName().compareTo(o2.getName());
                }else {
                    return Integer.compare(o1.getAge(),o2.getAge());
                }
                });
    }
    
    
     public List<Employee> getList(){
         List<Employee> emps = Arrays.asList(
                 new Employee(101, "张三", 18, 9999.99),
                 new Employee(102, "李四", 59, 6666.66),
                 new Employee(103, "王五", 28, 3333.33),
                 new Employee(104, "赵六", 8, 7777.77),
                 new Employee(105, "田七", 38, 5555.55)
         );
         return emps;

     }





    /**
     * 对一个数进行运算
     */
    @Test
    public void test4(){
        Integer x = op(1, new MyPredicacte1<Integer, Integer>() {
            @Override
            public Integer test(Integer x) {
                return x * x;
            }
        }); 
        Integer dd = op(1,(yy) -> yy * yy);


    }

    public Integer op(Integer x,MyPredicacte1<Integer,Integer> pr){
        
        return  pr.test(x);
    }
    /**
     *有两个以上的参数，有返回值，且Lambda有多条语句
     */
    @Test
    public void test3(){

        Comparator<Integer> com = (x, y) -> {
            System.out.println("sss");
            int compare = Integer.compare(x, y);
            return compare;
        };

        int compare = com.compare(9, 4);
        System.out.println(compare);
        /**
         * 如果只有一条语句，return 和大括号可以省略不写；
         */
        Comparator<Integer> comm =(x,y) -> Integer.compare(x,y);
    }

    /**
     * 有一个参数，没有有返回值
     */
    @Test
    public void test2(){
        Consumer<String> con = s-> System.out.println("ssss"+s);
        con.accept("ddddd");
    }


    /**
     * 无参数，无返回值
     */
    @Test
    public void test1(){
        /*Runnable r = () ->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("test>>>>");};
        r.run();
        new Thread(r).start();*/


        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("ddddd");
        },"test").start();

    }





}
