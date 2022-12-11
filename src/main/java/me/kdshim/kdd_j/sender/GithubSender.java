package me.kdshim.kdd_j.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.kdshim.kdd_j.sender.dto.GetCommitDto;
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
public class GithubSender {
    private final RestTemplate restTemplate;

    @Value("${github.headers.accept}")
    private String accept;

    @Value("${github.headers.authorization}")
    private String authorization;

    @Value("${github.base}")
    private String githubBase;

    @Value("${github.library.getCommits}")
    private String libraryCommitsUrl;

    public List<GetCommitDto> getCommitList(){
        //todo 페이지네이션 갯수에 대한 고민 필요 > https://docs.github.com/en/rest/commits/commits 에서 확인 필요함
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", accept);
        headers.set("Authorization", authorization);
        HttpEntity req = new HttpEntity(headers);

        //Default Page count : 30
        ResponseEntity<List<GetCommitDto>> response = restTemplate.exchange
                (githubBase + libraryCommitsUrl, HttpMethod.GET, req, new ParameterizedTypeReference<List<GetCommitDto>>() {
        });
//        System.out.println("==============================================");
//        System.out.println(response.getBody().toString());
//        System.out.println("==============================================");

        return response.getBody();
    }
}
