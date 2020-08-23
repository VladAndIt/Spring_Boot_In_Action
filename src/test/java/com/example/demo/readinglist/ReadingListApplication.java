package com.example.demo.readinglist;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ReadingListApplication.class);
@WebAppConfiguration

public class ReadingListApplication {
    @Test
    @Ignore
    public void contextLoads() {

    }
}
