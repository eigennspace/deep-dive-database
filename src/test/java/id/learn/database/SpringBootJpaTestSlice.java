package id.learn.database;

import id.learn.database.jpa.model.Book;
import id.learn.database.jpa.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/***
 * @author : github.com/eigennspace
 * @since : Tue 18/04/2023 13:35
 * @Project : deep-dive-database
 * @Created_by : IdeaU
 */

@DataJpaTest
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testJpaTestSplice(){
        long countBefore = bookRepository.count();

        bookRepository.save(new Book("Test Add book", "333-222", "Test Publisher"));

        long countAfter = bookRepository.count();

        assertThat(countAfter).isGreaterThan(countBefore);
    }

}
