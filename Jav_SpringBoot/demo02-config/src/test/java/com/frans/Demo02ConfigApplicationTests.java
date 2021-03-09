package com.frans;

import com.frans.pojo.Dog;
import com.frans.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo02ConfigApplicationTests {

    @Autowired
    Dog dog;
    @Autowired
    Person person;
    @Test
    void contextLoads() {
        System.out.println(dog);
        System.out.println(person);
    }

}
