package diploma.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

@SpringBootConfiguration
@ComponentScan(basePackages = {"diploma"})
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:mysql://localhost:3306/diploma?createDatabaseIfNotExist=true");
        builder.username("root");
        builder.password("root");
        return builder.build();
    }

}