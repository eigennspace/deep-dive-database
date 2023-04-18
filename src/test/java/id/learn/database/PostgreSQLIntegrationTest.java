package id.learn.database;

import id.learn.database.jpa.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/***
 * @author : github.com/eigennspace
 * @since : Tue 18/04/2023 14:07
 * @Project : deep-dive-database
 * @Created_by : IdeaU
 */

@ActiveProfiles("dev")
@DataJpaTest
@ComponentScan(basePackages = {"id.learn.database.jpa.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostgreSQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testPostgreSQL(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
    }

}
