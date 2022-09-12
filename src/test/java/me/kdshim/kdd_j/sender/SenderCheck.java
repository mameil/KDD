package me.kdshim.kdd_j.sender;


import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyMockMvc;
import me.kdshim.kdd_j.sender.dto.GetCommitDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class SenderCheck extends MyMockMvc {
    @Autowired
    GithubSender githubSender;

    @KDTest
    public void getCommitsTest(){
        List<GetCommitDto> commitList = githubSender.getCommitList();
        List<String> msgs = commitList.stream().map(getCommitDto -> getCommitDto.getCommit().getMessage()).collect(Collectors.toList());
        System.out.println("==============================================");
        System.out.println(msgs.size());
        msgs.forEach(System.out::println);
        System.out.println("==============================================");

        List<String> kotlins = msgs.stream().filter(str -> str.contains("[Kotlin]")).collect(Collectors.toList());
        System.out.println("==============================================");
        System.out.println(kotlins.size());
        kotlins.forEach(System.out::println);
        System.out.println("==============================================");
    }
}
