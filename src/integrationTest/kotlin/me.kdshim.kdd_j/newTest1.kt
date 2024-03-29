package me.kdshim.kdd_j

import me.kdshim.kdd_j.KddJApplication
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest(classes = [KddJApplication::class])
@AutoConfigureMockMvc
class newTest1 @Autowired constructor(
    val mockMvc: MockMvc
)
{

    @Test
    fun `plzRun`(){
        mockMvc.perform(MockMvcRequestBuilders.get("/github/kyu9/library/commits"))
            .andExpect(MockMvcResultMatchers.status().`is`(200))
    }
}