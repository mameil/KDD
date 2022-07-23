package me.kdshim.kdd_j.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.kdshim.kdd_j.config.KDDError;
import me.kdshim.kdd_j.view.dto.LoginDto;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //TODO model mapper 적용 왜안되는걸까...
//    private final ModelMapper modelMapper;

    public LoginDto loginValidation(LoginDto dto) {
        log.info(dto.toString());

        Member member = memberRepository.findById(dto.getId()).orElseThrow(KDDError.MEMBER_NOT_FOUND::getThrow);

//        LoginDto resp = modelMapper.map(member, LoginDto.class);
        LoginDto resp = LoginDto.builder().id(member.getLoginId()).password(member.getPassword()).role(member.getRole()).success(false).build();
        log.info(resp);

        if (member.getPassword().equals(dto.getPassword())) {
            resp.setSuccess(true);
        } else {
            resp.setSuccess(false);
        }

        return resp;
    }

}
