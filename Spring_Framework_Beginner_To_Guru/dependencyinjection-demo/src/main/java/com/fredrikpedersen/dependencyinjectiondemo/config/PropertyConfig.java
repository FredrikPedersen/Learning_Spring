package com.fredrikpedersen.dependencyinjectiondemo.config;

import com.fredrikpedersen.dependencyinjectiondemo.examplebeans.FakeDataSource;
import com.fredrikpedersen.dependencyinjectiondemo.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 21/01/2020 at 18:32
 */

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    @Autowired
    Environment environment;

    @Value("${com.fredrikpedersen.username}")
    String user;

    @Value("${com.fredrikpedersen.password}")
    String password;

    @Value("${com.fredrikpedersen.dburl}")
    String url;

    @Value("${com.fredrikpedersen.jms.username}")
    String jmsUsername;

    @Value("${com.fredrikpedersen.jms.password}")
    String jmsPassword;

    @Value("${com.fredrikpedersen.jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        System.out.println(environment.getProperty("JAVA_HOME")); //Example of how to get hold of environment variables.
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker jmsBroker = new FakeJmsBroker();
        jmsBroker.setUsername(jmsUsername);
        jmsBroker.setPassword(jmsPassword);
        jmsBroker.setUrl(jmsUrl);
        return jmsBroker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
