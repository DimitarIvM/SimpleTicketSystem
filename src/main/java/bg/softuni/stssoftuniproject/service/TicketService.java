package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.dto.*;
import bg.softuni.stssoftuniproject.model.entity.Ticket;

import java.util.List;

public interface TicketService {
    void submitTicket(TicketSubmitDTO ticketSubmitDTO);

    TicketViewDTO getTicketById(Long id);

    AllTicketsDTO getAllById(Long id);




    AllTicketsDTO getAllAvailableTickets();

    Ticket findById(Long id);

    void saveAnswer(TicketAnswerDTO ticketAnswerDTO);

    void deleteOldTickets();

    List<Object[]> findTicketsForProduct(String serialNumber);


}
