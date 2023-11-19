package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.dto.AllTicketsDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketAnswerDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketSubmitDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketViewDTO;
import bg.softuni.stssoftuniproject.model.entity.Ticket;

public interface TicketService {
    void submitTicket(TicketSubmitDTO ticketSubmitDTO);

    TicketViewDTO getTicketById(Long id);

    AllTicketsDTO getAllById(Long id);




    AllTicketsDTO getAllAvailableTickets();

    Ticket findById(Long id);

    void saveAnswer(TicketAnswerDTO ticketAnswerDTO);

    void deleteOldTickets();
}
