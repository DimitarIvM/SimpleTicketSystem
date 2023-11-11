package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.AllTicketsDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketSubmitDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketViewDTO;
import bg.softuni.stssoftuniproject.model.entity.Ticket;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.repository.TicketRepository;
import bg.softuni.stssoftuniproject.service.TicketService;
import bg.softuni.stssoftuniproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    private final UserService userService;

    private final ModelMapper modelMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, UserService userService, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.userService = userService;


        this.modelMapper = modelMapper;
    }


    @Override
    public void submitTicket(TicketSubmitDTO ticketSubmitDTO) {

        Ticket ticket = modelMapper.map(ticketSubmitDTO, Ticket.class);

        UserEntity userEntity = userService.getLoggedUser();
        ticket.setClient(userEntity);


        ticketRepository.save(ticket);
    }

    @Override
    public TicketViewDTO getTicketById(Long id) {

        Ticket ticket = this.ticketRepository.findById(id).get();


        return modelMapper.map(ticket, TicketViewDTO.class);
    }


    @Override
    public AllTicketsDTO getAllById(Long userId) {

        AllTicketsDTO allTicketsDTO = new AllTicketsDTO();

        Set<Ticket> allByClient = this.ticketRepository.findAllByClientId(userId);
        Set<TicketDTO> ticketDTOS = new HashSet<>();
        for (Ticket ticket : allByClient) {

            ticketDTOS.add(modelMapper.map(ticket, TicketDTO.class));
        }

        allTicketsDTO.setTickets(ticketDTOS);

        return allTicketsDTO;

    }

    @Override
    public void saveNotes(TicketViewDTO ticketViewDTO) {

        Ticket ticket = this.findById(ticketViewDTO.getId());

        if (ticketViewDTO.getNotes() != null) {
            ticket.setNotes(ticketViewDTO.getNotes());
        }


        this.ticketRepository.save(ticket);
    }

    @Override
    public AllTicketsDTO getAllAvailableTickets() {

        AllTicketsDTO allTicketsDTO = new AllTicketsDTO();

        List<Ticket> all = this.ticketRepository.findAll();

        Set<TicketDTO> allTickets = new HashSet<>();

        for (Ticket ticket : all) {

            allTickets.add(modelMapper.map(ticket,TicketDTO.class));
        }

        allTicketsDTO.setTickets(allTickets);

        return allTicketsDTO;
    }


    private Ticket findById(Long id) {
        return this.ticketRepository.findById(id).isPresent() ? this.ticketRepository.findById(id).get() : null;
    }


}
