package cicd.cicdtest.login;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/signup")
    public String signUp(){
        return loginService.signUp();
    }

    @PostMapping("/login")
    public String login() {
        return loginService.login();
    }

}