package me.kdshim.kdd_j.MockPractice;

import me.kdshim.kdd_j.book.entity.Book;
import me.kdshim.kdd_j.config.BaseSupport;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.book.BookService;
import me.kdshim.kdd_j.link.LinkRepository;
import me.kdshim.kdd_j.recipe.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class MockStudy1 extends BaseSupport {
    //Mock처리하는 방법2
    @Mock BookService bookService;
    @Mock LinkRepository linkRepositroy;

    @KDTest
    void BookServiceTest(@Mock RecipeService recipeService){
        //Mock처리하는 방법1
//        BookService bookService = mock(BookService.class);
//        LinkRepositroy linkRepositroy = mock(LinkRepositroy.class);

        Assertions.assertNotNull(bookService);
        Assertions.assertNotNull(linkRepositroy);
        Assertions.assertNotNull(recipeService);

        when(bookService.findSingleBookById("MOCK"))
                .thenReturn(Book.builder().name("MockedBook").url("https://MOCKED").recommender("MOCKER").build())
        ;

        when(bookService.findSingleBookById("ERROR"))
                .thenThrow(new RuntimeException())
        ;

        Book checkMock = Book.builder().name("MockedBook").url("https://MOCKED").recommender("MOCKER").build();
        Assertions.assertEquals(checkMock, bookService.findSingleBookById("MOCK"));

        //throw
        Assertions.assertThrows(RuntimeException.class, () -> bookService.findSingleBookById("ERROR"));

        //같으 매개변수에 대해서 순서에 따라서 다르게 Stubbing이 가능하구나..!
        when(bookService.findSingleBookById(any()))
                .thenThrow(new IllegalArgumentException())
                .thenReturn(Book.builder().name("secondBook").url("testURL").build())
                .thenReturn(null)
        ;

        Assertions.assertThrows(IllegalArgumentException.class, () -> bookService.findSingleBookById("DIFF"));
        Book checkDif = Book.builder().name("secondBook").url("testURL").build();
        Assertions.assertEquals(checkDif, bookService.findSingleBookById("DIFF"));
        Assertions.assertEquals(null, bookService.findSingleBookById("DIFF"));

        //Mock 객체를 확인하는 방법
//        verify(linkRepositroy, times(0)).notify();
//
//        InOrder order = inOrder(linkRepositroy);
//        order.verify(linkRepositroy).notify();
//        order.verify(linkRepositroy).notify();

    }
}
