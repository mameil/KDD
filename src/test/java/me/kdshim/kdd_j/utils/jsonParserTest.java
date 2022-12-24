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
        String lomboks2 = "CrsTransaction(super=CrsReward(aspId=000137000000000, userId=50000543364, serviceId=000137000257000, rewardDetailTargetId=null, tid=null, hostName=null, failReason=null, status=SUCCESS, rewardCount=1, rewardType=null, p1=null, ms=null, realRewardId=null, yyyymmdd=null), par=Q121B5D2FBFFBD139A5768C573E, acquireType=null, processingCode=211900, mti=0100, merchantId=410226436448501, merchantType=MC, merchantBizNo=null, amount=50000, orgAmount=50000, originOrgAmount=null, orgAmountCancelYn=null, nrNumber=KMN221223031792766, orgNrNumber=null, trIncenAmount=null, acquirerMerchantType=null, trPoint=0, acquirerId=null, adminSend=null, approvalDatetime=null, reversalStatus=null, trPointExp=0, sendPush=Y, merchantName=null, acquirerMerchantName=null, pointList=null, expAmount=null, expTrAmount=null, expPointAmount=0, expTrIncenAmount=null, posEntryMode=null)";

        StringDto req = new StringDto();
        req.setPlainString(lomboks);

        StringDto req2 = new StringDto();
        req2.setPlainString(lomboks2);

        mvc.perform(MockMvcRequestBuilders.post("/utils/jsonify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(req))
//                        .content(mapper.writeValueAsString(req2))
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.StringDto").value(""))
                ;
    }

}
