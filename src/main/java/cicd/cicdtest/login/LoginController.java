package cicd.cicdtest.login;

import cicd.cicdtest.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/signup")
    public String signUp(@ModelAttribute("member")Member member){
        return "/member/addForm";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute Member member){
        loginService.signUp(member);
        return "redirect:/";
    }


    @GetMapping("/login")
    public String loginGet(@ModelAttribute("loginForm")LoginForm form) {
        return "/loginPage";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute LoginForm form, HttpServletRequest request, Model model){
        String result = loginService.login(form, request, model);
        if (result.equals("Login Success")){
            return "/click";
        }
        return "redirect:/";
    }

}