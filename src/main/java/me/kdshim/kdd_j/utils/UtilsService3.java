package me.kdshim.kdd_j.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@Log4j2
public class UtilsService3 {

    public String toStringToJSON(String str) {
        log.info("received STR : {}", str);

        StringBuilder mtr = new StringBuilder();
        mtr.append("{");

        // =null 요거 key랑 value 제거
        while(str.contains("=null")){
            int valStart = str.indexOf("=null");
            int valEnd = valStart + "=null".length();
            char c = str.charAt(valEnd);

            int index = valStart;
            boolean nullStart = false;
            while(str.charAt(index) != ',' && str.charAt(index) != '('){
                if(str.charAt(index) == '(') {
                    nullStart = true;
                }
                index--;
            }

            int keyIdx = nullStart ? index : index+1;
            String substring = str.substring(0, keyIdx);
            String substring1 = str.substring(valEnd+1, str.length());
            log.info("substring : {}", substring);
            log.info("substring1 : {}", substring1);

            str = substring + substring1;

        }

        //기본적인 파싱 작업
        //Request processing failed; nested exception is java.util.regex.PatternSyntaxException: Unclosed group near index 1
        //(이 안들어가서 String.valueOf(char) 이렇게 해버렸더니 나오는 에러 > (, ) 이건 \\ 2개로 넣어주어야 된다
        str = str.replaceAll("\\(", "{\"");
        str = str.replaceAll("=", "\":\"");
        str = str.replaceAll(", ", "\", \"");
        str = str.replaceAll("\\)", "}");

        //,을 기준으로 "을 넣어서 맨 마지막은 따로 넣어주어야함
//        str = str.substring(0, str.length()-1) + "\"}";

        //true false 은 boolean 값으로 변환
        str = str.replaceAll("\"false\"", "false");
        str = str.replaceAll("\"true\"", "true");

        //배열인 경우에는 [] 밖에 "" 제거해주어야함
        str = str.replaceAll("\"\\[", "[");
        str = str.replaceAll("\\]\"", "]");

        log.info("parsed STR : {}", str);

        return mtr.toString();
    }


    public String wrapper(String str) {
        return "\"" + str + "\"";
    }

}
