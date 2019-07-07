package com.mycclee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import javax.sql.DataSource;

/**
 * @author mycclee
 * @createTime 2019/7/7 8:40
 */
public class SSSPTest {

    private ApplicationContext ctx = null;

    {
        ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void testConnection() throws Exception{
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
