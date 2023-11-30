package bg.softuni.stssoftuniproject.utils.scheduled;

import bg.softuni.stssoftuniproject.service.TicketService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeleteOldTicketsScheduler {

    private final TicketService ticketService;

    public DeleteOldTicketsScheduler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void deleteOldTickets(){

        this.ticketService.deleteOldTickets();


    }
}
