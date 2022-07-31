package me.kdshim.kdd_j.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import me.kdshim.kdd_j.member.Member;
import me.kdshim.kdd_j.member.MemberRepository;
import me.kdshim.kdd_j.member.MemberService;
import me.kdshim.kdd_j.member.ROLE;
import me.kdshim.kdd_j.view.dto.LoginDto;
import me.kdshim.kdd_j.view.dto.ResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String loginValidation(@ModelAttribute LoginDto loginDto){
        LoginDto resp = memberService.loginValidation(loginDto);
        if(resp.isSuccess() && resp.getRole() == ROLE.ADMIN)
            return "redirect:/admin";

        return resp.isSuccess() ? "redirect:/main" : "redirect:/login";
    }

    @GetMapping("/home/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/home/user/registration")
    @ResponseBody
    public ResponseDto userRegistration(@RequestBody Member member) {
        member.setRole(ROLE.USER);
        ResponseDto responseDto;
        try{
            responseDto = memberService.userRegistration(member);

            //TEST
        }
        catch (RuntimeException e){
            return ResponseDto.builder().statusCode(400).reason(e.getMessage()).build();
        }
        return responseDto;
    }

    @GetMapping("/home/forget")
    public String forget(){return "forget";}



    @GetMapping("/home/main")
    public String mainController(){
        return "main";
    }

    @GetMapping("/home/admin")
    public String adminController(){
        return "adminPage";
    }
}
