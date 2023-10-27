package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.dto.CompanyRegisterDTO;
import bg.softuni.stssoftuniproject.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/register")
    public ModelAndView register(){

        return new ModelAndView("company-register");

    }

    @PostMapping("/register")
    public ModelAndView register(CompanyRegisterDTO companyRegisterDTO){

        companyService.register(companyRegisterDTO);

        return new ModelAndView("index");

    }

    @ModelAttribute
    public CompanyRegisterDTO companyRegisterDTO()
    {
        return new CompanyRegisterDTO();
    }
}
