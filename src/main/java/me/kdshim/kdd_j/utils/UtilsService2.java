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



    public String wrapper(String str){
        return "\"" + str + "\"";
    }



    public String wrappingStr(String str) {
        String parsed     = "";
        String innerObj   = "";
        String innerAble = "NONE";



        if (str.contains(")")) {
            str        = str.substring(0, str.length() - 1);
            innerAble = "END";
        } else if (str.contains("(")) {
//            CrsReward(aspId



            if(str.contains("[") || str.contains("]")){
                //=이 2개 이상이여서 리스트로 넘어오는 경우에는 ], [ 이거 삭제필요
                str      = str.substring(1, str.length() - 1);
                String[] list = str.split(", ");



                if(list[1].startsWith("[")){
                    return wrapper(list[0]);
                }



                innerObj = "\"" + list[1].substring(0, list[1].indexOf("(")) + "\"";
                innerObj = innerObj.replace(String.valueOf(innerObj.charAt(1)), String.valueOf(innerObj.charAt(1)).toLowerCase());
                String key = wrapper(list[1].substring(list[1].indexOf("(")+1, list[1].length()));
                String value = list[2];
                return innerObj + ": " + "{" + key;



            }else{
                innerObj = wrapper(str.substring(0, str.indexOf("("))) + " : ";
                str        = str.substring(str.indexOf("(") + 1, str.length());
            }



            if(!str.startsWith("super")){
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
        int endIdx   = str.lastIndexOf(')');
        str = str.substring(startIdx + 1, endIdx);
        //remove OBJ Name



        StringBuilder sb = new StringBuilder();



        sb.append("{");
        String[] kv = str.split(", ");
        for (int i = 0; i < kv.length; i++) {
            String[]          kv2  = kv[i].split("=");
            ArrayList<String> list = new ArrayList<>(Arrays.asList(kv2));



            if (!list.get(list.size()-1).contains("null")) {
                //key part + : part
                if (kv2.length > 2) {
//                    list.remove(0);
                    sb.append(wrappingStr(Arrays.toString(list.toArray())));
                } else {
                    sb.append(wrappingStr(kv2[0]));
                }
                sb.append(": ");



                if(!kv2[kv2.length-1].toLowerCase().contains(kv2[kv2.length-2].toLowerCase())){
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
        if(sb.toString().endsWith(", ")){
            sb.delete(sb.length()-2, sb.length());
        }
        sb.append("}");



        return sb;
    }
}
