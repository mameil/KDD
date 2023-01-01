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
    public void jsonParser() {
        ObjectMapper mapper = new ObjectMapper();

        String lomboks2 = "CrsTransaction(super=CrsReward(aspId=000137000000000, userId=50000543364, serviceId=000137000257000, rewardDetailTargetId=null, tid=null, hostName=null, failReason=null, status=SUCCESS, rewardCount=1, rewardType=null, p1=null, ms=null, realRewardId=null, yyyymmdd=null), par=Q121B5D2FBFFBD139A5768C573E, acquireType=null, processingCode=211900, mti=0100, merchantId=410226436448501, merchantType=MC, merchantBizNo=null, amount=50000, orgAmount=50000, originOrgAmount=null, orgAmountCancelYn=null, nrNumber=KMN221223031792766, orgNrNumber=null, trIncenAmount=null, acquirerMerchantType=null, trPoint=0, acquirerId=null, adminSend=null, approvalDatetime=null, reversalStatus=null, trPointExp=0, sendPush=Y, merchantName=null, acquirerMerchantName=null, pointList=null, expAmount=null, expTrAmount=null, expPointAmount=0, expTrIncenAmount=null, posEntryMode=null)";
        String lomboks3 = "Link(url=localhost, category=JAVA, name=test link, memo=this is test only link)";

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
                .andReturn().getResponse().getContentAsString();

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
                .andReturn().getResponse().getContentAsString();

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

    @KDTest
    public void test2() throws Exception {
//        String crsTransaction = "CrsTransaction(super=CrsReward(aspId=000137000000000, userId=50000543364, serviceId=000137000257000, rewardDetailTargetId=null, tid=null, hostName=null, failReason=null, status=SUCCESS, rewardCount=1, rewardType=null, p1=null, ms=null, realRewardId=null, yyyymmdd=null), par=Q121B5D2FBFFBD139A5768C573E, acquireType=null, processingCode=211900, mti=0100, merchantId=410226436448501, merchantType=MC, merchantBizNo=null, amount=50000, orgAmount=50000, originOrgAmount=null, orgAmountCancelYn=null, nrNumber=KMN221223031792766, orgNrNumber=null, trIncenAmount=null, acquirerMerchantType=null, trPoint=0, acquirerId=null, adminSend=null, approvalDatetime=null, reversalStatus=null, trPointExp=0, sendPush=Y, merchantName=null, acquirerMerchantName=null, pointList=null, expAmount=null, expTrAmount=null, expPointAmount=0, expTrIncenAmount=null, posEntryMode=null)";
        String crsTransaction = "CrsTransaction(expAmount=null, expTrAmount=null, expPointAmount=0, expTrIncenAmount=null, posEntryMode=null)";
        StringDto req1 = new StringDto();
        req1.setPlainString(crsTransaction);


        String ct = mvc.perform(MockMvcRequestBuilders.post("/utils/jsonify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getObjectMapper().writeValueAsString(req1))
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn().getResponse().getContentAsString();


        String order = "Order(id=OD20190101000011, seq=101, agencyOrderId=null, agencyOrderLastStatus=null, aliasId=null, merchantId=MC0001, placeId=DMC0001, kaId=테스트KA, aspId=테스트ASP, userId=1234, orderer=Orderer(id=1, userId=1234, zipCode=12345, addr=서울 턱별시, addrDetail=익스콘벤처타워, oldAddr=null, oldAddrDetail=null, old=false, latitude=37.470689, longitude=126.651839, lawAdmName=망원동1, hangAdmName=null, lawAdmCode=null, hangAdmCode=null, mobileNumber=05055555555, plainMobileNumber=12341234, par=par1234, incomingKaId=테스트KA), smsNumberList=null, orderDateTime=1672105357810, orderDateYyyymm=202212, orderDateYyyymmdd=20221227, updateDateTime=1672105357810, statusDetails=WAIT, status=WAIT, menuHistoryList=[MenuHistory(super=com.kona.konacard.lop.menu.model.MenuHistory@21317f2, id=MH0001, version=1, menuId=MN0001, name=name, groupName=groupName, menuHistorySubItemList=[MenuHistorySubItem(menuSubItemId=MSI0001, name=피자, price=1500, count=2, priority=0)], menuHistoryOptionList=[MenuHistoryOption(id=MHO0001, menuOptionId=MO0001, name=토핑, optionType=NORMAL, menuHistoryOptionItemList=[MenuHistoryOptionItem(menuOptionItemId=MOI0001, name=치즈토핑, price=300, count=3, optionType=NORMAL, priority=1)], priority=1)], count=2, totalPrice=7800, price=3900, order=null, ecoFriendly=false, priority=0), MenuHistory(super=com.kona.konacard.lop.menu.model.MenuHistory@e95a167a, id=MH0002, version=1, menuId=MN0001, name=name, groupName=groupName, menuHistorySubItemList=[MenuHistorySubItem(menuSubItemId=MSI0001, name=피자, price=1500, count=2, priority=0)], menuHistoryOptionList=[MenuHistoryOption(id=MHO0002, menuOptionId=MO0001, name=토핑, optionType=NORMAL, menuHistoryOptionItemList=[MenuHistoryOptionItem(menuOptionItemId=MOI0001, name=치즈토핑, price=300, count=3, optionType=NORMAL, priority=1)], priority=1)], count=2, totalPrice=7800, price=3900, order=null, ecoFriendly=false, priority=0)], payment=Payment(nrNumber=KMN191107007692926, aspId=테스트ASP, orderId=OD20190101000011, userId=1234, merchantId=MC0001, processingCode=000000, type=REQUEST_WALLET, menuAmount=19000, orgAmount=20000, trAmount=20000, tipAmount=1000, tipGradeAmount=0, tipExtraDongAmount=0, tipExtraHourAmount=0, ecoDepositAmount=0, discountAmount=500, discountAmountPickup=0, de90=010000011111070501160000020001200000000000, approvalDateTime=2022-12-27T10:42:37.955, reasonCode=00, usedUserPoint=0, approvalCode=null, token=9461440000348459, placeId=DMC0001, placeName=테스트가맹점, yyyymmdd=20221227), memo=memo, memoRider=null, cancel=Cancel(cancelType=null, cancelBurden=null, cancelMemo=null), estTime=null, delivery=Delivery(super=DeliveryCore(type=MANUAL, status=NONE, oldStatus=NONE, pickupRequestedAt=0, pickupExpectedAt=0, distance=0, updated=null, updatedYYYYMMDD=null, agency=NONE, rider=Rider(phone=null, name=null, hubPhone=null)), cancelMemo=null, cancelType=null, cancelBurden=null), printName=name 외 1개, placeName=테스트가맹점, orgNrNumber=KMN191107007692926, orgApprovalDate=2022-12-27T10:42:37.955, orgApprovalDateYYYYMMDD=20221227, deliveryAt=DeliveryAt(registeredAt=null, allocatedAt=null, allocationChangedAt=null, pickupFinishedAt=null, dropFinishedAt=null, canceledAt=null), type=DELIVERY, totalAmount=20000, place=null, expectedAutoCancelAt=20221227104737, expectedEstimatedAt=null, deliveryDone=false, incomingCategoryId=null, shortId=00011, reviewStatus=WAIT, recommanderCode=null, isAuto=false, ecoFriendly=false)";
        StringDto req2 = new StringDto();
        req2.setPlainString(order);
        String or = mvc.perform(MockMvcRequestBuilders.post("/utils/jsonify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getObjectMapper().writeValueAsString(req2))
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn().getResponse().getContentAsString();

        /*
        Order(id=OD20190101000011, seq=101, agencyOrderId=null, agencyOrderLastStatus=null, aliasId=null, merchantId=MC0001, placeId=DMC0001, kaId=테스트KA, aspId=테스트ASP, userId=1234, orderer=Orderer(id=1, userId=1234, zipCode=12345, addr=서울 턱별시, addrDetail=익스콘벤처타워, oldAddr=null, oldAddrDetail=null, old=false, latitude=37.470689, longitude=126.651839, lawAdmName=망원동1, hangAdmName=null, lawAdmCode=null, hangAdmCode=null, mobileNumber=05055555555, plainMobileNumber=12341234, par=par1234, incomingKaId=테스트KA), smsNumberList=null, orderDateTime=1672128580356, orderDateYyyymm=202212, orderDateYyyymmdd=20221227, updateDateTime=1672128580356, statusDetails=WAIT, status=WAIT, menuHistoryList=[MenuHistory(super=AbstractBaseEntity(created=19990101000000, updated=19990101000000), id=MH0001, version=1, menuId=MN0001, name=name, groupName=groupName, menuHistorySubItemList=[MenuHistorySubItem(menuSubItemId=MSI0001, name=피자, price=1500, count=2, priority=0)], menuHistoryOptionList=[MenuHistoryOption(id=MHO0001, menuOptionId=MO0001, name=토핑, optionType=NORMAL, menuHistoryOptionItemList=[MenuHistoryOptionItem(menuOptionItemId=MOI0001, name=치즈토핑, price=300, count=3, optionType=NORMAL, priority=1)], priority=1)], count=2, totalPrice=7800, price=3900, order=null, ecoFriendly=false, priority=0), MenuHistory(super=AbstractBaseEntity(created=19990101000000, updated=19990101000000), id=MH0002, version=1, menuId=MN0001, name=name, groupName=groupName, menuHistorySubItemList=[MenuHistorySubItem(menuSubItemId=MSI0001, name=피자, price=1500, count=2, priority=0)], menuHistoryOptionList=[MenuHistoryOption(id=MHO0002, menuOptionId=MO0001, name=토핑, optionType=NORMAL, menuHistoryOptionItemList=[MenuHistoryOptionItem(menuOptionItemId=MOI0001, name=치즈토핑, price=300, count=3, optionType=NORMAL, priority=1)], priority=1)], count=2, totalPrice=7800, price=3900, order=null, ecoFriendly=false, priority=0)], payment=Payment(nrNumber=KMN191107007692926, aspId=테스트ASP, orderId=OD20190101000011, userId=1234, merchantId=MC0001, processingCode=000000, type=REQUEST_WALLET, menuAmount=19000, orgAmount=20000, trAmount=20000, tipAmount=1000, tipGradeAmount=0, tipExtraDongAmount=0, tipExtraHourAmount=0, ecoDepositAmount=0, discountAmount=500, discountAmountPickup=0, de90=010000011111070501160000020001200000000000, approvalDateTime=2022-12-27T17:09:40.485, reasonCode=00, usedUserPoint=0, approvalCode=null, token=9461440000348459, placeId=DMC0001, placeName=테스트가맹점, yyyymmdd=20221227), memo=memo, memoRider=null, cancel=Cancel(cancelType=null, cancelBurden=null, cancelMemo=null), estTime=null, delivery=Delivery(super=DeliveryCore(type=MANUAL, status=NONE, oldStatus=NONE, pickupRequestedAt=0, pickupExpectedAt=0, distance=0, updated=null, updatedYYYYMMDD=null, agency=NONE, rider=Rider(phone=null, name=null, hubPhone=null)), cancelMemo=null, cancelType=null, cancelBurden=null), printName=name 외 1개, placeName=테스트가맹점, orgNrNumber=KMN191107007692926, orgApprovalDate=2022-12-27T17:09:40.485, orgApprovalDateYYYYMMDD=20221227, deliveryAt=DeliveryAt(registeredAt=null, allocatedAt=null, allocationChangedAt=null, pickupFinishedAt=null, dropFinishedAt=null, canceledAt=null), type=DELIVERY, totalAmount=20000, place=null, expectedAutoCancelAt=20221227171440, expectedEstimatedAt=null, deliveryDone=false, incomingCategoryId=null, shortId=00011, reviewStatus=WAIT, recommanderCode=null, isAuto=false, ecoFriendly=false)
        * */
    }

}
