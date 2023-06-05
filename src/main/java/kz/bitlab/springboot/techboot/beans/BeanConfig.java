package kz.bitlab.springboot.techboot.beans;


import kz.bitlab.springboot.techboot.dbconnect.DBConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class BeanConfig {

    @Bean(name = "ilyasBean")
    public TestB testB(){
        TestB testB = new TestB("Ilyas", 4545);
        testB.setCode("Mark");
        return testB;
    }

    @Bean(name = "johnBean")
    public TestB testBg(){
        TestB testB = new TestB("Ilyas", 4545);
        testB.setCode("Mark");
        return testB;
    }

    @Bean
    public DBConnector connection(){
        DBConnector dbConnector = new DBConnector("jdbc:mysql://localhost:3306/techbootdb", "root", "root");
        return dbConnector;
    }

}
