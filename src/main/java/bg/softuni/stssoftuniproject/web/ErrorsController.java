package bg.softuni.stssoftuniproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorsController {

    @PostMapping("/login-error")
    public ModelAndView loginError(){
        return new ModelAndView("login-error");
    }
}
