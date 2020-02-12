package com.fredrikpedersen.dependencyinjectiondemo.config;

import com.fredrikpedersen.dependencyinjectiondemo.examplebeans.FakeDataSource;
import com.fredrikpedersen.dependencyinjectiondemo.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 21/01/2020 at 18:32
 */

@Configuration
public class PropertyConfig {

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
}
