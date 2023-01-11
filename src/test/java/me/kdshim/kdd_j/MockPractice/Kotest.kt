package me.kdshim.kdd_j.MockPractice

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotlintest.specs.BehaviorSpec
import me.kdshim.kdd_j.swagger.model.GetLinkDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
class Kotest(
    @Autowired var mockMvc: MockMvc,
    @Autowired var objectMapper: ObjectMapper
) : BehaviorSpec({
    given("세팅") {
        `when`("아무튼 시작") {
            then("이게그래서 뭐지")
        }
    }

    given("링크를 등록한다") {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/link")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """{
  "category": "JAVA",
  "memo": "this is test only link",
  "name": "test link",
  "url": "localhost"
}"""
                )
        )
            .andExpect(MockMvcResultMatchers.status().`is`(200))
            .andExpect(MockMvcResultMatchers.jsonPath("$.category").value("JAVA"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.memo").value("this is test only link"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("test link"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.url").value("localhost"))

        `when`("링크를 확인한다"){
            mockMvc.perform(MockMvcRequestBuilders.get("/links"))
                .andExpect(MockMvcResultMatchers.status().`is`(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].category").value("JAVA"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].memo").value("this is test only link"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("test link"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].url").value("localhost"))

            then("뭐 그래서 결과는 어떻다?"){
                val response: String = mockMvc.perform(MockMvcRequestBuilders.get("/link/localhost"))
                    .andExpect(MockMvcResultMatchers.status().`is`(200))
                    .andReturn().getResponse().getContentAsString()
                println(response)
                val link: GetLinkDto = objectMapper.readValue<GetLinkDto>(response, GetLinkDto::class.java)

                link.name == "test link"
            }
        }
    }
})