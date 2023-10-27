package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.dto.ClientRegistrationDTO;
import bg.softuni.stssoftuniproject.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clients")
public class ClientController {
//TODO: find a way to associate with company
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/register")
    public ModelAndView register(){

      return   new ModelAndView("client-register");
    }

    @PostMapping("/register")
    public ModelAndView register(ClientRegistrationDTO clientRegistrationDTO){

        this.clientService.register(clientRegistrationDTO);

        return   new ModelAndView("client-register");
    }

    @ModelAttribute
    public ClientRegistrationDTO clientRegistrationDTO(){
        return new ClientRegistrationDTO();
    }
}
