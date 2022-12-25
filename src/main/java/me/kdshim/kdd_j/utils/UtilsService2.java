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

    public String wrappingStr(String str) {
        String parsed = "";
        String innerObj = "";
        String isInnerObj = "NONE";

        if (str.contains(")")) {
            str = str.substring(0, str.length() - 1);
            isInnerObj = "END";
        } else if (str.contains("(")) {
            //], [ 이거 삭제
            str = str.substring(1, str.length()-1);
            innerObj = "\"" + str.substring(0, str.indexOf(",")) + "\" : ";

            str = str.substring(str.indexOf("(")+1, str.length());
            isInnerObj = "START";
        }

        parsed = parsed + "\"" + str + "\"";
        switch (isInnerObj) {
            case "END":
                parsed = parsed + "}"; break;
            case "START":
                parsed = "{" + parsed; break;
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

            //key part + : part
            if(kv2.length > 2){
                ArrayList<String> list = new ArrayList<>(Arrays.asList(kv2));
                list.remove(list.size()-1);

                sb.append(wrappingStr(Arrays.toString(list.toArray())));
            }else{
                sb.append(wrappingStr(kv2[0]));
            }
            sb.append(": ");

            //value part
            if (kv2[kv2.length-1].equals("true") || kv2[kv2.length-1].equals("false")) {
                sb.append(kv2[kv2.length-1]);
            } else {
                sb.append(wrappingStr(kv2[kv2.length-1]));
            }

            //no need , for last index
            if (i != kv.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");

        return sb;
    }
}
