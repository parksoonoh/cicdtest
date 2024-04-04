package cicd.cicdtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CICDTestController {
    @GetMapping("/")
    public String homepage(){
        return "This is second Home Page";
    }
    @GetMapping("/hello")
    public String helloPage(){
        return "Hello World!";
    }

    @GetMapping("/hashing_master")
    public String specialPage(){
        return "You are hashing master!";
    }
}
