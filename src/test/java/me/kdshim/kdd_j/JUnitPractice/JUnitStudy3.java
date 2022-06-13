package me.kdshim.kdd_j.JUnitPractice;

import me.kdshim.kdd_j.config.BaseExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BaseExtension.class)
//기본적으로 선언된 모든 테스트들은 인스턴스가 독립적이다 클래스단위에서 선언한 값들은 각 테스트가 실행되면서 없어진다
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//Alphanumeric, OrderAnnotation, Random
public class JUnitStudy3 {
    int checkVal = 0;

    //@TestInstance 애너테이션을 사용하게 되면 @Before~, @After~를 사용하는데 있어서도 굳이 static 선언하지 않아도 잘 된다
    @BeforeAll
    void checkBefore(){
        System.out.println("With @TestInstance -> No Static!");
    }

    //기본적으로 테스트의 순서는 위에서부터 진행되며 애노테이션등을 사용해서 테스트의 순서를 정하는 것이 가능하다
    //사실 단위테스트라는 것은 각 테스트는 독립적으로 실행되어야하는 것이지 서로의 테스트가 의존적이면 단위테스트가 아니다!
    //하지만 시나리오테스트와 같은 케이스는 순서대로 진행되어야하는 케이스가 존재하다


    @Order(2)
    @Test
    void firstTest(){
        checkVal++;
        Assertions.assertEquals(checkVal, 4);
        System.out.println("this is second Test");
    }

    @Order(1)
    @Test
    void secTest(){
        System.out.println("this is first Test");
        checkVal++;
        Assertions.assertEquals(checkVal, 3);
    }

    @Order(0)
    @Test
    void thirdTest(){
        System.out.println("this is zero Teest");
        checkVal++;
        Assertions.assertEquals(checkVal, 1);
    }

    @Order(0)
    @Test
    void forthTest(){
        System.out.println("this is duplicated with 0");
        checkVal++;
        Assertions.assertEquals(checkVal, 2);
    }

    //QUIZ
    //1. @DisplayName
    //2. junit platform
    //3. @Tag
    //4. assertAll
    //FIXME 5. METHOD 뭐시기... -> RetentionPolicy.RUNTIME 이야 이거 들었던건데 까먹었네...
    //6. @ExtendsWith, ServiceLoader, @RegisterExtension
    //7. PER_CLASS, OrderAnnotation
    //FIXME 8. ???? -> @ParameterizedTest, @AggregateWith
}
