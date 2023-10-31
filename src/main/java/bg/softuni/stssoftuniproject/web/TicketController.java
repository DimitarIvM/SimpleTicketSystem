package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.dto.TicketSubmitDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketViewDTO;
import bg.softuni.stssoftuniproject.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketController {

    private final TicketService ticketService;
//TODO: add product
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/ticket-submit")
    public ModelAndView submitTicket(){

        return new ModelAndView("submit-ticket");

    }

    @PostMapping("/ticket-submit")
    public ModelAndView submitTicket(TicketSubmitDTO ticketSubmitDTO){

        this.ticketService.submitTicket(ticketSubmitDTO);


        return new ModelAndView("redirect:/");

    }


    @GetMapping("ticket/{id}")
public ModelAndView viewTicket(@PathVariable("id") Long id){

        ModelAndView mv = new ModelAndView();

        mv.setViewName("ticket-view");

        TicketViewDTO ticketViewDTO = ticketService.getTicketById(id);

        mv.addObject("ticketViewDTO",ticketViewDTO);

        return mv;

    }


    @ModelAttribute
    public TicketSubmitDTO ticketSubmitDTO(){

        return new TicketSubmitDTO();
    }
}
