//package me.kdshim.kdd_j.link;
//
//import me.kdshim.kdd_j.link.impl.LinkApiControllerImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = LinkApiControllerImpl.class)
//public class LinkTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    public void checkTest() throws Exception{
//        mvc.perform(MockMvcRequestBuilders.get("/links"))
//                .andExpect(MockMvcResultMatchers.status().is(200));
//    }
//
//    @Test
//    public void checkThis(){
//        Assertions.assertEquals(1, 1);
//    }
//}
