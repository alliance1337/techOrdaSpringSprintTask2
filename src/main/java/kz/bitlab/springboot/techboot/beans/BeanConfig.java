package kz.bitlab.springboot.techboot.beans;


import kz.bitlab.springboot.techboot.dbconnect.DBConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class BeanConfig {


    @Bean
    public DBConnector connection(){
        DBConnector dbConnector = new DBConnector("jdbc:mysql://localhost:3306/techbootdb", "root", "root");
        return dbConnector;
    }

}
