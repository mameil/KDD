package me.kdshim.kdd_j.member.impl;

import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.member.Member;
import me.kdshim.kdd_j.member.MemberRepository;
import me.kdshim.kdd_j.swagger.api.MemberApiDelegate;
import me.kdshim.kdd_j.swagger.model.GetMemberDto;
import me.kdshim.kdd_j.swagger.model.PostMemberDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberApiControllerImpl implements MemberApiDelegate {
    private final MemberRepository memberRepository;

    @Override
    public ResponseEntity<GetMemberDto> postMember(PostMemberDto body) {
        Member member = Member.fromDto(body);
        memberRepository.save(member);
        return ResponseEntity.ok(Member.toDto(member));
    }
}
