package bg.softuni.stssoftuniproject.model.dto;

import bg.softuni.stssoftuniproject.model.entity.Ticket;

import java.util.List;
import java.util.Set;

public class AllTicketsDTO {

  private   Set<TicketDTO> tickets;


    public Set<TicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(Set<TicketDTO> tickets) {
        this.tickets = tickets;
    }
}
