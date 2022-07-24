package me.kdshim.kdd_j.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.kdshim.kdd_j.config.CoreException;
import me.kdshim.kdd_j.config.KDDError;
import me.kdshim.kdd_j.view.dto.LoginDto;
import me.kdshim.kdd_j.view.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ResponseDto userRegistration(Member recv){
        log.info(recv.toString());
        memberRepository.findAll().forEach(member -> {
            if(member.getLoginId().equals(recv.getLoginId()))
                KDDError.LOGIN_ID_EXISTS.getThrow();
        });

        memberRepository.save(recv);

        return ResponseDto.builder().statusCode(200).reason("Success").build();
    }

}
