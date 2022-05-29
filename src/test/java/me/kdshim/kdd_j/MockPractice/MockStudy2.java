package me.kdshim.kdd_j.MockPractice;

import jdk.nashorn.internal.ir.annotations.Ignore;
import me.kdshim.kdd_j.book.BookRepository;
import me.kdshim.kdd_j.book.BookService;
import me.kdshim.kdd_j.book.entity.Book;
import me.kdshim.kdd_j.config.KDBaseExtension;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyTest;
import me.kdshim.kdd_j.link.LinkRepositroy;
import me.kdshim.kdd_j.link.LinkService;
import me.kdshim.kdd_j.recipe.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.inOrder;

public class MockStudy2 extends MyTest {
    //Mock처리하는 방법2
    @Mock
    BookService bookService;
    @Mock
    LinkRepositroy linkRepositroy;

    @KDTest
    void BookServiceTest(){
        //Mock처리하는 방법1
//        BookService bookService = mock(BookService.class);
//        LinkRepositroy linkRepositroy = mock(LinkRepositroy.class);

        Assertions.assertNotNull(bookService);
        Assertions.assertNotNull(linkRepositroy);

        given(bookService.findSingleBookById("MOCK"))
                .willReturn(Book.builder().name("MockedBook").url("https://MOCKED").recommender("MOCKER").build())
        ;

        given(bookService.findSingleBookById("ERROR"))
                .willThrow(new RuntimeException())
        ;

        Book checkMock = Book.builder().name("MockedBook").url("https://MOCKED").recommender("MOCKER").build();
        Assertions.assertEquals(checkMock, bookService.findSingleBookById("MOCK"));

        //throw
        Assertions.assertThrows(RuntimeException.class, () -> bookService.findSingleBookById("ERROR"));

        //같으 매개변수에 대해서 순서에 따라서 다르게 Stubbing이 가능하구나..!
        given(bookService.findSingleBookById(any()))
                .willThrow(new IllegalArgumentException())
                .willReturn(Book.builder().name("secondBook").url("testURL").build())
                .willReturn(null)
        ;

        Assertions.assertThrows(IllegalArgumentException.class, () -> bookService.findSingleBookById("DIFF"));
        Book checkDif = Book.builder().name("secondBook").url("testURL").build();
        Assertions.assertEquals(checkDif, bookService.findSingleBookById("DIFF"));
        Assertions.assertEquals(null, bookService.findSingleBookById("DIFF"));

        //Mock 객체를 확인하는 방법
//        then(linkRepositroy).should(times(1)).notify();
//        then(linkRepositroy).should(times(1)).notify();
//        verify(linkRepositroy, times(1)).notify();

        //verify라는 메소드는 테스트를 진행하면서 어떤 변수들을 참조했고, 어떤 메소드들을 몇 번, 아니면 사용하지 않았는지 확인하는 그런 함수
//        InOrder order = inOrder(linkRepositroy);
//        order.verify(linkRepositroy).notify();

    }

    @KDTest
    @Ignore
    void verifyTest(){
        Book book = Book.builder().name("Error").url("qwer").recommender("ME").build();
        given(bookService.findSingleBookById("ERROR")).willReturn(book);

        Assertions.assertEquals(book, bookService.findSingleBookById("ERROR"));
        bookService.findSingleBookById("ERROR");

        //기존에 verify하고 싶은게 있었는데
        //현재 상황은 bookService 내부에 linkRepository가 구현되어있고 사용되고 있는데, 내가 하고 싶었던건
        //bookService의 메소드를 사용해서 그 안에 있는 linkRepository를 사용한건지 확인하고 싶었지만 stubbing을 했기 때문에 내부의 구현은 진행하지 못한다
        verify(bookService, times(2)).findSingleBookById("ERROR");
    }
}
