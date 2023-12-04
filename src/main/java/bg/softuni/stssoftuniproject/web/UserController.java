package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.dto.AllUsersDTO;

import bg.softuni.stssoftuniproject.model.dto.UserRegisterDTO;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

        @GetMapping("/all")
    public ModelAndView getAllUsers() {


        ModelAndView mv = new ModelAndView();

        AllUsersDTO allUsersDTO = this.userService.getAllUsers();

        mv.setViewName("users-all");
        mv.addObject("allUsersDTO", allUsersDTO);

        return mv;

    }


    @PostMapping("/promote-admin-role")
    public ModelAndView grantAdminRole(@RequestParam("userId") Long userId) {
       Optional <UserEntity> user =    userService.getById(userId);

       this.userService.makeAdmin(user.get());

        return new ModelAndView("redirect:/users/all");
    }



    @GetMapping("/login")
    public ModelAndView login() {


        return new ModelAndView("login");

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
