package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.dto.TicketSubmitDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketViewDTO;

public interface TicketService {
    void submitTicket(TicketSubmitDTO ticketSubmitDTO);

    TicketViewDTO getTicketById(Long id);
}
