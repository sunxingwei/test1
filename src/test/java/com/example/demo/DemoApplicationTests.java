package com.example.demo;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {

		Stream<Integer> stream2 = Stream.of(1, 5, 7,9,5,2);
		stream2.skip(1).limit(4).forEach(System.out::println);
		Optional<Integer> any = stream2.findAny();
		long count = stream2.count();


		/*ArrayList<String> list = new ArrayList<>();
		list.forEach(System.out::println);
		HashSet<String> set = new HashSet<>();
		set.forEach(System.out::println);
		HashMap<String, String> map = new HashMap<>();
		map.forEach((k,v)-> System.out.println("v = " + v+"k"+k));
		Collection<String> values = map.values();
		map.values().stream().collect(Collectors.toList());*/
	}

}
