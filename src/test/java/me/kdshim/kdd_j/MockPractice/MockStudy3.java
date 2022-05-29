package me.kdshim.kdd_j.MockPractice;

import me.kdshim.kdd_j.book.BookRepository;
import me.kdshim.kdd_j.book.BookService;
import me.kdshim.kdd_j.book.entity.Book;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyTest;
import me.kdshim.kdd_j.link.LinkService;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MockStudy3 extends MyTest {
    @InjectMocks
    BookService bookService;

    @Mock
    LinkService linkService;

    @KDTest
    void verifyTest2(){
        bookService.chain();

        verify(linkService, times(1)).testSave();
    }
}
