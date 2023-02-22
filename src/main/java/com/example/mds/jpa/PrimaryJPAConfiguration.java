package com.example.mds.jpa;

import com.example.mds.entity.primary.PrimaryTodo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.mds.entity.primary",
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager"
)
public class PrimaryJPAConfiguration {
    @Bean
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            @Qualifier("primaryDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder
    ) {
        return builder
                .dataSource(dataSource)
                .packages(PrimaryTodo.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("primaryEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
    ) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryBean.getObject()));
    }
}
