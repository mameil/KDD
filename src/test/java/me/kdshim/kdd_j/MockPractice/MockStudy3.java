package me.kdshim.kdd_j.MockPractice;

import lombok.extern.slf4j.Slf4j;
import me.kdshim.kdd_j.book.BookRepository;
import me.kdshim.kdd_j.book.BookService;
import me.kdshim.kdd_j.book.entity.Book;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyTest;
import me.kdshim.kdd_j.link.LinkService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Slf4j
public class MockStudy3 extends MyTest {
    @InjectMocks
    BookService bookService;

    @Mock
    LinkService linkService;

//    static MySQLContainer mySQLContainer = new MySQLContainer();

    @BeforeAll
    void before(){
//        Slf4jLogConsumer consumer = new Slf4jLogConsumer(log);
//        mySQLContainer.followOutput(consumer);
    }

    @KDTest
    void verifyTest2(){
        bookService.chain();

        verify(linkService, times(1)).testSave();
    }
}
