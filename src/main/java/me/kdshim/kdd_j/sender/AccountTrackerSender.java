package me.kdshim.kdd_j.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.kdshim.kdd_j.sender.dto.GetCommitDto;
import me.kdshim.kdd_j.sender.dto.GetRespDto;
import me.kdshim.kdd_j.sender.dto.PostTransaction;
import me.kdshim.kdd_j.swagger.model.PostTranRequestDto;
import me.kdshim.kdd_j.swagger.model.PostTransResponseDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class AccountTrackerSender {
    @Qualifier("kdRestTemplate")
    private final RestTemplate restTemplate;

    public PostTransResponseDto getCommitList(PostTransaction tran){
        PostTransResponseDto response = restTemplate.postForObject("localhost:10001/transaction", tran, PostTransResponseDto.class);

        return response;
    }

}
