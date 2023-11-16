package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.dto.AllUsersDTO;
import bg.softuni.stssoftuniproject.model.dto.UserRegisterDTO;
import bg.softuni.stssoftuniproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/all")
    public ModelAndView getAllUsers(){

 return new ModelAndView("users-all");

    }

    @GetMapping("/login")
    public ModelAndView login() {

        return new ModelAndView("login");

    }

    @PostMapping("/users/login-error")
    public String onFailure(
          ) {




        return "login";
    }
    @GetMapping("/register")
    public ModelAndView register() {

        return new ModelAndView("register");

    }


    @PostMapping("/register")
    public ModelAndView register(@Valid UserRegisterDTO userRegisterDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            bindingResult.addError(new FieldError(
                    "passwordNotMatched",
                    "confirmPassword",
                    "Password must be the same"));
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);

            return new ModelAndView("redirect:/users/register");

        }

        userService.register(userRegisterDTO);


        return new ModelAndView("redirect:/users/login");

    }

    @ModelAttribute
    public UserRegisterDTO userRegisterDTO() {

        return new UserRegisterDTO();
    }
}
