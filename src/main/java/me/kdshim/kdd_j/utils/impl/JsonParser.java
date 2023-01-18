package me.kdshim.kdd_j.utils.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class JsonParser {
    public String toJson(String str) {
        // =null 제거, super=객체() 제거, 객체{} 제거
        log.info("recv : {}", str);
        str = emptyKeyRemover(str);
        str = superRemover(str);
        str = jsonReplacer(str);
        str = objNameRemover(str);

        return str;
    }


    public String jsonReplacer(String str) {
        //기본적인 파싱 작업
        //Request processing failed; nested exception is java.util.regex.PatternSyntaxException: Unclosed group near index 1
        //(이 안들어가서 String.valueOf(char) 이렇게 해버렸더니 나오는 에러 > (, ) 이건 \\ 2개로 넣어주어야 된다
        str = str.replaceAll(",\\)", ")");
        str = str.replaceAll("\\(", "{\"");
        str = str.replaceAll("=", "\":\"");
        str = str.replaceAll(", ", "\", \"");
        str = str.replaceAll("\\)", "}");
        str = str.replaceAll("}", "\"}");
        str = str.replaceAll(", \"\"}", "}");

        //,을 기준으로 "을 넣어서 맨 마지막은 따로 넣어주어야함
//        str = str.substring(0, str.length()-1) + "\"}";

        //true false 은 boolean 값으로 변환
        str = str.replaceAll("\"false\"", "false");
        str = str.replaceAll("\"true\"", "true");

        log.info("result of jsonReplacer : {}", str);
        return str;
    }


    public String emptyKeyRemover(String str) {
        //=null 인 key=value, << 이거 제거
        while (str.contains("=null")) {
            int valStart = str.indexOf("=null");
            int valEnd = valStart + "=null".length();
            char c = str.charAt(valEnd);

            int index = valStart;
            boolean nullStart = false;
            while (str.charAt(index) != ',' && str.charAt(index) != '(') {
                if (str.charAt(index) == '(') {
                    nullStart = true;
                }
                index--;
            }

            int keyIdx = nullStart ? index : index + 1;
            //정확하게 key=null 까지는 찾음 >> 제거할 때
            //=null다음이 , 인지 확인해서 ,이면 제거필요

            String substring = str.substring(0, keyIdx + 1);

            while (str.charAt(valEnd) == ',' || str.charAt(valEnd) == ' ') {
                valEnd++;
            }
            String substring1 = str.substring(valEnd, str.length());
            str = substring + substring1;


        }

        log.info("result of emptyKeyRemover : {}", str);
        return str;
    }


    public String superRemover(String str) {
        while (str.contains("super=")) {
            int superStartIdx = str.indexOf("super=");
            int superStartObjIdx = superStartIdx;
            while (str.charAt(superStartObjIdx) != '(') {
                superStartObjIdx++;
            }

            str = str.substring(0, superStartIdx) + str.substring(++superStartObjIdx, str.length());

            int superEndIdx = superStartObjIdx;
            while (str.indexOf("),") != superEndIdx) {
                superEndIdx++;
            }

            str = str.substring(0, superEndIdx) + str.substring(superEndIdx + 3, str.length());
        }

        log.info("result of superRemover : {}", str);
        return str;
    }


    public String objNameRemover(String str) {
        str = str.substring(str.indexOf("{"), str.length());

        log.info("result of objNameRemover : {}", str);
        return str;
    }
}