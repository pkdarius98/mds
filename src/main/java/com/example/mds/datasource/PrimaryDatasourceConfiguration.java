package com.example.mds.datasource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PrimaryDatasourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.primary")
    public DataSourceProperties primaryDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource primaryDataSource() {
        return primaryDatasourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }
}
