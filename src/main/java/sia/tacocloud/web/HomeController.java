package sia.tacocloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        System.out.println("home page....");
        System.out.println("home page 2....");
        return "home";
    }
}

