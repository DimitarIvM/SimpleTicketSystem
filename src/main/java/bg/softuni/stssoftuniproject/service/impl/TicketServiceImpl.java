package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.*;
import bg.softuni.stssoftuniproject.model.entity.Priority;
import bg.softuni.stssoftuniproject.model.entity.Product;
import bg.softuni.stssoftuniproject.model.entity.Ticket;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.repository.TicketRepository;
import bg.softuni.stssoftuniproject.service.PriorityService;
import bg.softuni.stssoftuniproject.service.ProductService;
import bg.softuni.stssoftuniproject.service.TicketService;
import bg.softuni.stssoftuniproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    private final PriorityService priorityService;
    private final UserService userService;

    private final ProductService productService;

    private final ModelMapper modelMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, PriorityService priorityService, UserService userService, ProductService productService, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.priorityService = priorityService;
        this.userService = userService;
        this.productService = productService;


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
    public AllTicketsDTO getAllAvailableTickets() {

        AllTicketsDTO allTicketsDTO = new AllTicketsDTO();

        List<Ticket> all = this.ticketRepository.findAllByOrderByIdAsc();

        Set<TicketDTO> allTickets = new LinkedHashSet<>();

        for (Ticket ticket : all) {

            allTickets.add(modelMapper.map(ticket,TicketDTO.class));
        }

        allTicketsDTO.setTickets(allTickets);

        return allTicketsDTO;
    }

@Override
    public Ticket findById(Long id) {
        return this.ticketRepository.findById(id).isPresent() ? this.ticketRepository.findById(id).get() : null;
    }

    @Override
    public void saveAnswer(TicketAnswerDTO ticketAnswerDTO) {

        Ticket ticketEntity = this.findById(ticketAnswerDTO.getId());

        Priority priority = this.priorityService.findByName(ticketAnswerDTO.getPriority());

        Set<Product> products = this.productService.findAllBySerialNumber(ticketAnswerDTO.getProduct());
        UserEntity assignee = this.userService.getLoggedUser();

        ticketEntity.setPriority(null);

        ticketEntity.setNotes(ticketAnswerDTO.getNotes());
        ticketEntity.setModified(LocalDateTime.now());
        ticketEntity.setPriority(priority);
        ticketEntity.setTicketAssignee(assignee);
        ticketEntity.setProduct(products);

        ticketRepository.save(ticketEntity);

    }

    @Override
    public void deleteOldTickets() {

        List<Ticket> allTickets = this.ticketRepository.findAll();

        for (Ticket ticket : allTickets) {
            LocalDateTime now = LocalDateTime.now();
            if (ticket.getModified().isBefore(now.minusDays(100))){
                ticketRepository.delete(ticket);
            }
        }


    }

    @Override
    public List<Object[]> findTicketsForProduct(String serialNumber) {
        return ticketRepository.findAllByProductSerialNumber(serialNumber)
                .stream()
                .toList();
    }




}
