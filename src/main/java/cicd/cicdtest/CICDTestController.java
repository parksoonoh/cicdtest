package cicd.cicdtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CICDTestController {
    @GetMapping("/")
    public String homepage(){
        return "This is Home Page";
    }
    @GetMapping("/hello")
    public String helloPage(){
        return "Hello World!";
    }
}
