package me.kdshim.kdd_j.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.kdshim.kdd_j.common.KDDError;
import me.kdshim.kdd_j.view.dto.LoginDto;
import me.kdshim.kdd_j.view.dto.ResponseDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    //TODO model mapper 적용 왜안되는걸까...
//    private final ModelMapper modelMapper;

    public Member findFirstMemberByUsername(String userName){
        return memberRepository.findAllByName(userName).stream().findFirst().orElseThrow(KDDError.MEMBER_NOT_FOUND::doThrow);
    }

    public LoginDto loginValidation(LoginDto dto) {
        log.info(dto.toString());

        Member member = memberRepository.findById(dto.getId()).orElseThrow(KDDError.MEMBER_NOT_FOUND::doThrow);

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

    public UserDetails loadUserByUsername(String id, String password) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findById(id);
        LoginDto resp = null;
        if(member.isPresent()){
            if(member.get().getPassword().equals(password)){
                resp = LoginDto.builder()
                        .id(member.get().getLoginId())
                        .password(member.get().getPassword())
                        .role(member.get().getRole())
                        .success(true)
                        .build();
            }
            else{
                resp = LoginDto.builder()
                        .id(member.get().getLoginId())
                        .password(member.get().getPassword())
                        .role(member.get().getRole())
                        .success(false)
                        .build();
            }
        }


        log.info("로그인 시도 : {}", resp);

        return resp;
    }

    public ResponseDto userRegistration(Member recv){
        log.info(recv.toString());
        memberRepository.findAll().forEach(member -> {
            if(member.getLoginId().equals(recv.getLoginId()))
                KDDError.LOGIN_ID_EXISTS.doThrow();
        });

        memberRepository.save(recv);

        return ResponseDto.builder().statusCode(200).reason("Success").build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
