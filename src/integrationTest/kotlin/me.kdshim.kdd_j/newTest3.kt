package me.kdshim.kdd_j

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest(classes = [KddJApplication::class])
@AutoConfigureMockMvc

//요게 추가되어야 같이 돌아가나..? 아니면 애초에 디비에 저장하는 테스트가 없어서 그냥도 되는건가..
@ContextConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class newTest3 @Autowired constructor(
    val mockMvc: MockMvc
)
{

    @Test
    fun `plzRun`(){
        mockMvc.perform(MockMvcRequestBuilders.get("/github/kyu9/library/commits"))
            .andExpect(MockMvcResultMatchers.status().`is`(200))
    }
}