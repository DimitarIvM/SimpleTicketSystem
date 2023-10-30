package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.dto.TicketSubmitDTO;

public interface TicketService {
    void submitTicket(TicketSubmitDTO ticketSubmitDTO);
}
