package cicd.cicdtest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CICDTestController {
    private int count = 0;
    private final CICDTestService cicdTestService;
    @GetMapping("/")
    public String homepage(){
        return "mainPage";
    }

    @GetMapping("/increase")
    public String increase(Model model, HttpServletRequest request){
        return cicdTestService.increase(model, request);
    }
}
