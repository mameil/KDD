package me.kdshim.kdd_j.JUnitPractice;

import me.kdshim.kdd_j.KDTest;
import me.kdshim.kdd_j.link.entity.CATEGORY;
import me.kdshim.kdd_j.link.entity.Link;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class JUnitStudy2 {

    @Test
    @Tag("KDS")
    Link create_link(){
        Link link = Link.builder().url("htttp://testset").category(CATEGORY.FOOD).desc("테스트에서 사용할 링크").name("테링").build();
        System.out.println(link.toString());
        return link;
    }

    @Test
    @Tag("bdd")
    void checkSimpleLink(){
        Link mylink = create_link();
        assertEquals(mylink.getUrl(), "htttp://testset");
        assertNotEquals(mylink.getCategory(), CATEGORY.JAVA);
        //tag별로 테스트를 진행하기 위서는 run configuration으로 들어가서보면 기본으로 class으로 되어있는데 이걸 tag으로 변경하고 expression에다가 원하는 태그를 직접 작성하자
    }

    @KDTest
    void myCustomTagTest(){
        System.out.println("tag 애노테이션에 KDS가 들어있다!!");
    }

    @DisplayName("Repeating Test")
    @RepeatedTest(value = 10, name = "{displayName} : {totalRepetitions}개 중에 {currentRepetition} 번째")
    void repeatTest(RepetitionInfo info){
        System.out.println(info + " 번째 테스트 진행");
    }

    @ParameterizedTest
    @ValueSource(strings = {"firParam", "secParam", "thirParam"})
    @NullAndEmptySource //이거쓰면 맨 마지막에 null을 넣었을 때, 빈값을 넣었을때도 테스트해준다
    void paramTest(String msg){
        System.out.println(" - " + msg);
    }

}
