package id.learn.database.jpa.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/***
 * @author : github.com/eigennspace
 * @since : Tue 18/04/2023 16:57
 * @Project : deep-dive-database
 * @Created_by : IdeaU
 */
@Profile("clean")
@Configuration
public class DbClean {

    @Bean
    public FlywayMigrationStrategy clean(){
        return flyway -> {
            flyway.clean();
            flyway.migrate();
        };
    }
}
