package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.dto.EmployeeRegisterDTO;
import bg.softuni.stssoftuniproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView register() {

        return new ModelAndView("register");

    }


    @PostMapping("/register")
    public ModelAndView register(@Valid EmployeeRegisterDTO employeeRegisterDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (!employeeRegisterDTO.getPassword().equals(employeeRegisterDTO.getConfirmPassword())) {
            bindingResult.addError(new FieldError(
                    "passwordNotMatched",
                    "confirmPassword",
                    "Password must be the same"));
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("employeeRegisterDTO", employeeRegisterDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.employeeRegisterDTO", bindingResult);

            return new ModelAndView("redirect:/employees/register");

        }

        userService.register(employeeRegisterDTO);


        return new ModelAndView("redirect:/employees/login");

    }

    @ModelAttribute
    public EmployeeRegisterDTO employeeRegisterDTO() {

        return new EmployeeRegisterDTO();
    }
}
