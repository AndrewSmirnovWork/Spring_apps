package com.spring.demo.springSecurity.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.demo.springSecurity")
@PropertySource({"classpath:persistence-mysql.properties"})
public class springConfig {

    @Autowired
    private Environment env;

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Bean
    public DataSource dataSource() {

        ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();

        try {
            pooledDataSource.setDriverClass("jdbc.driver");
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }
        pooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        pooledDataSource.setUser(env.getProperty("jdbc.user"));
        pooledDataSource.setPassword(env.getProperty("jdbc.password"));

        pooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        pooledDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        pooledDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        pooledDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return pooledDataSource;
    }
    private int getIntProperty(String propName) {

        String propVal = env.getProperty(propName);

        // now convert to int
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }
}
