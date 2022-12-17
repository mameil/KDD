package me.kdshim.kdd_j.github.Impl;

import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.github.GithubService;
import me.kdshim.kdd_j.sender.GithubSender;
import me.kdshim.kdd_j.sender.dto.GetCommitDto;
import me.kdshim.kdd_j.swagger.api.GithubApiDelegate;
import me.kdshim.kdd_j.swagger.model.GetSimpleCommitDto;
import me.kdshim.kdd_j.swagger.model.GetSimpleCommitsDto;
import me.kdshim.kdd_j.swagger.model.GetSimpleRepoInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GithubApiDelegateImpl implements GithubApiDelegate {
    private final GithubService githubService;


    @Override
    public ResponseEntity<GetSimpleCommitsDto> getKyuLibraryCommits() {
        GetSimpleCommitsDto dto = new GetSimpleCommitsDto();
        dto.setCommitList(githubService.getCommitList());

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<GetSimpleRepoInfoDto> getKyuLibraryRepoInfo() {
        return ResponseEntity.ok(githubService.getRepoInfo());
    }
}
