package com.ehu.javacafe.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories(
        basePackages = "com.ehu.javacafe.repository"
)
public class RepositoryConfiguration {
}
