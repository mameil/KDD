package me.kdshim.kdd_j.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtilsService {

    public String ToJson(String str){
        //todo 일단 가장 처음에 있는 ( 을 찾고 그걸 기준으로 그 전에 있는 클래스명은 분리필요, 찾았던 (은 { 으로 변경필요
        // 첫번째 ( 이후로는 ,을 기준으로 자르고, =을 기준으로 자른 다음,
        // "을 더하고 첫 번쨰 인자 더하고 " : 을 더하고

        StringBuilder sb = new StringBuilder();


        return sb.toString();
    }
}
