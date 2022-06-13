package me.kdshim.kdd_j.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

//@RunWith(SpringRunner.class)
//@ExtendWith(BaseExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MyMockMvc extends BaseSupport {
    @Autowired
    public MockMvc mvc;
}
