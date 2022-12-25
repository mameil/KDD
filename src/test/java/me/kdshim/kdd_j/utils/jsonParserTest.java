package me.kdshim.kdd_j.utils;

import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.ContentType;
import lombok.SneakyThrows;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyMockMvc;
import me.kdshim.kdd_j.link.entity.CATEGORY;
import me.kdshim.kdd_j.link.entity.Link;
import me.kdshim.kdd_j.member.Member;
import me.kdshim.kdd_j.member.ROLE;
import me.kdshim.kdd_j.swagger.model.StringDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertEquals;

public class jsonParserTest extends MyMockMvc {

    @KDTest
    @SneakyThrows
    public void jsonParser(){
        ObjectMapper mapper = new ObjectMapper();

        String lomboks2 = "CrsTransaction(super=CrsReward(aspId=000137000000000, userId=50000543364, serviceId=000137000257000, rewardDetailTargetId=null, tid=null, hostName=null, failReason=null, status=SUCCESS, rewardCount=1, rewardType=null, p1=null, ms=null, realRewardId=null, yyyymmdd=null), par=Q121B5D2FBFFBD139A5768C573E, acquireType=null, processingCode=211900, mti=0100, merchantId=410226436448501, merchantType=MC, merchantBizNo=null, amount=50000, orgAmount=50000, originOrgAmount=null, orgAmountCancelYn=null, nrNumber=KMN221223031792766, orgNrNumber=null, trIncenAmount=null, acquirerMerchantType=null, trPoint=0, acquirerId=null, adminSend=null, approvalDatetime=null, reversalStatus=null, trPointExp=0, sendPush=Y, merchantName=null, acquirerMerchantName=null, pointList=null, expAmount=null, expTrAmount=null, expPointAmount=0, expTrIncenAmount=null, posEntryMode=null)";
        String lomboks3= "Link(url=localhost, category=JAVA, name=test link, memo=this is test only link)";

        StringDto req2 = new StringDto();
        req2.setPlainString(lomboks2);

        StringDto req3 = new StringDto();
        req3.setPlainString(lomboks3);

        //json step1 fin
        String madeJson = mvc.perform(MockMvcRequestBuilders.post("/utils/jsonify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(req3))
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString()
                ;

        Link link = getObjectMapper().readValue(madeJson, Link.class);
        assertEquals(link.getUrl(), "localhost");
        assertEquals(link.getCategory(), CATEGORY.JAVA);
        assertEquals(link.getName(), "test link");
        assertEquals(link.getMemo(), "this is test only link");

        String lomboks = "Member(loginId=kdshim, password=rbeh!234, role=ADMIN, name=shimkyudo, birthDateYYYYMMDD=19970329, married=false, email=kyudo97@naver.com, address=Address(oldAddr=qqqq, addr=wwww, addrDetail=eeee, zipCode=10365))";
        String tobe = "{\n" +
                "  \"loginId\": \"kdshim\",\n" +
                "  \"password\": \"rbeh!234\",\n" +
                "  \"role\": \"ADMIN\",\n" +
                "  \"name\": \"심규도\",\n" +
                "  \"birthDateYYYYMMDD\": \"19970329\",\n" +
                "  \"married\": false,\n" +
                "  \"email\": \"kyudo97@naver.com\",\n" +
                "  \"address\": {\n" +
                "    \"oldAddr\": \"경기도 고양시 일산서구 강선길 42\",\n" +
                "    \"addr\": \"경기도 고양시 일산서구 강선로 30\",\n" +
                "    \"addrDetail\": \"1501동\",\n" +
                "    \"zipCode\": \"10365\"\n" +
                "  },\n" +
                "  \"updated\": {\n" +
                "    \"date\": {\n" +
                "      \"year\": 2022,\n" +
                "      \"month\": 12,\n" +
                "      \"day\": 25\n" +
                "    },\n" +
                "    \"time\": {\n" +
                "      \"hour\": 19,\n" +
                "      \"minute\": 8,\n" +
                "      \"second\": 42,\n" +
                "      \"nano\": 0\n" +
                "    }\n" +
                "  }\n" +
                "}";
        StringDto req = new StringDto();
        req.setPlainString(lomboks);


        String madeJson2 = mvc.perform(MockMvcRequestBuilders.post("/utils/jsonify")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(req))
        )
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString()
                ;

        Member member = getObjectMapper().readValue(madeJson2, Member.class);
        assertEquals(member.getLoginId(), "kdshim");
        assertEquals(member.getPassword(), "rbeh!234");
        assertEquals(member.getRole(), ROLE.ADMIN);
        assertEquals(member.getName(), "shimkyudo");
        assertEquals(member.getBirthDateYYYYMMDD(), "19970329");
        assertEquals(member.isMarried(), false);
        assertEquals(member.getEmail(), "kyudo97@naver.com");
        assertEquals(member.getAddress().getAddr(), "wwww");
        assertEquals(member.getAddress().getOldAddr(), "qqqq");
        assertEquals(member.getAddress().getAddrDetail(), "eeee");
        assertEquals(member.getAddress().getZipCode(), "10365");
    }

}
