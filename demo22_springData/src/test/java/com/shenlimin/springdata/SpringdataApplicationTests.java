package com.shenlimin.springdata;

import com.shenlimin.springdata.jpa.Person;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class SpringdataApplicationTests {

    private ApplicationContext ctx = null;
    private Person personRepository;

    @Before
    public void  init(){
        ctx = new ClassPathXmlApplicationContext();
    }


    @Test
    void contextLoads() {
    }

}
