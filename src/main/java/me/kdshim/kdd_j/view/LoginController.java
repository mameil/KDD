package me.kdshim.kdd_j.view;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.kdshim.kdd_j.member.Member;
import me.kdshim.kdd_j.member.MemberRepository;
import me.kdshim.kdd_j.member.MemberService;
import me.kdshim.kdd_j.member.ROLE;
import me.kdshim.kdd_j.view.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/login")
    public String loginController(){
        return "login";
    }

    @PostMapping("/login/validation")
    public String loginValidation(@ModelAttribute LoginDto loginDto){
        LoginDto resp = memberService.loginValidation(loginDto);
        if(resp.isSuccess() && resp.getRole() == ROLE.ADMIN)
            return "redirect:/admin";

        return resp.isSuccess() ? "redirect:/main" : "redirect:/login";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/user/registration")
    public String userRegistration(@ModelAttribute Member member){
        member.setRole(ROLE.USER);
        memberRepository.save(member);
        return "login";
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
