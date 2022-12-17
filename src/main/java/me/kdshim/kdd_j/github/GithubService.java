package me.kdshim.kdd_j.github;

import lombok.RequiredArgsConstructor;
import lombok.val;
import me.kdshim.kdd_j.sender.GithubSender;
import me.kdshim.kdd_j.sender.dto.GetCommitDto;
import me.kdshim.kdd_j.sender.dto.GetRespDto;
import me.kdshim.kdd_j.swagger.model.GetSimpleCommitDto;
import me.kdshim.kdd_j.swagger.model.GetSimpleRepoInfoDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GithubService {

    private final GithubSender githubSender;

    public List<GetSimpleCommitDto> getCommitList(){

        List<GetCommitDto> commitList = githubSender.getCommitList();

        List<GetSimpleCommitDto> resultList = new ArrayList<>();

        commitList.forEach( it -> {
            GetSimpleCommitDto result = new GetSimpleCommitDto();
            result.setAuthor(it.getCommit().getAuthor().getName());
            result.setCommitMsg(it.getCommit().getMessage());
            result.setCommitYYYYMMDD(it.getCommit().getAuthor().getDate().substring(0, 10));
            resultList.add(result);
        });

        return resultList;
    }

    public List<GetSimpleCommitDto> getCommitListByAuthor(String author){

        List<GetCommitDto> commitList = githubSender.getCommitList();

        List<GetSimpleCommitDto> resultList = new ArrayList<>();

        commitList.forEach( it -> {
            GetSimpleCommitDto result = new GetSimpleCommitDto();
            result.setAuthor(it.getCommit().getAuthor().getName());
            result.setCommitMsg(it.getCommit().getMessage());
            result.setCommitYYYYMMDD(it.getCommit().getAuthor().getDate().substring(0, 10));
            resultList.add(result);
        });

        return resultList.stream().filter(it -> it.getAuthor().equals(author)).collect(Collectors.toList());
    }

    public GetSimpleRepoInfoDto getRepoInfo(){
         GetRespDto dto = githubSender.getRepo();

        GetSimpleRepoInfoDto fromDto = new GetSimpleRepoInfoDto();

        fromDto.setRepoUrl(dto.getHtml_url());
        fromDto.setRepoName(dto.getName());
        fromDto.setRepoDescription(dto.getDescription());
        fromDto.setRepoCreated(LocalDateTime.parse(dto.getCreated_at(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")));
        fromDto.setRepoUpdated(LocalDateTime.parse(dto.getUpdated_at(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")));

        return fromDto;
    }



}
