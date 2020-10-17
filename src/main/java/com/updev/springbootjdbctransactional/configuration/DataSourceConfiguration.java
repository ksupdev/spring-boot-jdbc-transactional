package com.updev.springbootjdbctransactional.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    @Bean(name = "test")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource casDBDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="jdbc-techdb")
    public JdbcTemplate jdbcTemplate(@Qualifier("test")DataSource idmDBDataSource){
        return new JdbcTemplate(idmDBDataSource);
    }
}
