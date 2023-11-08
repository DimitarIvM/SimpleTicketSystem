package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.AllTicketsDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketSubmitDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketViewDTO;
import bg.softuni.stssoftuniproject.model.entity.Ticket;
import bg.softuni.stssoftuniproject.repository.TicketRepository;
import bg.softuni.stssoftuniproject.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;


    private final ModelMapper modelMapper;

    public TicketServiceImpl(TicketRepository ticketRepository,  ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;


        this.modelMapper = modelMapper;
    }


    @Override
    public void submitTicket(TicketSubmitDTO ticketSubmitDTO) {

        Ticket ticket = modelMapper.map(ticketSubmitDTO, Ticket.class);

        ticketRepository.save(ticket);
    }

    @Override
    public TicketViewDTO getTicketById(Long id) {

        Ticket ticket = this.ticketRepository.findById(id).get();


        return modelMapper.map(ticket, TicketViewDTO.class);
    }



    @Override
    public AllTicketsDTO getAllById(Long id) {

        AllTicketsDTO allTicketsDTO = new AllTicketsDTO();


        return allTicketsDTO;



    }

    @Override
    public void saveNotes(TicketViewDTO ticketViewDTO) {

        Ticket ticket = this.findById(ticketViewDTO.getId());


            ticket.setNotes(ticketViewDTO.getNotes());




        this.ticketRepository.save(ticket);
    }

    private Ticket findById(Long id) {
            return this.ticketRepository.findById(id).isPresent() ? this.ticketRepository.findById(id).get(): null;
    }


}
