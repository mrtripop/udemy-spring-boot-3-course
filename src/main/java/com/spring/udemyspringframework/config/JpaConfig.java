package com.spring.udemyspringframework.config;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
// @EnableJpaRepositories(basePackages =
// "com.spring.udemyspringframework.repository")
public class JpaConfig {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    Session getSession() {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();
        return session;

    }
}
