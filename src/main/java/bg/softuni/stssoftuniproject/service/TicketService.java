package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.dto.AllTicketsDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketSubmitDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketViewDTO;

public interface TicketService {
    void submitTicket(TicketSubmitDTO ticketSubmitDTO);

    TicketViewDTO getTicketById(Long id);

    AllTicketsDTO getAllById(Long id);

    void saveNotes(TicketViewDTO ticketViewDTO);


    AllTicketsDTO getAllAvailableTickets();
}
