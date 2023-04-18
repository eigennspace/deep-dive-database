package id.learn.database;

import id.learn.database.jpa.model.Book;
import id.learn.database.jpa.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/***
 * @author : github.com/eigennspace
 * @since : Tue 18/04/2023 13:35
 * @Project : deep-dive-database
 * @Created_by : IdeaU
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"id.learn.database.jpa.bootstrap"}) //add packages to spring context
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

//    @Rollback(value = false) -> default behaviour is after transaction in test, will be rollback the transaction
    @Commit
    @Order(1)
    @Test
    void testJpaTestSplice(){
        long countBefore = bookRepository.count(); // this will count zero coz not bring the bootstrap data init
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("Test Add book", "333-222", "Test Publisher"));

        long countAfter = bookRepository.count();

        assertThat(countAfter).isGreaterThan(countBefore);
    }

    @Order(2)
    @Test
    void testJpaTestSpliceTransaction(){
        long countBefore = bookRepository.count();

        assertThat(countBefore).isEqualTo(3);
    }
}
