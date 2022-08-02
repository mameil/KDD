package me.kdshim.kdd_j.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.kdshim.kdd_j.sender.dto.getCommitAuthorDto;
import me.kdshim.kdd_j.sender.dto.getCommitDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class GithubSender {
    private final RestTemplate restTemplate;


    public List<getCommitDto> getCommitList(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github+json");
        headers.set("Authorization", "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");
        HttpEntity req = new HttpEntity(headers);

        ResponseEntity<List<getCommitDto>> response = restTemplate.exchange("https://api.github.com/repos/kyu9/mylibrary/commits", HttpMethod.GET, req, new ParameterizedTypeReference<List<getCommitDto>>() {
        });
        System.out.println("==============================================");
        System.out.println(response.getBody().toString());
        System.out.println("==============================================");

        return response.getBody();
    }
}
