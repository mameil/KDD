package me.kdshim.kdd_j.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        if(str.charAt(str.length()-2) == ')')

        log.info("LAST PARSE : {}", str);

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

        //가장 처음에 있는 {을 재치고 그 다음부터 { 을 찾고 만약에 그 전에 :으로 시작할 수 있게 처리하자
        int index = str.indexOf("{");
        List<Integer> list = new ArrayList<>();
        while (index >= 0) {
            index = str.indexOf("{", index + 1);
            if(index > -1){
                String substring = str.substring(index - 10, index + 10);
                System.out.println(str.substring(0, index) + "\"" + str.substring(index, str.length()));
            }
            list.add(index);
        }

        for (Integer idx : list) {
            if(idx != -1) {
                //여기 breakpoint
                int start = idx;
                while (str.charAt(idx - 1) != ':' && str.charAt(idx - 1) != '[') {
                    idx--;
                }
                //여기 breakpoint
                String substring = str.substring(0, idx);
                String substring1 = str.substring(start, str.length());
                System.out.println("==============================================");
                System.out.println(substring);
                System.out.println(substring.substring(substring.length() - 10, substring.length()));
                System.out.println("==============================================");
                System.out.println(substring1);
                System.out.println(substring1.substring(0, 10));
                System.out.println("==============================================");
                str = substring + substring1;
            }
        }

        log.info("parsed STR : {}", str);

        return mtr.toString();
    }


    public String wrapper(String str) {
        return "\"" + str + "\"";
    }

}
