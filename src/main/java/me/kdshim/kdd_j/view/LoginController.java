package me.kdshim.kdd_j.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.member.Member;
import me.kdshim.kdd_j.member.MemberService;
import me.kdshim.kdd_j.member.ROLE;
import me.kdshim.kdd_j.view.dto.ForgetDto;
import me.kdshim.kdd_j.view.dto.LoginDto;
import me.kdshim.kdd_j.view.dto.ResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;
    private final ObjectMapper objectMapper;

    @GetMapping("/login")
    public String loginController(){
        return "login";
    }

    @PostMapping("/login/validation")
    public String loginValidation(LoginDto loginDto){
        LoginDto resp = (LoginDto) memberService.loadUserByUsername(loginDto.getUsername(), loginDto.getPassword());
        if(resp.isSuccess() && resp.getRole() == ROLE.ADMIN)
            return "redirect:/admin";

        return resp.isSuccess() ? "redirect:/index.html" : "redirect:/login";
    }

    @GetMapping("/login/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/login/user/registration")
    @ResponseBody
    public ResponseDto userRegistration(@RequestBody Member member) {
        member.setRole(ROLE.USER);
        ResponseDto responseDto;
        try{
            responseDto = memberService.userRegistration(member);
        }
        catch (RuntimeException e){
            return ResponseDto.builder().statusCode(400).reason(e.getMessage()).build();
        }
        return responseDto;
    }

    @GetMapping("/login/forget")
    public String forget(){return "forget";}

    @PostMapping("/login/find/member")
    @ResponseBody
    public Member userForget(@RequestBody ForgetDto forgetDto){
        Member singleMemberByUsername = memberService.findFirstMemberByUsername(forgetDto.getUserName());

//        if(!singleMemberByUsername.getBirthDateYYYYMMDD().equals(forgetDto.getBirthDateYYYYMMDD())){
//
//        }

        return singleMemberByUsername;
    }



    @GetMapping("/main")
    public String mainController(){
        return "main";
    }

    @GetMapping("/admin")
    public String adminController(){
        return "adminPage";
    }
}
