package me.kdshim.kdd_j.MemberTest;

import lombok.SneakyThrows;
import me.kdshim.kdd_j.common.KDDError;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyMockMvc;
import me.kdshim.kdd_j.member.Member;
import me.kdshim.kdd_j.member.MemberRepository;
import me.kdshim.kdd_j.swagger.model.GetMemberDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class MemberTest extends MyMockMvc {

    @Autowired
    MemberRepository memberRepository;


    @SneakyThrows
    @KDTest
    @DisplayName("멤버 등록 테스트")
    public void MemberPostTest(){


        String plainString =
                mvc.perform(MockMvcRequestBuilders.post("/member/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"loginId\": \"kdshim\",\n" +
                                "  \"password\": \"rbeh!234\",\n" +
                                "  \"role\": \"ADMIN\",\n" +
                                "  \"name\": \"심규도\",\n" +
                                "  \"birthDateYYYYMMDD\": \"19970329\",\n" +
                                "  \"married\": false,\n" +
                                "  \"email\": \"kyudo97@naver.com\",\n" +
                                "  \"oldAddr\": \"경기도 고양시 일산서구 강선길 42\",\n" +
                                "  \"addr\": \"경기도 고양시 일산서구 강선로 30\",\n" +
                                "  \"addrDetail\": \"1501동\",\n" +
                                "  \"zipCode\": \"10365\"\n" +
                                "}")
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.loginId").value("kdshim"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("rbeh!234"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value(GetMemberDto.RoleEnum.ADMIN.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.birthDateYYYYMMDD").value("19970329"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.married").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("kyudo97@naver.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.oldAddr").value("경기도 고양시 일산서구 강선길 42"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.addr").value("경기도 고양시 일산서구 강선로 30"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.addrDetail").value("1501동"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.zipCode").value("10365"))
                        .andReturn().getResponse().getContentAsString()
                ;

        Member testM = getObjectMapper().readValue(plainString, Member.class);
        Member dbM = memberRepository.findById("kdshim").get();

        Assertions.assertEquals(testM.getLoginId(), dbM.getLoginId());
    }

    @KDTest
    public void memberFindTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/member/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"loginId\": \"kdshim\",\n" +
                                "  \"password\": \"rbeh!234\",\n" +
                                "  \"role\": \"ADMIN\",\n" +
                                "  \"name\": \"심규도\",\n" +
                                "  \"birthDateYYYYMMDD\": \"19970329\",\n" +
                                "  \"married\": false,\n" +
                                "  \"email\": \"kyudo97@naver.com\",\n" +
                                "  \"oldAddr\": \"경기도 고양시 일산서구 강선길 42\",\n" +
                                "  \"addr\": \"경기도 고양시 일산서구 강선로 30\",\n" +
                                "  \"addrDetail\": \"1501동\",\n" +
                                "  \"zipCode\": \"10365\"\n" +
                                "}")
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.loginId").value("kdshim"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("rbeh!234"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value(GetMemberDto.RoleEnum.ADMIN.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.birthDateYYYYMMDD").value("19970329"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.married").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("kyudo97@naver.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.oldAddr").value("경기도 고양시 일산서구 강선길 42"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.addr").value("경기도 고양시 일산서구 강선로 30"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.addrDetail").value("1501동"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.zipCode").value("10365"))
        ;

        mvc.perform(MockMvcRequestBuilders.post("/login/find/member")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"userName\": \"심규도\",\n" +
                        "  \"birthDateYYYYMMDD\": \"19970329\"\n" +
                        "}")
        )
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.loginId").value("kdshim"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("rbeh!234"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value(GetMemberDto.RoleEnum.ADMIN.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.birthDateYYYYMMDD").value("19970329"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.married").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("kyudo97@naver.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address.oldAddr").value("경기도 고양시 일산서구 강선길 42"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address.addr").value("경기도 고양시 일산서구 강선로 30"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address.addrDetail").value("1501동"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address.zipCode").value("10365"))
        ;

        mvc.perform(MockMvcRequestBuilders.post("/login/find/member")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"userName\": \"실패테스트\",\n" +
                                "  \"birthDateYYYYMMDD\": \"19970329\"\n" +
                                "}")
                )
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(KDDError.MEMBER_NOT_FOUND.getCode()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(KDDError.MEMBER_NOT_FOUND.getMsg()))
        ;
    }
}
