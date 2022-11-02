package dev.igor.todo.configuration;

import dev.igor.todo.service.DBService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    private final DBService dbService;

    public TestConfig(DBService dbService) {
        this.dbService = dbService;
    }

    public boolean instance() {
        this.dbService.databaseInstance();
        return true;
    }
}
