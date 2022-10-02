package me.kdshim.kdd_j.todo;

import lombok.SneakyThrows;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyMockMvc;
import me.kdshim.kdd_j.member.Member;
import me.kdshim.kdd_j.member.MemberRepository;
import me.kdshim.kdd_j.swagger.model.GetMemberDto;
import me.kdshim.kdd_j.todo.entity.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Disabled
public class TodoTest extends MyMockMvc {

    @Autowired
    TodoRepository todoRepository;


    @SneakyThrows
    @KDTest
    @DisplayName("todo 등록 테스트")
    public void TodoPostTest() {


        String plainString =
                mvc.perform(MockMvcRequestBuilders.post("/todo")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\n" +
                                        "  \"todo\": \"do something\",\n" +
                                        "  \"endDate\": \"20220731\"\n" +
                                        "}")
                        )
                        .andExpect(MockMvcResultMatchers.status().is(200))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.todo").value("do something"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("20220731"))
                        .andReturn().getResponse().getContentAsString();

        Todo testM = getObjectMapper().readValue(plainString, Todo.class);
        Assertions.assertEquals(testM.getTodo(), "do something");
        Assertions.assertEquals(testM.getEndDate(), "20220731");
    }

    @KDTest
    @DisplayName("모든 TODO 조회 테스트")
    public void getAllTodoTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"todo\": \"테스트 TODO 1\",\n" +
                                "  \"endDate\": \"20220715\"\n" +
                                "}")
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
        ;

        mvc.perform(MockMvcRequestBuilders.post("/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"todo\": \"테스트 TODO 2\",\n" +
                                "  \"endDate\": \"20220715\"\n" +
                                "}")
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
        ;

        mvc.perform(MockMvcRequestBuilders.post("/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"todo\": \"테스트 TODO 3\",\n" +
                                "  \"endDate\": \"20220715\"\n" +
                                "}")
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
        ;

        mvc.perform(MockMvcRequestBuilders.get("/todo/all"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dtoList[?(@.id==1)].todo").value("테스트 TODO 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dtoList[?(@.id==1)].status").value("UNDONE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dtoList[?(@.id==1)].endDate").value("20220715"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dtoList[?(@.id==2)].todo").value("테스트 TODO 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dtoList[?(@.id==2)].status").value("UNDONE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dtoList[?(@.id==2)].endDate").value("20220715"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dtoList[?(@.id==3)].todo").value("테스트 TODO 3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dtoList[?(@.id==3)].status").value("UNDONE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dtoList[?(@.id==3)].endDate").value("20220715"))
                ;
    }

    @SneakyThrows
    @KDTest
    @DisplayName("UNDONE 인 TODO 모두 조회 테스트")
    public void UNDONETodoGetTest() {
        mvc.perform(MockMvcRequestBuilders.post("/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"todo\": \"do something\",\n" +
                                "  \"endDate\": \"20220731\"\n" +
                                "}")
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
        ;

        String getTodoList = mvc.perform(MockMvcRequestBuilders.get("/todo/undone"))
                .andExpect(MockMvcResultMatchers.status().is(200))

                .andReturn().getResponse().getContentAsString();

        System.out.println("==============================================");
        System.out.println(getTodoList);
        System.out.println("==============================================");
    }
}
