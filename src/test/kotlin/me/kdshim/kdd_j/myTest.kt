package me.kdshim.kdd_j

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class myTest (
    val mockMvc: MockMvc
        ){

    @Test
    fun assertionTest() {
        Assertions.assertEquals("qwer", "qwer")
    }

    @Test
    fun controllerTest(){
        mockMvc.perform(MockMvcRequestBuilders.get("/github/kyu9/library/commits"))
            .andExpect(MockMvcResultMatchers.status().`is`(400))
    }
}