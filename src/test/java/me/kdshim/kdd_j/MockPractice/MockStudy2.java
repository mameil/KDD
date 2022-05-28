package me.kdshim.kdd_j.MockPractice;

import me.kdshim.kdd_j.book.BookService;
import me.kdshim.kdd_j.book.entity.Book;
import me.kdshim.kdd_j.config.KDBaseExtension;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.link.LinkRepositroy;
import me.kdshim.kdd_j.recipe.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.inOrder;

public class MockStudy2 extends KDBaseExtension {
    //Mock처리하는 방법2
    @Mock
    BookService bookService;
    @Mock
    LinkRepositroy linkRepositroy;

    @Test
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
        then(linkRepositroy).should(times(1)).notify();
        then(linkRepositroy).should(times(1)).notify();


        InOrder order = inOrder(linkRepositroy);
        order.verify(linkRepositroy).notify();

    }
}
