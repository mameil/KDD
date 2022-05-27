package me.kdshim.kdd_j.JUnitPractice;

import me.kdshim.kdd_j.link.entity.CATEGORY;
import me.kdshim.kdd_j.link.entity.Link;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class JUnitStudy1 {
    static int cnt = 0;

    @BeforeAll
    //BeforeAll은 무조건 static 타입으로 들어가야 한다, 실제 테스트 메소드 이름은 뭘로하든 상관없음
    static void startWith() {
        System.out.println("ALL_TEST_START");
    }

    @AfterAll
    //spock에서의 cleanup과 같은 역할
    static void endWith() {
        System.out.println("ALL_TEST_END!");
    }

    @BeforeEach
        //each들은 static 이면 안된다..!
    void beforeEach() {
        System.out.println("==============================================");
        System.out.println(++cnt + "번째 테스트 시작");
    }

    @AfterEach
    void afterEach() {
        System.out.println("별 문제 없이 "+cnt + "번째 테스트 종료");
        System.out.println("==============================================");
    }

    @Test
    @DisplayName("\uD83D\uDE31")
    void create_first_test() {
        Link link = new Link();
        assertNotNull(link);
    }

    @Test
    void create_second_test() {
        Link link = new Link();
        assertNotNull(link);
    }

    @Test
    @Disabled
        //WHY FAIL?
    void update() {
        Link link = new Link();
        Link link2 = new Link();
        link2.setName("TEST");
        assertNotEquals(link, link);
    }

    @Test
    void assertionTest() {
        Link link = new Link();
        link.setName("link1");
        link.setCategory(CATEGORY.JAVA);

        Link link2 = new Link();
        link2.setName("link2");
        link2.setCategory(CATEGORY.JAVA);

        assertAll(
                () -> assertNotNull(link),
                () -> assertEquals(link.getCategory(), link2.getCategory(), () -> "두 링크들은 " + link.getCategory() + "범주안에 있는 링크들이다"),

                () -> assertTrue(link.getUrl() == null)
        );

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> link.checkCoke("나는콜라가좋아"));
        assertEquals(exception.getMessage(), "콜라는 안돼요!");

        //요놈은 해당 executable이 어떤 시간 안에 실행되어야하는지를 판단하는 함수이다
        //특징으로는 만약 executable이 길어지면 그 길어지는 시간만큼 기다린다는 것이 단점이다 그래서 만약 기다리지 않고 에러뱉고 넘어가기 위해서는 assertTimeoutPreemptively()를 쓰자
        assertTimeout(Duration.ofSeconds(10), () -> link2.checkCoke("test"));

        //조건에 따라서 테스트 실행하는 방법
        //jupiter에서 제공해주는 assumeTrue에 조건을 걸어주면 해당 줄 이하의 테스트는 진행하지 않는다 -> 대신 틀렸다고
        assumeTrue(link.checkCoke("나는콜라가싫은걸~"));
        System.out.println("내가 보인다는 것은 true가 나왔다는 의미");

        assumingThat("link1".equals(link.getName()), () -> {
            System.out.println("assumingThat에 주어준 조건이 성공일 시 이 프린트문이 출력됨");
        });

    }
}
