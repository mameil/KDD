package me.kdshim.kdd_j.utils;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilsService2 {

    public String toStringToJSON(String str) {
        System.out.println("==============================================");
        System.out.println(str);
        System.out.println("==============================================");

        /*
        CrsTransaction(expAmount=null, expTrAmount=null,
        expPointAmount=0, expTrIncenAmount=null, posEntryMode=null)
         */


        /*
        Order(id=OD20190101000011, seq=101, agencyOrderId=null, agencyOrderLastStatus=null, aliasId=null,
        merchantId=MC0001, placeId=DMC0001, kaId=테스트KA, aspId=테스트ASP, userId=1234, orderer=Orderer(id=1,
        userId=1234, zipCode=12345, addr=서울 턱별시, addrDetail=익스콘벤처타워, oldAddr=null, oldAddrDetail=null,
        old=false, latitude=37.470689, longitude=126.651839, lawAdmName=망원동1, hangAdmName=null, lawAdmCode=null,
        hangAdmCode=null, mobileNumber=05055555555, plainMobileNumber=12341234, par=par1234, incomingKaId=테스트KA),
         smsNumberList=null, orderDateTime=1672128580356, orderDateYyyymm=202212, orderDateYyyymmdd=20221227,
         updateDateTime=1672128580356, statusDetails=WAIT, status=WAIT, menuHistoryList=[MenuHistory(super=AbstractBaseEntity
         (created=19990101000000, updated=19990101000000), id=MH0001, version=1, menuId=MN0001, name=name, groupName=groupName,
          menuHistorySubItemList=[MenuHistorySubItem(menuSubItemId=MSI0001, name=피자, price=1500, count=2, priority=0)],
          menuHistoryOptionList=[MenuHistoryOption(id=MHO0001, menuOptionId=MO0001, name=토핑, optionType=NORMAL,
          menuHistoryOptionItemList=[MenuHistoryOptionItem(menuOptionItemId=MOI0001, name=치즈토핑, price=300, count=3,
          optionType=NORMAL, priority=1)], priority=1)], count=2, totalPrice=7800, price=3900, order=null, ecoFriendly=false,
           priority=0), MenuHistory(super=AbstractBaseEntity(created=19990101000000, updated=19990101000000), id=MH0002,
           version=1, menuId=MN0001, name=name, groupName=groupName, menuHistorySubItemList=[MenuHistorySubItem(menuSubItemId=MSI0001,
            name=피자, price=1500, count=2, priority=0)], menuHistoryOptionList=[MenuHistoryOption(id=MHO0002, menuOptionId=MO0001,
            name=토핑, optionType=NORMAL, menuHistoryOptionItemList=[MenuHistoryOptionItem(menuOptionItemId=MOI0001, name=치즈토핑,
             price=300, count=3, optionType=NORMAL, priority=1)], priority=1)], count=2, totalPrice=7800, price=3900, order=null,
             ecoFriendly=false, priority=0)], payment=Payment(nrNumber=KMN191107007692926, aspId=테스트ASP, orderId=OD20190101000011, u
             serId=1234, merchantId=MC0001, processingCode=000000, type=REQUEST_WALLET, menuAmount=19000, orgAmount=20000, trAmount=20000,
              tipAmount=1000, tipGradeAmount=0, tipExtraDongAmount=0, tipExtraHourAmount=0, ecoDepositAmount=0, discountAmount=500,
              discountAmountPickup=0, de90=010000011111070501160000020001200000000000, approvalDateTime=2022-12-27T17:09:40.485,
              reasonCode=00, usedUserPoint=0, approvalCode=null, token=9461440000348459, placeId=DMC0001, placeName=테스트가맹점,
               yyyymmdd=20221227), memo=memo, memoRider=null, cancel=Cancel(cancelType=null, cancelBurden=null, cancelMemo=null),
               estTime=null, delivery=Delivery(super=DeliveryCore(type=MANUAL, status=NONE, oldStatus=NONE, pickupRequestedAt=0,
               pickupExpectedAt=0, distance=0, updated=null, updatedYYYYMMDD=null, agency=NONE, rider=Rider(phone=null, name=null,
               hubPhone=null)), cancelMemo=null, cancelType=null, cancelBurden=null), printName=name 외 1개, placeName=테스트가맹점,
               orgNrNumber=KMN191107007692926, orgApprovalDate=2022-12-27T17:09:40.485, orgApprovalDateYYYYMMDD=20221227,
               deliveryAt=DeliveryAt(registeredAt=null, allocatedAt=null, allocationChangedAt=null, pickupFinishedAt=null,
               dropFinishedAt=null, canceledAt=null), type=DELIVERY, totalAmount=20000, place=null, expectedAutoCancelAt=20221227171440,
               expectedEstimatedAt=null, deliveryDone=false, incomingCategoryId=null, shortId=00011, reviewStatus=WAIT,
               recommanderCode=null, isAuto=false, ecoFriendly=false)
        * */

        int parseCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                parseCnt++;
            }
        }
        System.out.println("run json parsing count : " + parseCnt);


        StringBuilder sb = makeJSON(str);


        return sb.toString();
    }


    public String wrapper(String str) {
        return "\"" + str + "\"";
    }


    public String wrappingStr(String str) {
        String parsed = "";
        String innerObj = "";
        String innerAble = "NONE";


        if (str.contains(")")) {
            str = str.substring(0, str.length() - 1);
            innerAble = "END";
        } else if (str.contains("(")) {
//            CrsReward(aspId


            if (str.contains("[") || str.contains("]")) {
                //=이 2개 이상이여서 리스트로 넘어오는 경우에는 ], [ 이거 삭제필요
                str = str.substring(1, str.length() - 1);
                String[] list = str.split(", ");


                if (list[1].startsWith("[")) {
                    return wrapper(list[0]);
                }


                innerObj = "\"" + list[1].substring(0, list[1].indexOf("(")) + "\"";
                innerObj = innerObj.replace(String.valueOf(innerObj.charAt(1)), String.valueOf(innerObj.charAt(1)).toLowerCase());
                String key = wrapper(list[1].substring(list[1].indexOf("(") + 1, list[1].length()));
                String value = list[2];
                return innerObj + ": " + "{" + key;


            } else {
                innerObj = wrapper(str.substring(0, str.indexOf("("))) + " : ";
                str = str.substring(str.indexOf("(") + 1, str.length());
            }


            if (!str.startsWith("super")) {
                innerAble = "START";
            }


        }


        parsed = parsed + "\"" + str + "\"";
        switch (innerAble) {
            case "END":
                parsed = parsed + "}";
                break;
            case "START":
                parsed = "{" + parsed;
                break;
        }


        return innerObj + parsed;
    }


    public StringBuilder makeJSON(String str) {
        int startIdx = str.indexOf('(');
        int endIdx = str.lastIndexOf(')');
        str = str.substring(startIdx + 1, endIdx);
        //remove OBJ Name


        StringBuilder sb = new StringBuilder();


        sb.append("{");
        String[] kv = str.split(", ");
        for (int i = 0; i < kv.length; i++) {
            String[] kv2 = kv[i].split("=");
            ArrayList<String> list = new ArrayList<>(Arrays.asList(kv2));


            if (!list.get(list.size() - 1).contains("null")) {
                //key part + : part
                if (kv2.length > 2) {
//                    list.remove(0);
                    sb.append(wrappingStr(Arrays.toString(list.toArray())));
                } else {
                    sb.append(wrappingStr(kv2[0]));
                }
                sb.append(": ");


                if (!kv2[kv2.length - 1].toLowerCase().contains(kv2[kv2.length - 2].toLowerCase())) {
                    //value part
                    if (kv2[kv2.length - 1].equals("true") || kv2[kv2.length - 1].equals("false")) {
                        sb.append(kv2[kv2.length - 1]);
                    } else {
                        sb.append(wrappingStr(kv2[kv2.length - 1]));
                    }


                    //no need , for last index
                    if (i != kv.length - 1) {
                        sb.append(", ");
                    }
                }


            }


        }
        if (sb.toString().endsWith(", ")) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("}");


        return sb;
    }
}
