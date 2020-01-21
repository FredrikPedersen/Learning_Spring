package com.fredrikpedersen.dependencyinjectiondemo.config;

import com.fredrikpedersen.dependencyinjectiondemo.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 21/01/2020 at 18:32
 */

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    @Value("${com.fredrikpedersen.username}")
    String user;

    @Value("${com.fredrikpedersen.password}")
    String password;

    @Value("${com.fredrikpedersen.dburl}")
    String url;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
