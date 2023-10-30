package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.TicketSubmitDTO;
import bg.softuni.stssoftuniproject.model.entity.Ticket;
import bg.softuni.stssoftuniproject.repository.TicketRepository;
import bg.softuni.stssoftuniproject.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
private final ModelMapper modelMapper;
    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void submitTicket(TicketSubmitDTO ticketSubmitDTO) {
        this.ticketRepository.save(modelMapper.map(ticketSubmitDTO, Ticket.class));
    }
}
