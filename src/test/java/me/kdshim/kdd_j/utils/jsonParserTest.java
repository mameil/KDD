package me.kdshim.kdd_j.utils;

import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.ContentType;
import lombok.SneakyThrows;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyMockMvc;
import me.kdshim.kdd_j.swagger.model.StringDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

public class jsonParserTest extends MyMockMvc {

    @KDTest
    @SneakyThrows
    public void jsonParser(){
        ObjectMapper mapper = new ObjectMapper();

        String lomboks = "Member(loginId=kdshim, password=rbeh!234, role=ADMIN, name=심규도, birthDateYYYYMMDD=19970329, married=false, email=kyudo97@naver.com, address=Address(oldAddr=경기도 고양시 일산서구 강선길 42, addr=경기도 고양시 일산서구 강선로 30, addrDetail=1501동, zipCode=10365))";
        StringDto req = new StringDto();
        req.setPlainString(lomboks);

        mvc.perform(MockMvcRequestBuilders.post("/utils/jsonify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(req))
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.StringDto").value(""))
                ;
    }

}
