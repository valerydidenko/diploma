package diploma.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

@SpringBootConfiguration
@ComponentScan(basePackages = {"diploma"})
public class AppConfig {

    @Bean
    public DataSource dataSource () {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:mysql://localhost:3306/diploma");
        builder.username("root");
        builder.password("picard");
        return builder.build();
    }

    @Bean
    public Logger logger () {
        return LoggerFactory.getLogger(this.getClass());
    }

}