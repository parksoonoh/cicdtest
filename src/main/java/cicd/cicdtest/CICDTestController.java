package cicd.cicdtest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CICDTestController {
    private int count = 0;
    @GetMapping("/")
    public String homepage(){
        return "mainPage";
    }
    @GetMapping("/click")
    public String click(Model model){
        model.addAttribute("count", count);
        count++;
        return "click";
    }
}
