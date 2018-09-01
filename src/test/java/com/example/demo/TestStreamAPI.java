package com.example.demo;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sunxw on 2018-08-18 17:56
 */
public class TestStreamAPI {


    @Test
    public void test5(){
        String example1 = "2018-08-2017:00";
            String example = "2018-08-20 17:00";
            int length = example.length();
            System.out.println(length);
        System.out.println(example1.length());
    }



    /*
    flatMap:接受一个函数作为参数，将流中的每一个值都换成另一个流，然后把流链接成一个流。
     */
    @Test
    public void test4(){

        List<String> list = Arrays.asList("sss","ddd","ggg");
        
        list.stream().sorted().forEach((s)->System.out.println(s));

        Stream<Employee> sorted = getList().stream().sorted((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                // return e1.getAge().compareTo(e2.getAge());
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        List<Employee> collect = sorted.collect(Collectors.toList());
        Set<Employee> collect1 = sorted.collect(Collectors.toSet());


        Stream<Character> characterStream1 = list.stream().flatMap((str) -> {
            List<Character> characters = new ArrayList<>();
            char[] chars = str.toCharArray();
            for (Character c : chars) {
                characters.add(c);
            }
            return characters.stream();
        });

        characterStream1.forEach(System.out::println);


        Stream<Character> characterStream = list.stream().flatMap((sm) -> filterCharacter(sm));

        characterStream.forEach(System.out::println);
        
        Stream<Stream<Character>> streamStream = list.stream()
                               .map((s) -> filterCharacter(s));
        streamStream.forEach((sm)->sm.forEach(System.out::println));


    }
    public Stream<Character> filterCharacter(String str){
        List<Character> characters = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            characters.add(character);
        }
       return characters.stream();
    }

    @Test
    public void test3(){
        getList().stream()
                .map(Employee::getAge)
                .forEach(System.out::println);
    }


    @Test
    public void test2(){




        getList().stream()
                .filter((e)->{
                    System.out.println(" = ddd"+e);
                    return e.getAge() > 102;}).limit(2)
                //.skip(1)
                .forEach(System.out::println);
    }

    @Test
    public void test1(){
        //通过Collection 系列集合提供stream()或paralleLStream()
        List<Employee> list = getList();
        Stream<Employee> stream =  list.stream();
        stream.forEach(System.out::println);

        Stream<Employee> stream1 = list.parallelStream();
        stream1.forEach(System.out::println);

        Employee[] arrem = new Employee[10];

        //通过arrays中的静态方法Stream()获取是数组流
        Stream<Employee> stream2 = Arrays.stream(arrem);
        //通过strem类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc", "dd", "ee", "ff");
        System.out.println("stream3 = " + stream3);
        //创建无限流


        Consumer<Integer> con = (x) -> x.toString();
        Function<Integer,String> fun = (s) -> s.toString();
        Stream<Integer> st = Stream.iterate(0,(x)-> x + 2);
        Stream<Integer> limit = st.limit(4);


        Stream<Integer> sream = Stream.generate(()->(int)(Math.random()*100));

        sream.limit(5).forEach((x) -> System.out.println(x.toString()));







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

}
