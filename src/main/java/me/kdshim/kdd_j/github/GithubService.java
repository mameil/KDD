package me.kdshim.kdd_j.github;

import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.sender.GithubSender;
import me.kdshim.kdd_j.sender.dto.GetCommitDto;
import me.kdshim.kdd_j.swagger.model.GetSimpleCommitDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

}
