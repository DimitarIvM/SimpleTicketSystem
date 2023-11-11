package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.dto.*;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.service.TicketService;
import bg.softuni.stssoftuniproject.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketController {

    private final TicketService ticketService;
    private final UserService userService;

    public TicketController(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @GetMapping("/tickets/all")
    public ModelAndView getAllTickets(){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("all-tickets");

        AllTicketsDTO allAvailableTicketsDTO = ticketService.getAllAvailableTickets();

        mv.addObject("allAvailableTicketsDTO",allAvailableTicketsDTO);

        return mv;


    }

    @GetMapping("/tickets")
    public ModelAndView getAllTicketsForUser(){
        ModelAndView mv = new ModelAndView();

        AllTicketsDTO allTicketsDTO = this.ticketService.getAllById(userService.getLoggedUser().getId());


        mv.setViewName("tickets");

        mv.addObject("allTicketsForUser",allTicketsDTO);

        return mv;


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


    @GetMapping("/ticket/{id}")
public ModelAndView viewTicketForEmployee(@PathVariable("id") Long id){

        ModelAndView mv = new ModelAndView();

        mv.setViewName("ticket-view");

        TicketViewDTO ticketViewDTO = ticketService.getTicketById(id);

        mv.addObject("ticketViewDTO",ticketViewDTO);

        return mv;

    }

    @PostMapping("/ticket/{id}")
    public ModelAndView postTicket(@PathVariable("id") Long ticketId){

        ModelAndView mv = new ModelAndView();

        mv.setViewName("ticket-view");
        TicketViewDTO  ticketViewDTO = ticketService.getTicketById(ticketId);


       this.ticketService.saveNotes(ticketViewDTO);

        mv.setViewName("redirect:/ticket/{id}");

        return mv;

    }

    @ModelAttribute
    public TicketSubmitDTO ticketSubmitDTO(){

        return new TicketSubmitDTO();
    }
}
